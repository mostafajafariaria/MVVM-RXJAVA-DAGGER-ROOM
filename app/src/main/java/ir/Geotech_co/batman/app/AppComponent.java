package ir.Geotech_co.batman.app;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        BuilderModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Biulder extends AndroidInjector.Builder<App> {
    }

    void inject(App app);

}
