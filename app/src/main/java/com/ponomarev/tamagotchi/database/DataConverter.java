package com.ponomarev.tamagotchi.database;

import androidx.lifecycle.MutableLiveData;
import androidx.room.TypeConverter;

public class DataConverter {
    @TypeConverter
    public String fromCharacter(MutableLiveData<String> liveDataHealth) {
        return liveDataHealth.getValue();
    }

    @TypeConverter
    public MutableLiveData<String> toCharacter(String liveDataHealth) {
        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.setValue(liveDataHealth);
        return liveData;
    }
}
