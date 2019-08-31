package ir.Geotech_co.batman.app.dataBase;

import java.util.List;

import javax.inject.Inject;

import ir.Geotech_co.batman.app.App;
import ir.Geotech_co.batman.dbModels.DbFilmModel;

public class DatabaseManager implements IDatabaseManager {

    private AppDatabase database;

    @Inject
    public DatabaseManager(App context) {
        this.database = AppDatabase.getAppDataBase(context);
    }

    @Override
    public DbFilmModel findFilmById(String filmId) {
        return this.database.dataBaseDao().findFilmById(filmId);
    }

    @Override
    public List<DbFilmModel> getAllFilms() {
        return this.database.dataBaseDao().getAllFilms();
    }


    @Override
    public void insert(DbFilmModel filmModel) {
        this.database.dataBaseDao().insert(filmModel);
    }

    @Override
    public void updateFilm(String runTime, String country, String Released, String director, String writer, String actor, String genre, String rated, String plot, String imbdbID) {
        this.database.dataBaseDao().updateFilm(runTime, country, Released, director, writer, actor, genre, rated, plot, imbdbID);
    }

    @Override
    public void update(DbFilmModel model) {
        this.database.dataBaseDao().update(model);
    }
}
