package ir.Geotech_co.batman.app;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import ir.Geotech_co.batman.app.dataBase.DatabaseManager;
import ir.Geotech_co.batman.app.dataBase.IDatabaseManager;
import ir.Geotech_co.batman.app.manager.pref.AppPrefManager;
import ir.Geotech_co.batman.app.manager.pref.AppPreferences;
import ir.Geotech_co.batman.app.manager.pref.SharedPrefModule;
import ir.Geotech_co.batman.app.manager.rest.AppRest;
import ir.Geotech_co.batman.app.manager.rest.AppRestManager;
import ir.Geotech_co.batman.app.network.NetworkModule;
import ir.Geotech_co.batman.utils.SingleLiveData;

@Module(includes = {NetworkModule.class, SharedPrefModule.class})
public abstract class AppModule {

    @Binds
    @Singleton
    abstract AppPreferences providePrefManager(AppPrefManager prefManager);

    @Binds
    @Singleton
    abstract AppRest provideRestManager(AppRestManager prefManager);

    @Binds
    @Singleton
    abstract IDatabaseManager provideDatabase(DatabaseManager databaseManager);

    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    static SingleLiveData<Integer> provideIntegerSingleLiveData() {
        return new SingleLiveData<>();
    }

}
