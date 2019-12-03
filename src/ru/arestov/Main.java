package ru.arestov;

import ru.arestov.airport.AirPort;
import ru.arestov.plane.AirbusA320;
import ru.arestov.plane.Boeing737;
import ru.arestov.plane.Boeing777;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AirPort airPort = new AirPort();

        airPort.addPlane(new Boeing737());
        airPort.addPlane(new Boeing777());
        airPort.addPlane(new AirbusA320());

        airPort.planeStart();
    }
}



