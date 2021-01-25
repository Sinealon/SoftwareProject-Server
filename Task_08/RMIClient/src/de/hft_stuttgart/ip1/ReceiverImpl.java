package de.hft_stuttgart.ip1;


public class ReceiverImpl implements Filetr {
    public void receive(String message) {
        System.out.printf("The message is %s%n", message);
    }
}
