package ir.Geotech_co.batman.app.network;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.nio.charset.Charset;

import ir.Geotech_co.batman.utils.Utils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;
import timber.log.Timber;


public class ConnectivityInterceptor implements Interceptor {

    private Context mContext;

    public ConnectivityInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (!Utils.isNetworkAvailable(mContext)) {
            throw new NoConnectivityException();
        }


        Request request = chain.request();

        Request.Builder builder = chain.request().newBuilder();

        Response proceed = chain.proceed(builder.build());


        BufferedSource source = proceed.body().source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));
        Timber.d(request.url().toString(), "responseBodyString : " + responseBodyString);
        Timber.d( "response status code : " + proceed.code());

        return proceed;
    }

}