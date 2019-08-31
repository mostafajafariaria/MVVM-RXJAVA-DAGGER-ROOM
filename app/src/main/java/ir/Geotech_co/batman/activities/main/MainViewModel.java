package ir.Geotech_co.batman.activities.main;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

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

public class MainViewModel extends BaseViewModel {


    MainViewModel(@NonNull AppRest restManager, @NonNull AppPreferences prefManager, @NonNull IDatabaseManager databaseManager,
                  @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade, @NonNull SingleLiveData<Integer> toastLiveData) {
        super(restManager, prefManager, databaseManager, compositeDisposable, schedulersFacade, toastLiveData);
    }

    private MutableLiveData<List<FilmModel>> allFilms = new MutableLiveData<>();


    void requestAllFilms(String apiKey, String appName) {
        Disposable disposable = mRestManager.getAllFilms(apiKey, appName).
                retry(new DefaultRetrofitRetryHandler())
                .subscribeOn(mSchedulersFacade.io())
                .observeOn(mSchedulersFacade.ui())
                .subscribe(r ->
                        {
                            Timber.d("response success get all films : " + r);
                            allFilms.setValue(r.getFilmModels());
                        },
                        new RxRetrofitErrorConsumer() {
                            @Override
                            public void handleError(Throwable throwable, int id) {
                                Timber.e("error response all films : " + throwable.getMessage());
                                mToastLiveData.setValue(id);
                                if (throwable instanceof NoConnectivityException)
                                    getAllFilsAsDatabase();
                            }
                        });
        mCompositeDisposable.add(disposable);
    }

    void insertLocationsToDB(List<FilmModel> films) {

        if (films != null && films.size() > 0) {
            for (FilmModel model : films) {
                if (mDatabaseManager.findFilmById(model.getImdbID()) == null) {
                    DbFilmModel dbFilmModel = new DbFilmModel();
                    if (model.getYear() != null)
                        dbFilmModel.setYear(model.getYear());
                    if (model.getTitle() != null)
                        dbFilmModel.setTitle(model.getTitle());

                    if (model.getImdbID() != null)
                        dbFilmModel.setImdbID(model.getImdbID());

                    if (model.getType() != null)
                        dbFilmModel.setType(model.getType());

                    if (model.getPoster() != null)
                        dbFilmModel.setPoster(model.getPoster());

                    mDatabaseManager.insert(dbFilmModel);


                }
            }
        }

    }

    private void getAllFilsAsDatabase() {
        List<FilmModel> filmModels = new ArrayList<>();

        if (mDatabaseManager.getAllFilms() != null && mDatabaseManager.getAllFilms().size() > 0)
            for (DbFilmModel model : mDatabaseManager.getAllFilms()
            ) {
                FilmModel filmModel= new FilmModel();
                if (model.getYear() != null)
                    filmModel.setYear(model.getYear());
                if (model.getTitle() != null)
                    filmModel.setTitle(model.getTitle());

                if (model.getImdbID() != null)
                    filmModel.setImdbID(model.getImdbID());

                if (model.getType() != null)
                    filmModel.setType(model.getType());

                if (model.getPoster() != null)
                    filmModel.setPoster(model.getPoster());
                filmModels.add(filmModel);

            }
        allFilms.setValue(filmModels);
    }

    MutableLiveData<List<FilmModel>> getAllFilms() {
        return allFilms;
    }
}
