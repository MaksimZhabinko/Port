package edu.epam.port.state.impl;

import edu.epam.port.entity.Pier;
import edu.epam.port.entity.Ship;
import edu.epam.port.state.ShipState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadState implements ShipState {
    private static final Logger logger = LogManager.getLogger(LoadState.class);

    private static final LoadState INSTANCE = new LoadState();
    private Pier pier = Pier.getInstance();

    private LoadState() {
    }

    public static LoadState getInstance() {
        return INSTANCE;
    }

    @Override
    public void connectionShip(Ship ship) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadShip(Ship ship) {
        pier.loadShip();
        ship.setState(DisconnectState.getInstance());
    }

    @Override
    public void disconnectShip(Ship ship) {
        throw new UnsupportedOperationException();
    }
}
