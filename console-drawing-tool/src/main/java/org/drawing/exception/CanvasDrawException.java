package org.drawing.exception;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class CanvasDrawException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public CanvasDrawException(String message) {
        super(message);
    }
}
