package ru.arestov.plane;

public class Boeing777 extends Plane implements Runnable {


    private String name;
    private int fuel;
    private  int fuelMax;
    private int engine;


    public Boeing777() {
        name = "BOEING-777";
        fuel = 0;
        engine = 4;
        fuelMax = 100000;

    }


    @Override
    public int getFuel() {
        return fuel;
    }
    @Override
    public int getFuelMax() {
        return fuelMax;
    }

    @Override
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public int getEngine() {
        return engine;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        super.run();
    }
}