package org.drawing.command;

import org.drawing.exception.InvalidCommandException;

import java.util.Arrays;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CommandFactory {
    public Command getCommand(String commandLine) throws InvalidCommandException {
        String[] commands = commandLine.trim().split("\\s+");
        String operator = commands[0].toUpperCase();
        String[] params = Arrays.copyOfRange(commands, 1, commands.length);
        return switch (operator) {
            case Command.CANVAS -> new CanvasCommand(params);
            case Command.LINE -> new LineCommand(params);
            case Command.RECTANGLE -> new RectangleCommand(params);
            case Command.QUIT -> new QuitCommand();
            default -> throw new InvalidCommandException("Invalid Command! please refer to this\n" + Command.DEFAULT_HELP_MESSAGE);
        };
    }
}
