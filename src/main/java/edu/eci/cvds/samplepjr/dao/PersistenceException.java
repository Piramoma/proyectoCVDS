package edu.eci.cvds.samplepjr.dao;

public class PersistenceException extends Exception{
    public PersistenceException(String mensage,Exception e){
        super( mensage, e);
    }
}
