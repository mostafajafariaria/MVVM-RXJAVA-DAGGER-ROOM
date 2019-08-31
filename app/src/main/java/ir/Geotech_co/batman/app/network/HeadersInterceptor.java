package ir.Geotech_co.batman.app.network;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import ir.Geotech_co.batman.BuildConfig;
import ir.Geotech_co.batman.utils.Utils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeadersInterceptor implements Interceptor {


    @Inject
    public HeadersInterceptor() {
    }


    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request request = chain.request().newBuilder().
                addHeader("os_type", "1")
                .addHeader("content_type", "application/json")
                .addHeader("os_version", Utils.getAndroidVersion())
                .addHeader("app_version", String.valueOf(BuildConfig.VERSION_CODE))
                .build();
        return chain.proceed(request);
    }
}
