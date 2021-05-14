package com.ponomarev.tamagotchi.food;

public class Juice implements IFood{
    public static String name = "Juice";
    public static int EnergyRegen = 15;
    public static int HealthRegen = 0;
    public static int HungryRegen = 0;
    public static int cost = 10;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int energyRestore() {
        return EnergyRegen;
    }

    @Override
    public int healthRestore() {
        return HealthRegen;
    }

    @Override
    public int hungryRestore() {
        return HungryRegen;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
