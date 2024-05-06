package com.example.department.entity;

import java.math.BigDecimal;

public class DecimalLength {


    public static void main(String args[]){

        Double d= 122.434548;
      //  String doubleStr = Double.toString(Math.abs(d));
       // int integerPlaces = doubleStr.indexOf(".");
       // int decimalPlaces =  doubleStr.length() -  integerPlaces -1;
       // System.out.println("Number of decimal places in 122.434548: "+decimalPlaces);

        BigDecimal big = new BigDecimal(122.00);
        Double d2 = big.doubleValue();
        String doubleStr = Double.toString(Math.abs(d2));
        int integerPlaces = doubleStr.indexOf(".");
        int decimalPlaces =  doubleStr.length() -  integerPlaces -1;
        System.out.println("Number of decimal places in 122.3232: "+doubleStr.length());
        System.out.println("Number of decimal places in 122.434548: "+decimalPlaces);

    }
}
