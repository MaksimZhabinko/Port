package edu.epam.port.entity.impl;

import edu.epam.port.entity.Ship;
import edu.epam.port.entity.ShipState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnloadState implements ShipState {
    private static final Logger logger = LogManager.getLogger(UnloadState.class);

    private static final UnloadState INSTANCE = new UnloadState();

    private UnloadState() {
    }

    public static UnloadState getInstance() {
        return INSTANCE;
    }

    @Override
    public void connectionShip(Ship ship) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unloadShip(Ship ship) {

    }

    @Override
    public void loadShip(Ship ship) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void disconnectShip(Ship ship) {
        throw new UnsupportedOperationException();
    }
}
