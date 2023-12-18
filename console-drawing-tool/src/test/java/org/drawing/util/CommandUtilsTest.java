package org.drawing.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CommandUtilsTest {

    @Test
    public void testContainsNonPositive() {
        boolean result = CommandUtils.containsNonPositive(1, 2, 2, 3);
        Assert.assertFalse(result);

        result = CommandUtils.containsNonPositive(1, -1);
        Assert.assertTrue(result);
    }


}