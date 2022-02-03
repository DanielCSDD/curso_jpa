package com.curso.jpa.exception.generico;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class AppException extends Exception{

    public AppException(String str){
        super(str);
    }

    public AppException(Throwable thro){
        super(thro);
    }

    public AppException(String str, Throwable thro){
        super(str, thro);
    }

}
