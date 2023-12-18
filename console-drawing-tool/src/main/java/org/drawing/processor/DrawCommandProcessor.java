package org.drawing.processor;

import org.drawing.command.Command;
import org.drawing.command.CommandFactory;
import org.drawing.command.QuitCommand;
import org.drawing.drawer.CanvasDrawer;
import org.drawing.exception.CanvasDrawException;
import org.drawing.exception.InvalidCommandException;

import java.util.Scanner;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/18
 **/
public class DrawCommandProcessor implements CommandProcessor {
    private final CommandFactory commandFactory;
    private final CanvasDrawer canvasDrawer;
    private final Scanner commandScanner;

    public DrawCommandProcessor(Scanner commandScanner) {
        commandFactory = new CommandFactory();
        canvasDrawer = new CanvasDrawer();
        this.commandScanner = commandScanner;
    }
    @Override
    public void process(String commandLine) {
        Command command = null;
        try {
            command = commandFactory.getCommand(commandLine);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }

        if (command == null) {
            return;
        }

        if (command instanceof QuitCommand) {
            System.out.println("Console drawing tool exiting...");
            commandScanner.close();
            System.exit(0);
        }
        try{
            System.out.println(canvasDrawer.draw(command));
        } catch (CanvasDrawException e) {
            System.out.println(e.getMessage());
        }
    }

}
