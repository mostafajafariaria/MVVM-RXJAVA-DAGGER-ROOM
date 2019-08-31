package ir.Geotech_co.batman.app.manager.pref;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPrefManager implements AppPreferences {

    private static final String PREF_API_KEY = "PREF_API_KEY";
    private static final String PREF_APP_NAME = "PREF_APP_NAME";


    @Inject
    SharedPreferences mPrefs;


    @Inject
    public AppPrefManager() {

    }

    @Override
    public String getPrefApiKey() {
        return mPrefs.getString(PREF_API_KEY, "3e974fca");
    }

    @Override
    public void setPrefApiKey(String apiKey) {
        mPrefs.edit().putString(PREF_API_KEY, apiKey).apply();
    }

    @Override
    public String getPrefAppName() {
        return mPrefs.getString(PREF_API_KEY, "batman");
    }

    @Override
    public void setPrefAppName(String appName) {
        mPrefs.edit().putString(PREF_API_KEY, appName).apply();
    }
}
