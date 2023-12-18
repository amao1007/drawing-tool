package org.drawing.exception;

/**
 * Copyright (c) 2023 Vic.cn. All rights reserved.
 *
 * @author vic cheng
 * @date 2023/12/17
 **/
public class InvalidCommandException extends  RuntimeException {
    public InvalidCommandException(String message) {
        super(message);
    }
}
