package com.cbw.jdbc;

import java.util.Date;

public class HelloWrold {
    public static void main(String[] args) {
        long currentTime=System.currentTimeMillis();
        System.out.println(currentTime);
        Date date=new Date(currentTime);
        System.out.println(date);
    }
}
