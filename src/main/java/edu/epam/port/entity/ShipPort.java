package edu.epam.port.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShipPort {
    private static final Logger logger = LogManager.getLogger(ShipPort.class);

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
            String info = "Корабль " + ship.getShipId() + " прибыл в порт. Объем - " + ship.getVolume();
            logger.debug(info);
            TimeUnit.SECONDS.sleep(1);
            isCorrect = true;
        } catch (InterruptedException e) {
            logger.error(e);
        } finally {
            lock.unlock();
        }
        return isCorrect;
    }

    public Ship get() {
        try {
            lock.lock();
            for (Ship ship : shipsInPort) {
                String info = "Корабль " + ship.getShipId() + " вынимают из порта. Объем - " + ship.getVolume();
                logger.debug(info);
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
            String info = "Корабль " + ship.getShipId() + " покинул в порт";
            logger.debug(info);
            isCorrect = true;
        } finally {
            lock.unlock();
        }
        return isCorrect;
    }
}
