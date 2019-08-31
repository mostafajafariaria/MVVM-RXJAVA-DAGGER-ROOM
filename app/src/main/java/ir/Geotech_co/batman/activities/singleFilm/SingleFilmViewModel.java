package ir.Geotech_co.batman.activities.singleFilm;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import ir.Geotech_co.batman.app.dataBase.IDatabaseManager;
import ir.Geotech_co.batman.app.manager.pref.AppPreferences;
import ir.Geotech_co.batman.app.manager.rest.AppRest;
import ir.Geotech_co.batman.base.BaseViewModel;
import ir.Geotech_co.batman.utils.SchedulersFacade;
import ir.Geotech_co.batman.utils.SingleLiveData;

public class SingleFilmViewModel extends BaseViewModel {


    SingleFilmViewModel(@NonNull AppRest restManager, @NonNull AppPreferences prefManager, @NonNull IDatabaseManager databaseManager,
                        @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade, @NonNull SingleLiveData<Integer> toastLiveData) {
        super(restManager, prefManager, databaseManager, compositeDisposable, schedulersFacade, toastLiveData);
    }

}
