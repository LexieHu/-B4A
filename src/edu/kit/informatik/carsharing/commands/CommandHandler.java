package edu.kit.informatik.carsharing.commands;

import edu.kit.informatik.carsharing.model.CarSharingPlatform;

import java.util.*;

public final class CommandHandler {
    private static final char ARGS_SEPARATOR = ';';
    private static final String COMMAND_ARGS_SEPARATOR = " ";
    private static final String COMMAND_NOT_FOUND = "ERROR: Command '%s' not found%n";

    private final CarSharingPlatform carSharingPlatform;
    private final Map<String, Command> commands;
    private boolean running = false;

    public CommandHandler(CarSharingPlatform carSharingPlatform) {
        this.carSharingPlatform = Objects.requireNonNull(carSharingPlatform);
        this.commands = new HashMap<>();
        this.initCommands();
    }


    public void handleUserInput() {
        this.running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running && scanner.hasNextLine()) {
                executeCommand(scanner.nextLine());
            }
        }
    }

    void quit() {
        this.running = false;
    }

    private String[] parseCommandArguments(String argumentString) {
        List<String> arguments = new LinkedList<>();
        StringBuilder currentArgument = new StringBuilder();
        
        for (char c : argumentString.toCharArray()) {
            if (c == ARGS_SEPARATOR) {
                arguments.add(currentArgument.toString());
                currentArgument = new StringBuilder();
            } else {
                currentArgument.append(c);
            }
        }
        arguments.add(currentArgument.toString());
        return arguments.toArray(String[]::new);
    }

    private void executeCommand(String commandWithArguments) {
        int firstSpaceIndex = Objects.requireNonNull(commandWithArguments).indexOf(COMMAND_ARGS_SEPARATOR);
        String commandString = commandWithArguments;
        String[] args = new String[0];
        
        if (firstSpaceIndex != -1) {
            commandString = commandWithArguments.substring(0, firstSpaceIndex);
            args = this.parseCommandArguments(commandWithArguments.substring(firstSpaceIndex + 1));
        }

        Command command = this.commands.get(commandString);
        if (command == null) {
            System.err.printf(COMMAND_NOT_FOUND, commandString);
            return;
        }
        
        command.execute(args);
    }

    private void initCommands() {
        this.addCommand(new QuitCommand(this, carSharingPlatform));
        this.addCommand(new StationCommand(this, carSharingPlatform));
    }

    private void addCommand(Command command) {
        this.commands.put(command.getCommandName(), command);
    }
}
