package edu.epam.port.entity;

public enum  ShipVolume {
    SMALL(10), MIDDLE(50), LARGE(100);

    private int volume;

    ShipVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
