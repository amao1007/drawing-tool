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
public class LineCommand implements Command {
    private static final String commandUsage = """
           Command usage:
           'L x1 y1 x2 y2' -> Should create a new line from (x1,y1) to (x2,y2).
           Currently only horizontal or vertical lines are supported.
           """;

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public LineCommand(String[] params) {
        if (params.length != 4)
            throw new InvalidCommandException("Error: required 4 params for line command.\n" + commandUsage);
        try {
            x1 = Integer.parseInt(params[0]);
            y1 = Integer.parseInt(params[1]);
            x2= Integer.parseInt(params[2]);
            y2 = Integer.parseInt(params[3]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Error: invalid params for line command.\n" + commandUsage);
        }


        if (CommandUtils.containsNonPositive(x1, y1, x2, y2)) {
            throw new InvalidCommandException("Error: x and y should be > 0 for line command.\n" + commandUsage);
        }

        if (x1 != x2 && y1 != y2) {
            throw new InvalidCommandException("Error: only horizontal or vertical lines are supported.\n" + commandUsage);
        }
    }
}
