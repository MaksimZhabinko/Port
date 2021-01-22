package edu.epam.port.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pier {
    private static final Pier INSTANCE = new Pier();
    private ShipPort port = ShipPort.getInstance();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private Pier() {
    }

    public static Pier getInstance() {
        return INSTANCE;
    }

    public void loadShip() {
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            Ship ship = port.get();
            Thread.currentThread().setName("Загрузка ");
            if (ship != null) {
                while (ship.countCheck()) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    ship.addContainer(10);
                    System.out.println(ship.getContainer() + " Загруженный корабль. ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
