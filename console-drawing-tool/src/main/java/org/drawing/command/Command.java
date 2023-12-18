package org.drawing.command;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public interface Command {
    String DEFAULT_HELP_MESSAGE = """
            This is a simple console drawing tool that can draw lines and rectangles on a canvas.
            Usage:
            'C w h' -> Create a new canvas of width w and height h.
            'L x1 y1 x2 y2' -> Create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported.
            'R x1 y1 x2 y2' -> Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
            'Q' -> Quite the program.
            """;

    String ENTER_COMMAND = "Enter command:";

    String CANVAS = "C";

    String LINE = "L";

    String RECTANGLE = "R";

    String QUIT = "Q";

}
