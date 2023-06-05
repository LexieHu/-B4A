package edu.kit.informatik.carsharing.commands;

import edu.kit.informatik.carsharing.model.CarSharingPlatform;
import edu.kit.informatik.carsharing.model.Station;

public final class StationCommand extends Command {
    private static final String COMMAND_NAME = "station";
    private static final int STATION_NAME_INDEX = 0;
    private static final String MISSING_STATION_NAME_ERROR = "ERROR: station name is required.";

    public StationCommand(CommandHandler commandHandler, CarSharingPlatform carSharingPlatform) {
        super(COMMAND_NAME, commandHandler, carSharingPlatform);
    }

    @Override
    public void execute(String[] commandArguments) {
        if (commandArguments.length != 1) {
            System.err.println(MISSING_STATION_NAME_ERROR);
            return;
        }
        Station station = carSharingPlatform.getStation(commandArguments[STATION_NAME_INDEX]);
        // TODO Generate required output message.
        System.out.println("TODO: Output Message");
    }
}
