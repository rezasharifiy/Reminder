package com.developerman.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.developerman.data.model.MedicModelData;

@Database(entities = {MedicModelData.class}, version = 1)
public abstract class RoomDatabase extends android.arch.persistence.room.RoomDatabase {
    protected abstract MedicDAO dao();

    private static volatile RoomDatabase instance;

    static RoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDatabase.class, "medic_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
