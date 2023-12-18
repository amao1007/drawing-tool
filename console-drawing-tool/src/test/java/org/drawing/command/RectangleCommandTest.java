package org.drawing.command;

import org.drawing.exception.InvalidCommandException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class RectangleCommandTest {
    @Test
    public void testNewRectangleCommand() {
        RectangleCommand command = new RectangleCommand(new String[] {"1", "10" , "5", "15"});
        Assert.assertEquals(1, command.getX1());
        Assert.assertEquals(10, command.getY1());
        Assert.assertEquals(5, command.getX2());
        Assert.assertEquals(15, command.getY2());
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidRectangleCommand() {
        new RectangleCommand(new String[] {"10", "10"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidRectangleCommand2() {
        new RectangleCommand(new String[] {"s", "10", "5", "12"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidRectangleCommand3() {
        new RectangleCommand(new String[] {"0", "10", "15", "20"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidRectangleCommand4() {
        new RectangleCommand(new String[] {"10", "10", "5", "20"});
    }
}