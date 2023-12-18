package org.drawing.command;

import lombok.Getter;
import lombok.ToString;
import org.drawing.exception.InvalidCommandException;
import org.drawing.util.CommandUtils;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
@Getter
@ToString
public class RectangleCommand implements Command {
    private static final String commandUsage = """
           Command usage:
           'R x1 y1 x2 y2' -> Should create a new rectangle,
           whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
           """;

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public RectangleCommand(String[] params) {
        if (params.length != 4)
            throw new InvalidCommandException("Error: required 4 params for rectangle command.\n" + commandUsage);
        try {
            x1 = Integer.parseInt(params[0]);
            y1 = Integer.parseInt(params[1]);
            x2= Integer.parseInt(params[2]);
            y2 = Integer.parseInt(params[3]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Error: invalid params for rectangle command.\n" + commandUsage);
        }

        if (CommandUtils.containsNonPositive(x1, y1, x2, y2)) {
            throw new InvalidCommandException("Error: x and y should be > 0 for rectangle command.\n" + commandUsage);
        }

        if (x1 > x2 || y1 > y2) {
            throw new InvalidCommandException("Error: upper left corner is (x1,y1) and lower right corner is (x2,y2).\n" + commandUsage);
        }
    }
}
