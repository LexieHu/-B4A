package edu.kit.informatik.carsharing.commands;

import edu.kit.informatik.carsharing.model.CarSharingPlatform;

public final class QuitCommand extends Command {

    private static final String COMMAND_NAME = "quit";
    private static final String QUIT_WITH_ARGUMENTS_ERROR = "ERROR: quit does not allow args.";


    public QuitCommand(CommandHandler commandHandler, CarSharingPlatform carSharingPlatform) {
        super(COMMAND_NAME, commandHandler, carSharingPlatform);
    }

    @Override
    public void execute(String[] commandArguments) {
        if (commandArguments.length != 0) {
            System.err.println(QUIT_WITH_ARGUMENTS_ERROR);
            return;
        }
        commandHandler.quit();
    }
}
