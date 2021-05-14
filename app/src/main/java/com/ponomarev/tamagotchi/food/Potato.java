package com.ponomarev.tamagotchi.food;

public class Potato implements IFood {
    public static String name = "Potato";
    public static int EnergyRegen = 2;
    public static int HealthRegen = 2;
    public static int HungryRegen = 2;
    public static int cost = 3;
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
