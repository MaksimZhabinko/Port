package edu.epam.port.entity;

public class Ship {
    private int idShip;
    private int container;
    private Size size;

    public Ship(int idShip, Size size) {
        this.idShip = idShip;
        this.size = size;
    }

    public void addContainer(int container) {
        this.container += container;
    }

    public boolean countCheck() {
        if (container >= size.getValue()) {
            return false;
        }
        return true;
    }

    public int getIdShip() {
        return idShip;
    }

    public int getContainer() {
        return container;
    }

    public Size getSize() {
        return size;
    }
}
