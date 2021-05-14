package com.ponomarev.tamagotchi.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Character {
    private static Character character;
    public MutableLiveData<String> liveDataHealth = new MutableLiveData<>();
    public MutableLiveData<String> liveDataEnergy = new MutableLiveData<>();
    public MutableLiveData<String> liveDataHungry = new MutableLiveData<>();
    public MutableLiveData<String> liveDataMoney = new MutableLiveData<>();

//    private static int health = 100;
//    private static int energy = 100;
//    private static int hungry = 100;

    private Character() {

    }

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
