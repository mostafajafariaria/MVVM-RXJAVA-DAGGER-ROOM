package ir.Geotech_co.batman.app.manager.rest;

import io.reactivex.Observable;
import ir.Geotech_co.batman.model.FilmModel;
import ir.Geotech_co.batman.model.ListFilmModel;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyClubApi {

    @GET("/")
    Observable<ListFilmModel> getAllFilms(@Query("apikey") String apiKey, @Query("s") String appName);

    @GET("/")
    Observable<FilmModel> getFilm(@Query("apikey") String apiKey, @Query("i") String imdbId);

}
