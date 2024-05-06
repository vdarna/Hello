package com.example.department.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.*;
class RegexExample6{
    public static void main(String args[]){
       // System.out.println(Pattern.matches("[0-9]{6}", "123456"));//true
       // System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched)

        System.out.println(Pattern.matches("^[a-zA-Z0-9]+[\\d\\/\\(\\)\\- \\ -]+$","12-12/2020"));

        BigDecimal val = new BigDecimal(25.123);
       // val = val.stripTrailingZeros();
       // BigInteger decimal = val.remainder(BigDecimal.ONE).movePointRight(val.scale()).abs().toBigInteger();
      //  BigDecimal fracBd = val.subtract(new BigDecimal(val.toBigInteger()));
      //  BigDecimal fracBd2 = val.subtract(new BigDecimal(val.toBigInteger())).abs();

     //   BigDecimal fractPart = val.remainder(BigDecimal.ONE);
       // StringBuilder sb = new StringBuilder(fractPart.toString());
       // sb.delete(0, 2);
       // String str = sb.toString();
        System.out.println(val.toEngineeringString());
        System.out.println(val.toPlainString());
        System.out.println(val.toString());

        String res = String.valueOf(val).split(".")[1];
        System.out.println("Result ::::::::"+res);
        if(val.equals(0)){
            System.out.println("Hello--->");
        }

    }}
