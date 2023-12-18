package org.drawing.shape;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
@Data
@Builder
public class Canvas implements BaseShape {
    private int width;
    private int height;
}
