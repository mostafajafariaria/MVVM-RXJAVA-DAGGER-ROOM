package ir.Geotech_co.batman.app.network;

import android.support.annotation.StringRes;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

class RetrofitErrorHandler {

    @SuppressWarnings("WeakerAccess")

    public static @StringRes
    int getError(Throwable error){
        if (error instanceof TimeoutException || error instanceof InterruptedIOException)
            return ir.Geotech_co.batman.R.string.time_out_error;
        else if (error instanceof ConnectException)
            return ir.Geotech_co.batman.R.string.connection_error;
        else if (error instanceof NoSuchElementException)
            return ir.Geotech_co.batman.R.string.single_no_item_emitted_error;
        else if (error instanceof IllegalArgumentException)
            return ir.Geotech_co.batman.R.string.data_receive_error;
        else
            return ir.Geotech_co.batman.R.string.server_error;
    }
}
