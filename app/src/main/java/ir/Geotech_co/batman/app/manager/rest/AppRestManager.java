package ir.Geotech_co.batman.app.manager.rest;

import javax.inject.Inject;

import io.reactivex.Observable;
import ir.Geotech_co.batman.model.FilmModel;
import ir.Geotech_co.batman.model.ListFilmModel;

public class AppRestManager implements AppRest {
    @Inject
    AppRestManager() {
    }

    @SuppressWarnings("WeakerAccess")
    @Inject
    MyClubApi myClubApi;

    @Override
    public Observable<ListFilmModel> getAllFilms(String apiKey, String appName) {
        return myClubApi.getAllFilms(apiKey, appName);
    }

    @Override
    public Observable<FilmModel> getFilm(String apiKey, String imdbId) {
        return myClubApi.getFilm(apiKey , imdbId);
    }
}
