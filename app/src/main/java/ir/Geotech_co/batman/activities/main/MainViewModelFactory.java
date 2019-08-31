package ir.Geotech_co.batman.activities.main;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import ir.Geotech_co.batman.base.BaseViewModelFactory;

public class MainViewModelFactory extends BaseViewModelFactory {

    @Inject
    MainViewModelFactory() {
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(mRestManager, mPrefManager, mDataBaseManager, mDisposables, mSchedulersFacade, mToastLiveData);
    }
}
