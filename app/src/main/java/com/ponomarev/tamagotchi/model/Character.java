package com.ponomarev.tamagotchi.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ponomarev.tamagotchi.database.DataConverter;


@Entity
@TypeConverters({DataConverter.class})
public class Character {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character")
    private static Character character;
    //@ColumnInfo(name = "health")
    public MutableLiveData<String> liveDataHealth = new MutableLiveData<>();
    //@ColumnInfo(name = "energy")
    public MutableLiveData<String> liveDataEnergy = new MutableLiveData<>();
    //@ColumnInfo(name = "hungry")
    public MutableLiveData<String> liveDataHungry = new MutableLiveData<>();
    //@ColumnInfo(name = "money")
    public MutableLiveData<String> liveDataMoney = new MutableLiveData<>();

//    private static int health = 100;
//    private static int energy = 100;
//    private static int hungry = 100;

    public Character() {};

    public static Character getCharacter(){
        if (character == null){
            character = new Character();
        }

        return character;
    }

    public MutableLiveData<String> getLiveHealth(){
        return liveDataHealth;
    }
    public MutableLiveData<String> getLiveEnergy(){
        return liveDataEnergy;
    }
    public MutableLiveData<String> getLiveHungry(){
        return liveDataHungry;
    }
    public MutableLiveData<String> getLiveMoney(){
        return liveDataMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //    public int getEnergy() {
//        return energy;
//    }
//
//    public int getHungry() {
//        return hungry;
//    }
//
//    public int getHealth() {
//        return health;
//    }

//    public void setEnergy(int energy) {
//        this.energy = energy;
//    }
//
//    public void setHungry(int hungry) {
//        this.hungry = hungry;
//    }
//    public void setHealth(int health) {
//        this.health = health;
//    }
}
