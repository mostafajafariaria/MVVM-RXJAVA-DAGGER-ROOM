package ir.Geotech_co.batman.app.manager.pref;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import dagger.Module;
import dagger.Provides;
import ir.Geotech_co.batman.app.App;

@Module
public abstract class SharedPrefModule {

    @Provides
    static SharedPreferences provideSharedPrefs(App context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
