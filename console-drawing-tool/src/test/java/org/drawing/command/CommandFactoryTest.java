package org.drawing.command;

import org.drawing.exception.InvalidCommandException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CommandFactoryTest {
    private CommandFactory commandFactory;

    @Before
    public void setUp() {
        commandFactory = new CommandFactory();
    }

    @Test
    public void testGetCanvasCommand() {
        Command canvasCommand = commandFactory.getCommand("c 10 15");
        Assert.assertTrue(canvasCommand instanceof CanvasCommand);
        Assert.assertEquals(10, ((CanvasCommand)canvasCommand).getWidth());
        Assert.assertEquals(15, ((CanvasCommand)canvasCommand).getHeight());
    }

    @Test
    public void testGetLineCommand() {
        Command  lineCommand = commandFactory.getCommand("L 1 2 1 5");
        Assert.assertTrue(lineCommand instanceof LineCommand);
        Assert.assertEquals(1, ((LineCommand)lineCommand).getX1());
        Assert.assertEquals(2, ((LineCommand)lineCommand).getY1());
        Assert.assertEquals(1, ((LineCommand)lineCommand).getX2());
        Assert.assertEquals(5, ((LineCommand)lineCommand).getY2());
    }

    @Test
    public void testGetRectangleCommand() {
        Command rectangleCommand = commandFactory.getCommand("R 1 1 5 5");
        Assert.assertTrue(rectangleCommand instanceof RectangleCommand);
        Assert.assertEquals(1, ((RectangleCommand)rectangleCommand).getX1());
        Assert.assertEquals(1, ((RectangleCommand)rectangleCommand).getY1());
        Assert.assertEquals(5, ((RectangleCommand)rectangleCommand).getX2());
        Assert.assertEquals(5, ((RectangleCommand)rectangleCommand).getY2());
    }

    @Test
    public void testGetQuitCommand() {
        Command quiteCommand = commandFactory.getCommand("Q");
        Assert.assertTrue(quiteCommand instanceof QuitCommand);
    }

    @Test(expected = InvalidCommandException.class)
    public void testUnknownCommand() {
        commandFactory.getCommand("S");
    }



}