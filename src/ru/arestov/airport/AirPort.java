package ru.arestov.airport;

import ru.arestov.plane.Plane;

import java.util.ArrayList;
import java.util.List;

public class AirPort {
    public static boolean runway = false; //свободна ли полоса
    public  static boolean gas = false; //свободна ли заправка

    List<Plane> planeList = new ArrayList<>();

    public List<Plane> addPlane(Plane plane) {
        planeList.add(plane);
        return planeList;
    }

    public void planeStart() throws InterruptedException {
        for (int i = 0; i < planeList.size(); i++) {
            Thread thread = new Thread((Runnable) planeList.get(i));

                thread.start();
                Thread.sleep(100);
            }

        }
    }




