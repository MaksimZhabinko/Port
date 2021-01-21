package edu.epam.port;

import edu.epam.port.service.PierLoader;
import edu.epam.port.service.Port;
import edu.epam.port.service.ShipGeneration;

public class Main {
    public static void main(String[] args) {
        Port port = new Port();

        ShipGeneration shipGeneration = new ShipGeneration(port, 10);

        PierLoader pierLoader = new PierLoader(port);

        Thread threadShipGeneration = new Thread(shipGeneration);
        Thread threadPierLoader = new Thread(pierLoader);
        threadShipGeneration.start();
        threadPierLoader.start();
    }
}
