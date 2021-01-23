package edu.epam.port.main;

import edu.epam.port.entity.Ship;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Ship().start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
