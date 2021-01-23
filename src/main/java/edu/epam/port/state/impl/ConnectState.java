package edu.epam.port.state.impl;

import edu.epam.port.entity.Ship;
import edu.epam.port.entity.ShipPort;
import edu.epam.port.state.ShipState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectState implements ShipState {
    private static final Logger logger = LogManager.getLogger(ConnectState.class);

    private static final ConnectState INSTANCE = new ConnectState();

    private ShipPort port = ShipPort.getInstance();

    private ConnectState() {
    }

    public static ConnectState getInstance() {
        return INSTANCE;
    }

    @Override
    public void connectionShip(Ship ship) {
        port.add(ship);
        ship.setState(LoadState.getInstance());
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
