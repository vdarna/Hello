package com.example.department.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test33 {

   public static void main(String args[]){

       Map<String,String> headers = new LinkedHashMap<>();
       headers.put("s.no","serial Number");
       headers.put("Name","name");
       headers.put("Age","age");

       System.out.println(headers.values().stream().collect(Collectors.toList()));

       String example = "abcd";
       System.out.println("length "+example.split("-")[0]);

       String value = "sample";
       String value1 = "sample2";
      // System.out.println("value after string-->"+value.substring(0,value.lastIndexOf(".dat")));
        System.out.println("hashcode -->"+value.hashCode()+"--"+value1.hashCode());
   }
}
