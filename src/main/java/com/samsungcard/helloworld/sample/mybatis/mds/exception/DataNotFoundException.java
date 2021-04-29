package com.samsungcard.helloworld.sample.mybatis.mds.exception;

public class DataNotFoundException  extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
