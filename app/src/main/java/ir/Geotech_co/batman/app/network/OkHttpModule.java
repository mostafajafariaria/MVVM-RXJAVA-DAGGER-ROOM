package ir.Geotech_co.batman.app.network;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.Geotech_co.batman.BuildConfig;
import ir.Geotech_co.batman.app.App;
import ir.Geotech_co.batman.utils.Utils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

@SuppressWarnings("WeakerAccess")
@Module
public class OkHttpModule {
    private static final String CACHE_CONTROL = "Cache-Control";

    @Provides
    static Cache provideCache(App context) {
        return new Cache(new File(context.getCacheDir(), "http-cache"), 10 * 1024 * 1024);
    }

    @SuppressWarnings("ConstantConditions")
    @Provides
    static HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.d(message));

        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? BODY : NONE);

        return httpLoggingInterceptor;
    }

    @Provides
    static Interceptor provideCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());
            // re-write response header to force use of cache
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(2, TimeUnit.MINUTES)
                    .build();

            return response.newBuilder()
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }

    @Provides
    static ConnectivityInterceptor provideConnectivityInterceptor(App context) {
        return new ConnectivityInterceptor(context);
    }

    @Provides
    static PrintJsonInterceptor providePrintJsonInterceptor() {
        return new PrintJsonInterceptor();
    }


    @Provides
    @Singleton
    static OkHttpClient provideClient(Cache cache,
                                      OfflineCacheInterceptor offlineCacheInterceptor,
                                      Interceptor onlineTempCache,
                                      HttpLoggingInterceptor loggingInterceptor,
                                      ConnectivityInterceptor connectivityInterceptor,
                                      PrintJsonInterceptor printJsonInterceptor,
                                      HeadersInterceptor headersInterceptor
    ) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)// Set connection timeout
                .readTimeout(40, TimeUnit.SECONDS)// Read timeout
                .writeTimeout(40, TimeUnit.SECONDS)// Write timeout
                .addInterceptor(loggingInterceptor)
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(printJsonInterceptor)
                .addInterceptor(headersInterceptor);

        if (Utils.isCatchEnabled())
            builder.addNetworkInterceptor(onlineTempCache)// Add a custom cache interceptor （ Explain later ）， Note that it needs to be used here. .addNetworkInterceptor
                    .addInterceptor(offlineCacheInterceptor)
                    .cache(cache);// Add cache

//        if (BuildConfig.DEBUG) {
//            builder.addNetworkInterceptor(new StethoInterceptor());
//        }

        return builder.build();

    }
}
