package edu.epam.port.service;

import edu.epam.port.entity.Ship;
import edu.epam.port.entity.Size;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShipGeneration implements Runnable {
    private Port port;
    private int shipCount;
    private int id = 0;

    public ShipGeneration(Port port, int shipCount) {
        this.port = port;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Генерация кораблей");
            boolean add = port.add(new Ship(idGeneration(), getRandomSize()));
            if (add) {
                count++;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Size getRandomSize() {
        Random random = new Random();
        int numberRandom = random.nextInt(Size.values().length);
        Size size = Size.values()[numberRandom];
        return size;
    }

    private int idGeneration() {
        return ++id;
    }
}
