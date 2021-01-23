package edu.epam.port.entity;

import edu.epam.port.state.impl.ConnectState;
import edu.epam.port.state.ShipState;
import edu.epam.port.util.IdGeneration;
import edu.epam.port.util.Randomizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship extends Thread {
    private static final Logger logger = LogManager.getLogger(Ship.class);

    private int shipId;
    private int container;
    private ShipState state;
    private ShipVolume volume;

    public Ship() {
        shipId = IdGeneration.getId();
        volume = Randomizer.getRandomShipVolume();;
    }

    public void addContainer(int container) {
        this.container += container;
    }

    public boolean countCheck() {
        if (container >= volume.getVolume()) {
            return false;
        }
        return true;
    }

    public int getContainer() {
        return container;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public int getShipId() {
        return shipId;
    }

    public ShipVolume getVolume() {
        return volume;
    }

    @Override
    public void run() {
        this.setState(ConnectState.getInstance());
        state.connectionShip(this);
        state.loadShip(this);
        state.disconnectShip(this);
    }
}
