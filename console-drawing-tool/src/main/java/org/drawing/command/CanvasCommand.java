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
public class CanvasCommand implements Command {
    private static final String commandUsage = """
           Command usage:
           'C w h' -> Should create a new canvas of width w and height h.
           w, h should be > 0
           """;

    private final int height;
    private final int width;

    public CanvasCommand(String[] params) {
        if (params.length != 2)
            throw new InvalidCommandException("Error: required 2 params for canvas command.\n" + commandUsage);

        try {
            width = Integer.parseInt(params[0]);
            height = Integer.parseInt(params[1]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Error: invalid params for canvas command.\n" + commandUsage);
        }

        if (CommandUtils.containsNonPositive(height, width)) {
            throw new InvalidCommandException("Error: width and height should be > 0.\n" + commandUsage);
        }
    }

}
