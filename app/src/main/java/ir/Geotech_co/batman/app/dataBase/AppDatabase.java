package ir.Geotech_co.batman.app.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import ir.Geotech_co.batman.app.App;
import ir.Geotech_co.batman.dbModels.DbFilmModel;

@Database(entities = {DbFilmModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DataBaseDao dataBaseDao();

    public static AppDatabase getAppDataBase(App context) {
        return Room.databaseBuilder(context, AppDatabase.class, "myClub_Database")
                .allowMainThreadQueries().build();
    }

}
