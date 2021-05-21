package com.ponomarev.tamagotchi.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.ProgressBar;

import com.ponomarev.tamagotchi.model.Character;

import java.util.concurrent.TimeUnit;


public class StatusService extends IntentService {

    public ProgressBar progressBarHealth;
    public StatusService() {
        super("StatusService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        while(
                Integer.parseInt(Character.getCharacter().getLiveHealth().getValue())>0 ||
                Integer.parseInt(Character.getCharacter().getLiveHungry().getValue())>0 ||
                Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue())>0)
        {
            Character.getCharacter().getLiveHealth().postValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveHealth().getValue())-1));
            Character.getCharacter().getLiveHungry().postValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveHungry().getValue())-1));
            Character.getCharacter().getLiveEnergy().postValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue())-1));

            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}