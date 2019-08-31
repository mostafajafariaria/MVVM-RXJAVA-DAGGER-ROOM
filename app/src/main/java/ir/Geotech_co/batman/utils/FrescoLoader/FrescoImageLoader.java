package ir.Geotech_co.batman.utils.FrescoLoader;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


public class FrescoImageLoader {


    @SuppressWarnings("unused")
    public static void loadImage(Context context, String imageUri, final FrescoLoaderCallback callbacks) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();

        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(imageUri))
                .setRequestPriority(Priority.MEDIUM)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                .build();

        final DataSource<CloseableReference<CloseableImage>> dataSource =
                imagePipeline.fetchDecodedImage(imageRequest, context);

        try {
            dataSource.subscribe(new BaseBitmapDataSubscriber() {
                @Override
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    if (callbacks != null) {
                        if (bitmap != null) {
                            callbacks.loadingFinished(bitmap);
                        } else
                            callbacks.failed();
                    }
                    if (dataSource != null) {
                        dataSource.close();
                    }
                }

                @Override
                public void onFailureImpl(DataSource dataSource) {
                    callbacks.failed();
                    if (dataSource != null) {
                        dataSource.close();
                    }
                }
            }, CallerThreadExecutor.getInstance());
        } catch (Exception ignored) {
            if (dataSource != null) {
                dataSource.close();
                callbacks.failed();
            }
        }
    }
}
