package ru.arestov.plane;

public class AirbusA320 extends Plane implements Runnable {


    private String name;
    private int fuel;
    private  int fuelMax;
    private int engine;


    public AirbusA320() {
        name = "AIRBUS A320";
        fuel = 35000;
        engine = 2;
        fuelMax = 35000;

    }

    @Override
    public int getFuelMax() {
        return fuelMax;
    }

    @Override
    public int getFuel() {
        return fuel;
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