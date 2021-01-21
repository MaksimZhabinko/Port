package edu.epam.port.service;

import edu.epam.port.entity.Ship;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<Ship> store;
    private int shipsCounter = 0;
    private static final int MAX_SHIPS_IN_PORT = 5;
    private static final int MIN_SHIPS_IN_PORT = 0;

    public Port() {
        this.store = new ArrayList<>();
    }

    public synchronized boolean add(Ship ship) {
        try {
            if (shipsCounter < MAX_SHIPS_IN_PORT) {
                notifyAll();
                store.add(ship);
                String info = String.format("%s + Корабль прибыл в порт: %s %s %s", store.size(), ship.getIdShip(), ship.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;
            } else {
                System.out.println(store.size() + "> В порту нет места кораблю: " + Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ship get() {
        try {
            if (shipsCounter > MIN_SHIPS_IN_PORT) {
                notifyAll();
                for (Ship ship: store) {
                    shipsCounter--;
                    System.out.println(store.size() + "- Корабль вынимают из порта:" + ship.getIdShip() + " " + ship.getSize());
                    store.remove(ship);
                    return ship;
                }
            } else {
                System.out.println("0 < В порту нет кораблей");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
