package com.com;

/**
 * Created by acer on 2017/3/16.
 */
public class Myexception extends RuntimeException {

    public  Myexception(){
        super();
    }
    public Myexception(String msg){
        super(msg);
    }
    public Myexception(String msg,Exception ex){
        super(msg,ex);
    }
}
