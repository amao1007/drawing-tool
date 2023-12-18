package org.drawing.drawer;

import org.drawing.command.*;
import org.drawing.exception.CanvasDrawException;
import org.junit.Assert;
import org.junit.Test;


/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CanvasDrawerTest {

    @Test
    public void testDrawCanvas() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        String output = canvasDrawer.draw(canvasCommand);
        Assert.assertNotNull(output);
    }

    @Test
    public void testDrawLine() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        canvasDrawer.draw(canvasCommand);
        Command lineCommand = new LineCommand(new String[] {"1", "1", "1", "5"});
        String output =canvasDrawer.draw(lineCommand);
        Assert.assertNotNull(output);

        lineCommand = new LineCommand(new String[] {"1", "5", "1", "1"});
        output =canvasDrawer.draw(lineCommand);
        Assert.assertNotNull(output);

        lineCommand = new LineCommand(new String[] {"5", "1", "1", "1"});
        output =canvasDrawer.draw(lineCommand);
        Assert.assertNotNull(output);
    }


    @Test(expected = CanvasDrawException.class)
    public void testDrawLineWithException() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command lineCommand = new LineCommand(new String[] {"1", "1", "1", "5"});
        canvasDrawer.draw(lineCommand);
    }

    @Test
    public void testDrawRectangle() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        canvasDrawer.draw(canvasCommand);
        Command rectangleCommand = new RectangleCommand(new String[] {"1", "1", "5", "5"});
        String output = canvasDrawer.draw(rectangleCommand);
        Assert.assertNotNull(output);
    }


    @Test(expected = CanvasDrawException.class)
    public void testDrawRectangleWithException() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command rectangleCommand = new RectangleCommand(new String[] {"1", "1", "5", "5"});
        canvasDrawer.draw(rectangleCommand);
    }

    @Test(expected = CanvasDrawException.class)
    public void testDrawRectangleWithException2() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        canvasDrawer.draw(canvasCommand);
        Command lineCommand = new LineCommand(new String[] {"15", "1", "15", "5"});
        canvasDrawer.draw(lineCommand);
    }

    @Test(expected = CanvasDrawException.class)
    public void testDrawRectangleWithException3() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        canvasDrawer.draw(canvasCommand);
        Command lineCommand = new LineCommand(new String[] {"1", "15", "1", "5"});
        canvasDrawer.draw(lineCommand);
    }

    @Test(expected = CanvasDrawException.class)
    public void testDrawRectangleWithException4() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        canvasDrawer.draw(canvasCommand);
        Command rectangleCommand = new RectangleCommand(new String[] {"1", "1", "15", "5"});
        canvasDrawer.draw(rectangleCommand);

    }

    @Test(expected = CanvasDrawException.class)
    public void testDrawRectangleWithException5() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Command canvasCommand = new CanvasCommand(new String[] {"10", "10"});
        canvasDrawer.draw(canvasCommand);
        Command rectangleCommand = new RectangleCommand(new String[] {"1", "1", "5", "15"});
        canvasDrawer.draw(rectangleCommand);

    }
}