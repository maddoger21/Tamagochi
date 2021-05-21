package com.ponomarev.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ponomarev.tamagotchi.database.AppDataBase;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }
        public void Restart(View view) {
            changeToBegin();
            deleteData();
        }

        public void changeToBegin(){
            Context nowScene = EndActivity.this;
            Class nextScene = MainActivity.class;
            Intent changeScene = new Intent(nowScene, nextScene);
            startActivity(changeScene);
        }
        public void deleteData(){
            AppDataBase dataBase = AppDataBase.getDbInstance(this.getApplicationContext());
            dataBase.userDao().delete(dataBase.userDao().getCharacterData());
        }
}