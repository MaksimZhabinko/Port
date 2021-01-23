package edu.epam.port.state.impl;

import edu.epam.port.entity.Ship;
import edu.epam.port.entity.ShipPort;
import edu.epam.port.state.ShipState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DisconnectState implements ShipState {
    private static final Logger logger = LogManager.getLogger(DisconnectState.class);

    private static final DisconnectState INSTANCE = new DisconnectState();

    private ShipPort port = ShipPort.getInstance();

    private DisconnectState() {
    }

    public static DisconnectState getInstance() {
        return INSTANCE;
    }

    @Override
    public void connectionShip(Ship ship) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadShip(Ship ship) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void disconnectShip(Ship ship) {
        port.remove(ship);
    }
}
