package com.ponomarev.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void beginGame(View view) {
        Context nowScene = MainActivity.this;
        Class nextScene = GameActivity.class;
        Intent changeScene = new Intent(nowScene, nextScene);
        startActivity(changeScene);
    }
}