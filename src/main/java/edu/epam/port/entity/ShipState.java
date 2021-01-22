package edu.epam.port.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ShipState {
    Logger logger = LogManager.getLogger(ShipState.class);
    void connectionShip(Ship ship);
    void unloadShip(Ship ship);
    void loadShip(Ship ship);
    void disconnectShip(Ship ship);
}
