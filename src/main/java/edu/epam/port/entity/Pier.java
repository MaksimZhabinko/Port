package edu.epam.port.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pier {
    private static final Logger logger = LogManager.getLogger(Pier.class);

    private static final Pier INSTANCE = new Pier();
    private ShipPort port = ShipPort.getInstance();
    private Lock lock = new ReentrantLock();

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
            logger.debug("Загрузка корабля " + ship.getShipId());
            if (ship != null) {
                while (ship.countCheck()) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    ship.addContainer(10);
                    logger.debug("Добавленно " + ship.getContainer() + " ящиков на корабль");
                }
            }
            logger.debug("Корабль полностью загружен ");
        } catch (Exception e) {
            logger.error(e);
        } finally {
            lock.unlock();
        }
    }
}
