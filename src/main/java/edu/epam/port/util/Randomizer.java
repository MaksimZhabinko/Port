package edu.epam.port.util;

import edu.epam.port.entity.ShipVolume;

import java.util.Random;

public class Randomizer {
    public static ShipVolume getRandomShipVolume() {
        Random random = new Random();
        int randomInt = random.nextInt(ShipVolume.values().length);
        return ShipVolume.values()[randomInt];
    }
}
