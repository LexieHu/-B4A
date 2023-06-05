package edu.kit.informatik.carsharing;

import edu.kit.informatik.carsharing.commands.CommandHandler;
import edu.kit.informatik.carsharing.model.CarSharingPlatform;

public final class Main {
    private Main() {
        throw new UnsupportedOperationException("This class cannot be instantiated!");
    }

    public static void main(String[] args) {
        CarSharingPlatform carSharingPlatform = new CarSharingPlatform();
        CommandHandler commandHandler = new CommandHandler(carSharingPlatform);
        commandHandler.handleUserInput();
    }
}
