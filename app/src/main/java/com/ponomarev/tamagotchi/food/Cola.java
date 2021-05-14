package com.ponomarev.tamagotchi.food;

public class Cola implements IFood {
    public static String name = "Cola";
    public static int EnergyRegen = 20;
    public static int HealthRegen = 0;
    public static int HungryRegen = 2;
    public static int cost = 5;
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
