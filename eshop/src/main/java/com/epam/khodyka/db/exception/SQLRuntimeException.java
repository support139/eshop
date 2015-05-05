package com.epam.khodyka.db.exception;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class SQLRuntimeException extends RuntimeException {

    public SQLRuntimeException(){

    }

    public SQLRuntimeException(String message){
        super(message);
    }
}
