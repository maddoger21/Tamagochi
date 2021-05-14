package com.ponomarev.tamagotchi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ponomarev.tamagotchi.GameActivity;
import com.ponomarev.tamagotchi.MainActivity;
import com.ponomarev.tamagotchi.R;
import com.ponomarev.tamagotchi.food.IFood;
import com.ponomarev.tamagotchi.model.Character;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter <FoodAdapter.FoodViewHolder> {

    private int numberItems;
    private ArrayList <IFood> foodArrayList;

    public FoodAdapter(int numberItems, ArrayList <IFood> foodList){
        foodArrayList = foodList;
        this.numberItems = numberItems;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {

       TextView nameFood;
       TextView costFood;
       TextView healthRestore;
       TextView hungryRestore;
       TextView energyRestore;

       public FoodViewHolder(@NonNull View itemView) {
           super(itemView);
           nameFood = itemView.findViewById(R.id.tv_food_name);
           costFood = itemView.findViewById(R.id.tv_cost);
           healthRestore = itemView.findViewById(R.id.tv_health_restore);
           hungryRestore = itemView.findViewById(R.id.tv_hungry_restore);
           energyRestore = itemView.findViewById(R.id.tv_energy_restore);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

//                   if (Integer.parseInt(Character.getCharacter().getLiveHealth().getValue())+foodArrayList.get(getAbsoluteAdapterPosition()).healthRestore() > 100){
//                       int add = foodArrayList.get(getAbsoluteAdapterPosition()).healthRestore()) - 100 - Integer.parseInt(Character.getCharacter().getLiveHealth().getValue());
//                       Character.getCharacter().getLiveHealth().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveHealth().getValue())+foodArrayList.get(getAbsoluteAdapterPosition()).healthRestore()));
//                   }

                   if (Integer.parseInt(Character.getCharacter().getLiveMoney().getValue()) >= foodArrayList.get(getAbsoluteAdapterPosition()).getCost()) {
                       Character.getCharacter().getLiveHealth().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveHealth().getValue()) + foodArrayList.get(getAbsoluteAdapterPosition()).healthRestore()));
                       Character.getCharacter().getLiveHungry().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveHungry().getValue()) + foodArrayList.get(getAbsoluteAdapterPosition()).hungryRestore()));
                       Character.getCharacter().getLiveEnergy().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveEnergy().getValue()) + foodArrayList.get(getAbsoluteAdapterPosition()).energyRestore()));
                       Character.getCharacter().getLiveMoney().setValue(String.valueOf(Integer.parseInt(Character.getCharacter().getLiveMoney().getValue()) - foodArrayList.get(getAbsoluteAdapterPosition()).getCost()));
                   }
                   else {
                       Toast.makeText(v.getContext(), "Нехватает денег", Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }

       public void bind(int position){
           //for (int i = 0; i < foodArrayList.size(); i++){
               nameFood.setText(foodArrayList.get(position).getName());
               costFood.setText(String.valueOf(foodArrayList.get(position).getCost()));
               healthRestore.setText(String.valueOf(foodArrayList.get(position).healthRestore()));
               hungryRestore.setText(String.valueOf(foodArrayList.get(position).hungryRestore()));
               energyRestore.setText(String.valueOf(foodArrayList.get(position).energyRestore()));
           //}
       }


    }

}
