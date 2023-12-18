package org.drawing;

import org.drawing.command.Command;
import org.drawing.command.CommandFactory;
import org.drawing.command.QuitCommand;
import org.drawing.drawer.CanvasDrawer;
import org.drawing.exception.CanvasDrawException;
import org.drawing.exception.InvalidCommandException;
import org.drawing.processor.DrawCommandProcessor;

import java.util.Scanner;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/15
 **/
public class Main {

    public static void main(String[] args) {
        Scanner commandScanner = new Scanner(System.in);
        DrawCommandProcessor drawCommandProcessor = new DrawCommandProcessor(commandScanner);
        System.out.println(Command.DEFAULT_HELP_MESSAGE);
        while(true) {
            System.out.println(Command.ENTER_COMMAND);
            String commandLine = commandScanner.nextLine();
            drawCommandProcessor.process(commandLine);
        }
    }

}



