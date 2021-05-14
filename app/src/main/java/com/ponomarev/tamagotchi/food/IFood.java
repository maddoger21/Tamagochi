package com.ponomarev.tamagotchi.food;

public interface IFood {
    public String getName();

    public int energyRestore();

    public int healthRestore();

    public int hungryRestore();

    public int getCost();
}
