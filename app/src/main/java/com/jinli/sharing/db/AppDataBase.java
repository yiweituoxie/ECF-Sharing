package com.jinli.sharing.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Jin on 1/11/2019
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao getNoteDao();


    private static AppDataBase appDataBase;

    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ AppDataBase getInstance(Context context) {
        if (null == appDataBase) {
            appDataBase = buildDatabaseInstance(context);
        }
        return appDataBase;
    }

    private static AppDataBase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                AppDataBase.class,
                "DB").allowMainThreadQueries().build();
    }

}
