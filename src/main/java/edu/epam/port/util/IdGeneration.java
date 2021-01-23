package edu.epam.port.util;

public class IdGeneration {
    private static int id = 0;

    public static int getId() {
        return id++;
    }
}
