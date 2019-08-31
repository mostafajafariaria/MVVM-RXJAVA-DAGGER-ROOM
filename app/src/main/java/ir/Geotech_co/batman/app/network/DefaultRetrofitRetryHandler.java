package ir.Geotech_co.batman.app.network;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.functions.BiPredicate;

public class DefaultRetrofitRetryHandler implements BiPredicate<Integer, Throwable> {
    private final int mInt;

    @SuppressWarnings("WeakerAccess")
    public DefaultRetrofitRetryHandler(int anInt) {
        mInt = anInt;
    }

    public DefaultRetrofitRetryHandler(){
        this(3);
    }

    @Override
    public boolean test(Integer integer, Throwable throwable) throws Exception {
        return integer < mInt &&
                (throwable instanceof SocketTimeoutException ||
                        throwable instanceof TimeoutException ||
                        throwable instanceof ConnectException ||
                        throwable instanceof UnknownHostException);
    }
}
