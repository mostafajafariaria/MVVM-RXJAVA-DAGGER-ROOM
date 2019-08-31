package ir.Geotech_co.batman.utils.FrescoLoader;

import android.graphics.Bitmap;

public interface FrescoLoaderCallback {

    void loadingFinished(Bitmap bitmap);

    void failed();
}
