package com.ponomarev.tamagotchi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ponomarev.tamagotchi.adapter.FoodAdapter;
import com.ponomarev.tamagotchi.food.AppleFactory;
import com.ponomarev.tamagotchi.food.CoffeeFactory;
import com.ponomarev.tamagotchi.food.ColaFactory;
import com.ponomarev.tamagotchi.food.FishFactory;
import com.ponomarev.tamagotchi.food.IFood;
import com.ponomarev.tamagotchi.food.IFoodFactory;
import com.ponomarev.tamagotchi.food.JuiceFactory;
import com.ponomarev.tamagotchi.food.PizzaFactory;
import com.ponomarev.tamagotchi.food.PotatoFactory;
import com.ponomarev.tamagotchi.fragments.StoreFragment;
import com.ponomarev.tamagotchi.model.Character;
import com.ponomarev.tamagotchi.service.StatusService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity implements Serializable {

    private ArrayList<IFood> foodArrayList = new ArrayList();
    private ArrayList<IFoodFactory> foodFactories = new ArrayList();
    private RecyclerView foodList;
    private FoodAdapter foodAdapter;

    public TextView money;
    public ProgressBar progressBarHealth;
    public ProgressBar progressBarHungry;
    public ProgressBar progressBarEnergy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        progressBarHealth = findViewById(R.id.pb_health);
        progressBarHungry = findViewById(R.id.pb_hungry);
        progressBarEnergy = findViewById(R.id.pb_energy);
        money = findViewById(R.id.tv_money);
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

        //Update update = new Update(progressBarHealth);
        //update.execute();
        Character.getCharacter().getLiveHealth().setValue("100");
        Character.getCharacter().getLiveHungry().setValue("100");
        Character.getCharacter().getLiveEnergy().setValue("100");
        Character.getCharacter().getLiveMoney().setValue("0");

        mediatorLiveData.addSource(Character.getCharacter().getLiveHealth(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);
            }
        });
        mediatorLiveData.addSource(Character.getCharacter().getLiveHungry(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);

            }
        });
        mediatorLiveData.addSource(Character.getCharacter().getLiveEnergy(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);

            }
        });
        mediatorLiveData.addSource(Character.getCharacter().getLiveMoney(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mediatorLiveData.setValue(s);

            }
        });

        mediatorLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                progressBarHealth.setProgress(Integer.parseInt(Character.getCharacter().getLiveHealth().getValue()));
                progressBarHungry.setProgress(Integer.parseInt(Character.getCharacter().getLiveHungry().getValue()));
                progressBarEnergy.setProgress(Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue()));
                money.setText("Количество денег: " + Character.getCharacter().liveDataMoney.getValue());
                if (    Integer.parseInt(Character.getCharacter().getLiveHealth().getValue()) == 0 ||
                        Integer.parseInt(Character.getCharacter().getLiveHungry().getValue()) == 0 ||
                        Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue()) == 0){

                    Context nowScene = GameActivity.this;
                    Class nextScene = EndActivity.class;
                    Intent changeScene = new Intent(nowScene, nextScene);
                    startActivity(changeScene);

                }

            }
        });

        Intent intentMyStatusService = new Intent(this, StatusService.class);
        startService(intentMyStatusService);


    }


    public void Store(View view){
        StoreFragment storeFragment = new StoreFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_store, storeFragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }


//    public void Eat(View view){
//        if (Integer.parseInt(Character.getCharacter().getLiveHungry().getValue())+5 > 100){
//            return;
//        }
//        else {
//            Character.getCharacter().getLiveHungry().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveHungry().getValue()) + 5));
//        }
//    }

//    public void Sleep(View view){
//        if (Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue())+5 > 100){
//            return;
//        }
//        else {
//            Character.getCharacter().getLiveEnergy().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue())+5));
//        }
//    }

    public void Work(View view){
        Character.getCharacter().getLiveMoney().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveMoney().getValue())+1));
        Character.getCharacter().getLiveEnergy().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue())-1));
    }


}
