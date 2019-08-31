package ir.Geotech_co.batman.activities.singleFilm;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import ir.Geotech_co.batman.base.BaseViewModelFactory;

public class SingleFilmViewModelFactory extends BaseViewModelFactory {

    @Inject
    SingleFilmViewModelFactory() {
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SingleFilmViewModel(mRestManager, mPrefManager, mDataBaseManager, mDisposables, mSchedulersFacade, mToastLiveData);
    }
}
