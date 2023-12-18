package org.drawing.drawer;

import org.drawing.command.Command;
import org.drawing.shape.BaseShape;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/

public interface Drawer {
    String draw(Command command);
}
