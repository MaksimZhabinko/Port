package edu.epam.port.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pier {
    private static final Logger logger = LogManager.getLogger(Pier.class);

    private static final Pier INSTANCE = new Pier();
    private static final int CONTAINER_ADD = 10;
    private int warehouse = 100;
    private int supply = 1000;
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
                    if (warehouse == 0) {
                        logger.debug("На складе нет товара, ждем новой поставки");
                        TimeUnit.SECONDS.sleep(10);
                        warehouse = supply;
                    }
                    ship.addContainer(CONTAINER_ADD);
                    warehouse -= CONTAINER_ADD;
                    logger.debug("Добавленно " + ship.getContainer() + " ящиков на корабль");
                }
                logger.debug("Корабль " + ship.getShipId() + " полностью загружен ");

            }
        } catch (Exception e) {
            logger.error(e);
        } finally {
            lock.unlock();
        }
    }
}
