package com.example.department.entity;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BiGGCheck {

    public static void main(String args[]) throws ParseException {

        System.out.println(Element.valueOfLabel("3"));

        String name = "hhh";
        Integer patId = null;
        Integer blamk =11;

        System.out.println(ObjectUtils.compare(patId,blamk) == 0);

        System.out.println(ObjectUtils.equals(patId,blamk));

        Date today = new Date();
        System.out.println("Complete ::::::::::"+today);
        System.out.println("Date ::::::::::"+today.getDate());
        System.out.println("Time ::::::::::"+today.getTime());

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println("Date in String :::: --->"+date);



        Date date2 = simpleDateFormat.parse(date);
        System.out.println("Date 2 :::: "+date2);


        Integer value1 = 20;

        Double d = Double.valueOf(value1);
        System.out.println("double value od int :::"+d);

        String boolString = "true";

        Boolean b = Boolean.valueOf(boolString);

        System.out.println("------>"+b);
        
        int f = -1;
        if(f<8)
            f= -f;
        System.out.println("asasasa::::"+f);
        Integer s = null;
        //System.out.println(Integer.compareUnsigned(2,s));

    int aa = 9;
    int bb =2;
    float ff = 2.25F;

    System.out.println("----&&&&"+aa+bb/ff);


       String s1 = null;
       String s2 = new String("Hello");

     //  System.out.println(s1.length());

        BigDecimal val123 = new BigDecimal(0.00).setScale(0,BigDecimal.ROUND_DOWN);

        System.out.println("********"+val123);
        Integer val21 = 2407;
        Integer val22 = 2407;

        if(val21 == val22){
            System.out.println(")))))))"+true);
        }else{
            System.out.println("else -->"+false);
        }

        System.out.println("----&&&&--->"+ObjectUtils.equals(val21,val22));
        System.out.println("======^^^^^^=====>>>"+val21.equals(val22));


    }
}
