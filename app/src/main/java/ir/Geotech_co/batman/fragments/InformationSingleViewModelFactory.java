package ir.Geotech_co.batman.fragments;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import ir.Geotech_co.batman.base.BaseViewModelFactory;

public class InformationSingleViewModelFactory extends BaseViewModelFactory {

    @Inject
    InformationSingleViewModelFactory() {
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new InformationSingleFilmViewModel(mRestManager, mPrefManager, mDataBaseManager, mDisposables, mSchedulersFacade, mToastLiveData);
    }
}
