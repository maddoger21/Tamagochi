package com.ponomarev.tamagotchi.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ponomarev.tamagotchi.model.Character;

@Database(entities = {Character.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CharacterDao userDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getDbInstance(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "DB_NAME")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }
}
