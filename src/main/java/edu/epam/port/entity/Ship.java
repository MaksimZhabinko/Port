package edu.epam.port.entity;

import edu.epam.port.entity.impl.ConnectState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship extends Thread {
    private static final Logger logger = LogManager.getLogger(Ship.class);

    private static final int MAX_CAPACITY = 50;
    private int container;
    private ShipState state;

    public void addContainer(int container) {
        this.container += container;
    }

    public boolean countCheck() {
        if (container >= MAX_CAPACITY) {
            return false;
        }
        return true;
    }

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    @Override
    public void run() {
        this.setState(ConnectState.getInstance());
        state.connectionShip(this);
        state.loadShip(this);
        state.disconnectShip(this);
    }
}
