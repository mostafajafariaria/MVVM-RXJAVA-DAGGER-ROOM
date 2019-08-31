package ir.Geotech_co.batman.app.dataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ir.Geotech_co.batman.dbModels.DbFilmModel;

@Dao
public interface DataBaseDao {

    @Query("SELECT * FROM films WHERE imdbID = :imbdbId")
    DbFilmModel findFilmById(String imbdbId);

    @Query("SELECT * FROM films")
    List<DbFilmModel> getAllFilms();

    @Insert
    void insert(DbFilmModel filmModel);


    @Query("UPDATE films SET runtime = :runTime , country = :country , released =:Released ,  director =:director , writer =:writer ,  actors=:actor , genre=:genre , rated =:rated , plot=:plot WHERE imdbID = :imdbId")
    void updateFilm(String runTime, String country, String Released, String director,
                    String writer, String actor, String genre, String rated, String plot, String imdbId);

    @Update
    void update(DbFilmModel dbFilmModel);
}
