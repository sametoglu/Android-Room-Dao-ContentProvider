package com.example.samet.final2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by samet on 28.05.2018.
 */


@Database(entities = {Student.class},version = 1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase appDatabase;
    public abstract IStudentDAO getStudentDAO();

    private static final String databaseName = "bm443";

    public static AppDatabase getAppDatabase(Context context) {
        if(appDatabase == null){
            appDatabase= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,databaseName)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public static void destroyInstance(){
        appDatabase=null;
    }


}
