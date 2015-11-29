/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.exception;

/**
 *
 * @author jhoanseve2
 */
public class FactjayException extends RuntimeException {

    /**
     * Creates a new instance of <code>FactjayException</code> without detail
     * message.
     */
    public FactjayException() {
    }

    /**
     * Constructs an instance of <code>FactjayException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FactjayException(String msg) {
        super(msg);
    }
}
