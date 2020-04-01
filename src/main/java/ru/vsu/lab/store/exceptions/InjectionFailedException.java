package ru.vsu.lab.store.exceptions;


/**
 * Class for injection exceptions
 */
public class InjectionFailedException extends Exception{
    public InjectionFailedException(Exception e){
        e.printStackTrace();
    }
}
