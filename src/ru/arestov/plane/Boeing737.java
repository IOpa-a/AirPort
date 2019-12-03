package ru.arestov.plane;


public class Boeing737 extends Plane implements Runnable {

    private String name;
    private int fuel;
    private  int fuelMax;
    private int engine;

    public Boeing737() {
        name = "BOEING-737";
        fuel = 30000;
        engine = 2;
        fuelMax = 30000;
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