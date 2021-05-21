package com.ponomarev.tamagotchi.database;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ponomarev.tamagotchi.model.Character;

@Dao
public interface CharacterDao {

    @Query("SELECT * FROM Character")
    Character getCharacterData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setCharacterData(Character character);

    @Delete
    void delete(Character character);
}
