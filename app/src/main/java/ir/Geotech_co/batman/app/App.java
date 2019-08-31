package ir.Geotech_co.batman.app;

import com.facebook.drawee.backends.pipeline.Fresco;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ir.Geotech_co.batman.BuildConfig;
import ir.Geotech_co.batman.utils.CrashlyticsLogExceptionTree;
import timber.log.Timber;

public final class App extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
        Fresco.initialize(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AndroidInjector<App> androidInjector = DaggerAppComponent.builder().create(this);
        androidInjector.inject(this);
        return androidInjector;
    }

    private void initTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        else
            Timber.plant(new CrashlyticsLogExceptionTree());

    }

}
