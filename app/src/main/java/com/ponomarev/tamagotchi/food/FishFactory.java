package com.ponomarev.tamagotchi.food;

public class FishFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Fish();
    }
}
