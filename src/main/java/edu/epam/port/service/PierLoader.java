package edu.epam.port.service;

import edu.epam.port.entity.Ship;

import java.util.concurrent.TimeUnit;

public class PierLoader implements Runnable {
    private Port port;

    public PierLoader(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                Ship ship = port.get();
                Thread.currentThread().setName("Загрузка " + ship.getIdShip());
                if (ship != null) {
                    while (ship.countCheck()) {
                        TimeUnit.SECONDS.sleep(1);
                        ship.addContainer(10);
                        System.out.println(ship.getContainer() + " Загруженный корабль. " + Thread.currentThread().getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
