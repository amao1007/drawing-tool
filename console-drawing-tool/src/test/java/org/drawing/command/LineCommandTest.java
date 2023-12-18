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
public class LineCommandTest {

    @Test
    public void testNewLineCommand() {
        LineCommand command = new LineCommand(new String[] {"1", "10" , "1", "15"});
        Assert.assertEquals(1, command.getX1());
        Assert.assertEquals(10, command.getY1());
        Assert.assertEquals(1, command.getX2());
        Assert.assertEquals(15, command.getY2());
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidLineCommand() {
        new LineCommand(new String[] {"10", "10"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidLineCommand2() {
        new LineCommand(new String[] {"s", "10", "1", "12"});
    }

    @Test(expected = InvalidCommandException.class)
    public void testInvalidLineCommand3() {
        new LineCommand(new String[] {"0", "10", "15", "10"});
    }
}