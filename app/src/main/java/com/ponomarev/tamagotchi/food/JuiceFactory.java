package com.ponomarev.tamagotchi.food;

public class JuiceFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Juice();
    }
}
