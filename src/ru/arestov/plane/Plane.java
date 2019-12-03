package ru.arestov.plane;

import ru.arestov.airport.AirPort;

public abstract class Plane {


    private String name;
    private int fuel;
    private int fuelMax;
    private int engine;

    public int getFuelMax() {
        return fuelMax;
    }

    public int getEngine() {
        return engine;
    }


    public int getFuel() {
        return fuel;
    }


    public void setFuel(int fuel) {
        this.fuel = fuel;
    }


    public void waitRun() throws InterruptedException {
        System.out.println("ПИЛОТ: " + toString() + " к взлету готов");
        Thread.sleep(3000);

        while (AirPort.runway) {                        //Если полоса занята, крутим цикл
            System.out.println("ДИСПЕТЧЕР: " + toString() + " взлет запрещаю");
            Thread.sleep(17000);
        }

        AirPort.runway = true;                          //Если свободна, "взлетаем" запускаем метод takeoff()
        System.out.println("ДИСПЕТЧЕР: " + toString() + " взлет разрешаю");
        Thread.sleep(2000);
        takeoff();

    }


    public void takeoff() throws InterruptedException {
        System.out.println(toString() + " взлетает");
        Thread.sleep(getFuel()/getEngine());
        System.out.println(toString() + " в небе");
        AirPort.runway = false;                       //Освобождаем полосу
        Thread.sleep(3000);
        fly();
    }


    public void fly() throws InterruptedException {
        while (true) {
            int planeFuel = getFuel();              //Здесь я неуверен что правильно
            int planeEngine = getEngine();
            setFuel(planeFuel -= planeEngine * 25);  // умножаем кол-во двигателей на "расход" и отнимаем от топлива
            Thread.sleep(100);
            if (planeFuel == 10000) {
                System.out.println(toString() + " подходит к аэропорту");
            } else if (planeFuel < 5000) {          //если меньше 5000т летим к аэропорту
                landingRequest();                   // запрос на посадку
                break;
            }
        }
    }

    public void landingRequest() throws InterruptedException {
        while (true) {
            System.out.println("ПИЛОТ: " + toString() + " запрашиваю посадку");
            Thread.sleep(5000);
            if (AirPort.runway) {                  //если занято, ждем
                System.out.println("ДИСПЕТЧЕР: " + toString() + " посадку запрещаю");
                Thread.sleep(17000);
            } else {
                System.out.println("ДИСПЕТЧЕР: " + toString() + " посадку разрешаю");
                landing();                          //если свободно, посадка


                break;
            }
        }
    }

    public void landing() throws InterruptedException {
        AirPort.runway = true;                      //закрываем полосу
        Thread.sleep(5000);
        System.out.println(toString() + " заходит на посадку");
        Thread.sleep(4500);
        System.out.println(toString() + " совершил посадку");
        Thread.sleep(getFuel()/getEngine());
        System.out.println("ПИЛОТ: " + toString() + " освободил полосу");
        AirPort.runway = false;                     //открываем
        Thread.sleep(1000);
        taxiing();                                  //руление
    }

    public void refuel() throws InterruptedException {

        Thread.sleep(3000);
        while (AirPort.gas) {                      //ждем заправку
            System.out.println("ДИСПЕТЧЕР: " + toString() + " ожидайте");
            Thread.sleep(20000);
        }
        AirPort.gas = true;
        System.out.println("ДИСПЕТЧЕР: " + toString() + " топливозаправщик выехал");
        int planeFuel = getFuel();              //опять неуверен что правильно
        int planeFuelMax = getFuelMax();
        Thread.sleep(7000);
        System.out.println(toString() + " заправляется");
        while (planeFuel < planeFuelMax) {      //заправляем пока не будет максимум
            setFuel(planeFuel += 5);
            Thread.sleep(1);
        }
        System.out.println(toString() + " заправлен");
        AirPort.gas = false;
        Thread.sleep(2000);
        taxiing();
    }

    public void taxiing() throws InterruptedException {

        if (getFuel() == getFuelMax()) {  //если топливо макс, на взлет
            System.out.println("ПИЛОТ: " + toString() + " приступил к рулению на полосу");
            Thread.sleep((getFuel()/getEngine())/2);
            waitRun();
        }
        else
            System.out.println("ПИЛОТ: " + toString() + " запрашиваю топливозаправщики");//если нет, на заправку
            refuel();
    }


    public String toString() {
        return name;
    }


    public void run() {

        try {
            taxiing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}




