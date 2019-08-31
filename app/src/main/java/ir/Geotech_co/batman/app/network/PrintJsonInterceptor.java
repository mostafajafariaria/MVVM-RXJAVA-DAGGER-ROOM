package ir.Geotech_co.batman.app.network;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;
import timber.log.Timber;

public class PrintJsonInterceptor implements Interceptor {



    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        Timber.d("Body " + bodyToString(builder.build().body()));

        Response proceed = chain.proceed(builder.build());

        BufferedSource source = proceed.body().source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        String responseBodyString = buffer.clone().readString(Charset.forName("UTF-8"));

        Timber.d("RAW RESPONSE", responseBodyString);

        return proceed;
    }

    private static String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if(copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            return "did not work";
        }
    }
}
