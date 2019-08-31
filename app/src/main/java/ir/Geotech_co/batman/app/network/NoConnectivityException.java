package ir.Geotech_co.batman.app.network;

import java.io.IOException;


public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "connectivity exception";
    }

}