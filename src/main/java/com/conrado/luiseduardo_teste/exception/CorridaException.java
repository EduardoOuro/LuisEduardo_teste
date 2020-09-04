/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.exception;

import java.sql.SQLException;

/**
 *
 * @author Conrado
 */
public class CorridaException  extends Exception{
    
    public CorridaException(String msg, Throwable e){
        super(msg, e);
    }
}
