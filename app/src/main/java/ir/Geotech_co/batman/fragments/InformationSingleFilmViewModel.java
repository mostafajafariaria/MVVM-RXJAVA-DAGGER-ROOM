package ir.Geotech_co.batman.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ir.Geotech_co.batman.app.dataBase.IDatabaseManager;
import ir.Geotech_co.batman.app.manager.pref.AppPreferences;
import ir.Geotech_co.batman.app.manager.rest.AppRest;
import ir.Geotech_co.batman.app.network.DefaultRetrofitRetryHandler;
import ir.Geotech_co.batman.app.network.NoConnectivityException;
import ir.Geotech_co.batman.app.network.RxRetrofitErrorConsumer;
import ir.Geotech_co.batman.base.BaseViewModel;
import ir.Geotech_co.batman.dbModels.DbFilmModel;
import ir.Geotech_co.batman.model.FilmModel;
import ir.Geotech_co.batman.utils.SchedulersFacade;
import ir.Geotech_co.batman.utils.SingleLiveData;
import timber.log.Timber;

public class InformationSingleFilmViewModel extends BaseViewModel {

    //    private final MutableLiveData<FilmModel> filmModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<FilmModel> filmModelMutableLiveData = new MutableLiveData<>();
    private String imbdbId;

    public String getImbdbId() {
        return imbdbId;
    }

    public void setImbdbId(String imbdbId) {
        this.imbdbId = imbdbId;
    }

    InformationSingleFilmViewModel(@NonNull AppRest restManager, @NonNull AppPreferences prefManager, @NonNull IDatabaseManager databaseManager, @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade, @NonNull SingleLiveData<Integer> toastLiveData) {
        super(restManager, prefManager, databaseManager, compositeDisposable, schedulersFacade, toastLiveData);
    }

    void updateDbInformaion(FilmModel filmModel) {

        if (filmModel != null) {
            mDatabaseManager.updateFilm(filmModel.getRuntime(), filmModel.getCountry(),
                    filmModel.getReleased(), filmModel.getDirector(), filmModel.getWriter(),
                    filmModel.getActors(), filmModel.getGenre(), filmModel.getRated(),
                    filmModel.getPlot(), filmModel.getImdbID());
        }
    }

    private void getFilmAsDatabase() {
        DbFilmModel dbFilmModel = mDatabaseManager.findFilmById(imbdbId);
        if (dbFilmModel != null) {
            FilmModel filmModel = new FilmModel();
            filmModel.setRuntime(dbFilmModel.getRuntime());
            filmModel.setCountry(dbFilmModel.getCountry());
            filmModel.setReleased(dbFilmModel.getCountry());
            filmModel.setDirector(dbFilmModel.getDirector());
            filmModel.setWriter(dbFilmModel.getWriter());
            filmModel.setActors(dbFilmModel.getActors());
            filmModel.setGenre(dbFilmModel.getGenre());
            filmModel.setRated(dbFilmModel.getRated());
            filmModel.setPlot(dbFilmModel.getPlot());
            filmModelMutableLiveData.setValue(filmModel);
        }
    }


    void getFilmInformation(String apiKey, String imbdbId) {
        Disposable disposable = mRestManager.getFilm(apiKey, imbdbId).
                retry(new DefaultRetrofitRetryHandler())
                .subscribeOn(mSchedulersFacade.io())
                .observeOn(mSchedulersFacade.ui())
                .subscribe(r ->
                        {
                            Timber.d("response success get single Film : " + r);
                            filmModelMutableLiveData.setValue(r);
                        },
                        new RxRetrofitErrorConsumer() {
                            @Override
                            public void handleError(Throwable throwable, int id) {
                                Timber.e("error response all films : " + throwable.getMessage());
                                mToastLiveData.setValue(id);
                                if (throwable instanceof NoConnectivityException)
                                    getFilmAsDatabase();
                            }
                        });
        mCompositeDisposable.add(disposable);
    }

    public MutableLiveData<FilmModel> getFilmModelMutableLiveData() {
        return filmModelMutableLiveData;
    }
}
