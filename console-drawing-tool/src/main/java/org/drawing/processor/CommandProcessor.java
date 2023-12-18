package org.drawing.processor;

import org.drawing.command.Command;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/18
 **/
public interface CommandProcessor {
    void process(String command);
}
