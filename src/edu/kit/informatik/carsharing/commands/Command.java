package edu.kit.informatik.carsharing.commands;

import edu.kit.informatik.carsharing.model.CarSharingPlatform;

import java.util.Objects;

public abstract class Command {

    private final String commandName;
    protected final CommandHandler commandHandler;
    protected final CarSharingPlatform carSharingPlatform;

    protected Command(String commandName, CommandHandler commandHandler, CarSharingPlatform carSharingPlatform) {
        this.commandName = Objects.requireNonNull(commandName);
        this.commandHandler = Objects.requireNonNull(commandHandler);
        this.carSharingPlatform = Objects.requireNonNull(carSharingPlatform);
    }

    public final String getCommandName() {
        return commandName;
    }

    public abstract void execute(String[] commandArguments);
}
