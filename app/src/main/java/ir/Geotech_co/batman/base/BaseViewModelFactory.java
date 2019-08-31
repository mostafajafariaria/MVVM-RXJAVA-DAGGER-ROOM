package ir.Geotech_co.batman.base;


import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ir.Geotech_co.batman.app.dataBase.IDatabaseManager;
import ir.Geotech_co.batman.app.manager.pref.AppPreferences;
import ir.Geotech_co.batman.app.manager.rest.AppRest;
import ir.Geotech_co.batman.utils.SchedulersFacade;
import ir.Geotech_co.batman.utils.SingleLiveData;

public abstract class BaseViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    protected AppPreferences mPrefManager;
    @Inject
    protected AppRest mRestManager;
    @Inject
    protected IDatabaseManager mDataBaseManager;
    @Inject
    protected SchedulersFacade mSchedulersFacade;
    @Inject
    protected CompositeDisposable mDisposables;
    @Inject
    protected SingleLiveData<Integer> mToastLiveData;

}
