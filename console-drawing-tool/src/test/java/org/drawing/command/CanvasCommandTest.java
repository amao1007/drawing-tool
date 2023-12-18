package org.drawing.command;

import org.drawing.exception.InvalidCommandException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CanvasCommandTest {

    @Test
    public void testNewCanvasCommand() {
        CanvasCommand command = new CanvasCommand(new String[] {"10", "10"});
        Assert.assertEquals(10, command.getWidth());
        Assert.assertEquals(10, command.getHeight());
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidCanvasCommand() {
       new CanvasCommand(new String[] {"-10", "10"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidCanvasCommand2() {
        new CanvasCommand(new String[] {"s", "10"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidCanvasCommand3() {
        new CanvasCommand(new String[] {"10"});
    }
}