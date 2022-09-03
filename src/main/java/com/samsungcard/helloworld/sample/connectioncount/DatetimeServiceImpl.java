package com.samsungcard.helloworld.sample.connectioncount;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional(value = "doubleChainedTransactionManager")
public class DatetimeServiceImpl implements  DatetimeService {

    private DatetimeDao firstDatetimeDao;
    private DatetimeDao secondDatetimeDao;

    @Autowired
    private BasicDataSource firstDataSource;
    @Autowired
    private BasicDataSource secondDataSource;

    public DatetimeServiceImpl(DatetimeDao firstDatetimeDao, DatetimeDao secondDatetimeDao) {
        this.firstDatetimeDao = firstDatetimeDao;
        this.secondDatetimeDao = secondDatetimeDao;
    }

    @Override
    @Transactional(value = "doubleChainedTransactionManager")
    public void getDatetimeFromFirst() {
        System.out.println("start getDatetimeFromFirst firstDataSource connection count : " + firstDataSource.getNumActive());
        System.out.println("start getDatetimeFromFirst secondDataSource connection count : " + secondDataSource.getNumActive());

        System.out.println("First datetime : " + firstDatetimeDao.getDatetime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end getDatetimeFromFirst firstDataSource connection count : " + firstDataSource.getNumActive());
        System.out.println("end getDatetimeFromFirst secondDataSource connection count : " + secondDataSource.getNumActive());
    }

    @Override
    @Transactional(value = "doubleChainedTransactionManager")
    public void getDatetimeFromSecond() {
        System.out.println("start getDatetimeFromSecond firstDataSource connection count : " + firstDataSource.getNumActive());
        System.out.println("start getDatetimeFromSecond secondDataSource connection count : " + secondDataSource.getNumActive());
        System.out.println("Second datetime : " + secondDatetimeDao.getDatetime());
        System.out.println("end getDatetimeFromSecond firstDataSource connection count : " + firstDataSource.getNumActive());
        System.out.println("end getDatetimeFromSecond secondDataSource connection count : " + secondDataSource.getNumActive());
    }
}
