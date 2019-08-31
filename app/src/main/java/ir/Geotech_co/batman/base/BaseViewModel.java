package ir.Geotech_co.batman.base;


import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import ir.Geotech_co.batman.app.dataBase.IDatabaseManager;
import ir.Geotech_co.batman.app.manager.pref.AppPreferences;
import ir.Geotech_co.batman.app.manager.rest.AppRest;
import ir.Geotech_co.batman.utils.SchedulersFacade;
import ir.Geotech_co.batman.utils.SingleLiveData;

public class BaseViewModel extends ViewModel {

    protected final AppRest mRestManager;
    protected final AppPreferences mPrefManager;
    protected final IDatabaseManager mDatabaseManager;
    protected final CompositeDisposable mCompositeDisposable;
    protected final SchedulersFacade mSchedulersFacade;
    protected final SingleLiveData<Integer> mToastLiveData;


    public BaseViewModel(@NonNull AppRest restManager,
                         @NonNull AppPreferences prefManager,
                         @NonNull IDatabaseManager databaseManager,
                         @NonNull CompositeDisposable compositeDisposable,
                         @NonNull SchedulersFacade schedulersFacade,
                         @NonNull SingleLiveData<Integer> toastLiveData) {
        this.mPrefManager = prefManager;
        this.mRestManager = restManager;
        this.mDatabaseManager = databaseManager;
        this.mCompositeDisposable = compositeDisposable;
        this.mSchedulersFacade = schedulersFacade;
        mToastLiveData = toastLiveData;
    }

    public SingleLiveData<Integer> getToastLiveData() {
        return mToastLiveData;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
        super.onCleared();
    }

    public String getApiKey() {
        return mPrefManager.getPrefApiKey();
    }

    public String getAppName() {
        return mPrefManager.getPrefAppName();
    }
}
