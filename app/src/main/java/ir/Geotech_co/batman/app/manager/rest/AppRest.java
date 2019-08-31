package ir.Geotech_co.batman.app.manager.rest;

import io.reactivex.Observable;
import ir.Geotech_co.batman.model.FilmModel;
import ir.Geotech_co.batman.model.ListFilmModel;

public interface AppRest {

    Observable<ListFilmModel> getAllFilms(String apiKey, String appName);

    Observable<FilmModel> getFilm(String apiKey, String imdbId);

}
