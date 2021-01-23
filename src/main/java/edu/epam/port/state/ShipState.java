package edu.epam.port.state;

import edu.epam.port.entity.Ship;

public interface ShipState {
    void connectionShip(Ship ship);
    void loadShip(Ship ship);
    void disconnectShip(Ship ship);
}
