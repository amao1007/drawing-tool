package org.drawing.drawer;

import org.drawing.command.CanvasCommand;
import org.drawing.command.Command;
import org.drawing.command.LineCommand;
import org.drawing.command.RectangleCommand;
import org.drawing.exception.CanvasDrawException;
import org.drawing.shape.Canvas;

import java.util.Arrays;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CanvasDrawer implements Drawer {
    public static final char HORIZONTAL_EDGE = '-';

    public static final char VERTICAL_EDGE = '|';

    public static final char LINE = 'x';

    public static final char EMPTY = ' ';

    private Canvas baseCanvas;

    private char[][] pixels;

    @Override
    public String draw(Command command) throws CanvasDrawException {
        if (command instanceof CanvasCommand canvasCommand) {
            baseCanvas = Canvas.builder()
                    .width(canvasCommand.getWidth())
                    .height(canvasCommand.getHeight()).build();
            pixels = new char[baseCanvas.getHeight() + 2][baseCanvas.getWidth() + 2];
            for (char[] chars : pixels) {
                Arrays.fill(chars, EMPTY);
            }
            drawCanvas();
            return generateOutput();
        } else if (command instanceof LineCommand lineCommand) {
            checkBaseCanvas(lineCommand.getX1(), lineCommand.getY1(), lineCommand.getX2(), lineCommand.getY2());
            drawLine(lineCommand.getX1(), lineCommand.getX2(), lineCommand.getY1(), lineCommand.getY2());
            return generateOutput();
        } else if (command instanceof RectangleCommand rectangleCommand) {
            checkBaseCanvas(rectangleCommand.getX1(), rectangleCommand.getY1(), rectangleCommand.getX2(), rectangleCommand.getY2());
            drawRectangles(rectangleCommand.getX1(), rectangleCommand.getX2(), rectangleCommand.getY1(), rectangleCommand.getY2());
            return generateOutput();
        }
        return null;
    }


    void checkBaseCanvas(int x1, int y1, int x2, int y2) {
        if (baseCanvas == null) {
            throw new CanvasDrawException("Error: Canvas is not existing. Please user 'C w h' command to create canvas first!");
        }

        if (x1 > baseCanvas.getWidth())
        {
            String error = String.format("Error: out of canvas. x1 '%d' is greater than canvas width '%d", x1, baseCanvas.getWidth());
            throw new CanvasDrawException(error);
        }

        if (y1 > baseCanvas.getHeight())
        {
            String error = String.format("Error: out of canvas. y1 %d is greater than canvas height %d", y1,  baseCanvas.getHeight());
            throw new CanvasDrawException(error);
        }

        if (x2 > baseCanvas.getWidth())
        {
            String error = String.format("Error: out of canvas. x2 %d is greater than canvas width %d", x2,  baseCanvas.getWidth());
            throw new CanvasDrawException(error);
        }
        if (y2 > baseCanvas.getHeight())
        {
            String error = String.format("Error: out of canvas. y2 %d is greater than canvas height %d", y2, baseCanvas.getHeight());
            throw new CanvasDrawException(error);
        }
    }

    void drawCanvas() {
        drawHorizontalLine(0,0, baseCanvas.getWidth() + 2, HORIZONTAL_EDGE);
        drawHorizontalLine(0, baseCanvas.getHeight() + 1, baseCanvas.getWidth() + 2, HORIZONTAL_EDGE);
        drawVerticalLine(0,1, baseCanvas.getHeight(), VERTICAL_EDGE);
        drawVerticalLine( baseCanvas.getWidth() + 1,1, baseCanvas.getHeight(), VERTICAL_EDGE);
    }

    void drawRectangles(int x1, int x2, int y1, int y2) {
        drawHorizontalLine(x1, y1, x2-x1 + 1, LINE);
        drawHorizontalLine(x1, y2, x2-x1 + 1, LINE);

        if (y2 - y1 > 1) {
            drawVerticalLine(x1,y1+1, y2-y1-1, LINE);
            drawVerticalLine( x2,y1+1, y2-y1-1, LINE);
        }

    }

    void drawLine(int x1, int x2, int y1, int y2) {
        //only supports horizontal or vertical lines
        if (x1 == x2) {
            if (y1 > y2) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            drawVerticalLine(x1, y1, y2-y1 + 1, LINE);
        } else if (y1 == y2) {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            drawHorizontalLine(x1, y1, x2-x1 + 1, LINE);
        }
    }


    void drawHorizontalLine(int startX, int startY, int length, char brush) {
       Arrays.fill(pixels[startY], startX, startX + length, brush);
    }

    void drawVerticalLine(int startX, int startY, int length, char brush) {
        for(int i = startY; i< startY + length; i++) {
            pixels[i][startX] = brush;
        }
    }

    public String generateOutput() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseCanvas.getHeight() + 2; i++) {
            for (int j = 0; j < baseCanvas.getWidth() + 2; j++) {
                builder.append(pixels[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
