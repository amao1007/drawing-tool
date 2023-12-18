package org.drawing.util;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CommandUtils {
    public static boolean containsNonPositive(int... numbers) {
        for (int num : numbers) {
            if (num < 1) {
                return true;
            }
        }
        return false;
    }
}
