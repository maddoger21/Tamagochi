package com.ponomarev.tamagotchi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ponomarev.tamagotchi.GameActivity;
import com.ponomarev.tamagotchi.R;
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

import java.util.ArrayList;

public class StoreFragment extends Fragment {

    private ArrayList<IFood> foodArrayList = new ArrayList();
    private ArrayList<IFoodFactory> foodFactories = new ArrayList();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_fragment, container, false);

        RecyclerView foodList = (RecyclerView) view.findViewById(R.id.rv_food_list);
        foodFactories.add(new AppleFactory());
        foodFactories.add(new CoffeeFactory());
        foodFactories.add(new ColaFactory());
        foodFactories.add(new FishFactory());
        foodFactories.add(new JuiceFactory());
        foodFactories.add(new PizzaFactory());
        foodFactories.add(new PotatoFactory());
        for(int i = 0; i < foodFactories.size(); i++){
            IFood iFood = foodFactories.get(i).Create();
            foodArrayList.add(iFood);
        }

        FoodAdapter foodAdapter = new FoodAdapter(foodFactories.size(), foodArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        foodList.setLayoutManager(layoutManager);

        foodList.setHasFixedSize(true);

        foodList.setAdapter(foodAdapter);

        return view;
    }
}
