package ir.Geotech_co.batman.app.dataBase;

import java.util.List;

import ir.Geotech_co.batman.dbModels.DbFilmModel;

public interface IDatabaseManager {

    DbFilmModel findFilmById(String filmId);

    List<DbFilmModel> getAllFilms();

    void insert(DbFilmModel filmModel);

    void updateFilm(String runTime , String country , String Released , String director , String writer , String actor , String genre , String rated , String plot , String imdbId);

    void update(DbFilmModel model);

}
