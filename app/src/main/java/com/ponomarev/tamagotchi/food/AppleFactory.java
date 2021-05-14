package com.ponomarev.tamagotchi.food;

public class AppleFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Apple();
    }
}
