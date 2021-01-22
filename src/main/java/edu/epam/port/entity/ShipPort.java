package edu.epam.port.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShipPort {

    private static final ShipPort INSTANCE = new ShipPort();
    private Lock lock = new ReentrantLock();
    private List<Ship> shipsInPort;

    private ShipPort() {
        shipsInPort = new ArrayList<>();
    }

    public static ShipPort getInstance() {
        return INSTANCE;
    }

    public boolean add(Ship ship) {
        boolean isCorrect = false;
        try {
            lock.lock();
            shipsInPort.add(ship);
            System.out.println("Корабль прибыл в порт:");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isCorrect = true;
        } finally {
            lock.unlock();
        }
        return isCorrect;
    }

    public Ship get() {
        try {
            lock.lock();
            for (Ship ship : shipsInPort) {
                System.out.println(shipsInPort.size() + "- Корабль вынимают из порта:");
                shipsInPort.remove(ship);
                return ship;
            }
        } finally {
            lock.unlock();
        }
        return null;
    }

    public boolean remove(Ship ship) {
        boolean isCorrect = false;
        try {
            lock.lock();
            shipsInPort.remove(ship);
            System.out.println("Корабль покинул в порт:");
            isCorrect = true;
        } finally {
            lock.unlock();
        }
        return isCorrect;
    }
}
