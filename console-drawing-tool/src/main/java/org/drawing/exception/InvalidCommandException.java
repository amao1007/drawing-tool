package org.drawing.exception;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class InvalidCommandException extends  RuntimeException {
    private static final long serialVersionUID = 1L;
    public InvalidCommandException(String message) {
        super(message);
    }
}
