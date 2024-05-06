package com.example.department.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String args[]){

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bbb2");
        list.add("kkk");
        list.add("bbb1");
        list.add("mmm");
        list.add("bbb3");

        List<String> filterList = new ArrayList<>();
        list.stream().forEach(z->{

            if(z.contains("bbb")){
                filterList.add(z.toUpperCase());
            }
        });

        System.out.println(filterList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        List<String> mapList = list.stream().map(x->{
            if(x.contains("bbb")){
                return x.toUpperCase();
            }else {return x;}
        }).collect(Collectors.toList());

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,"venu",30));
        empList.add(new Employee(2,"gopal1",26));
        empList.add(new Employee(2,"gopal2",23));
        empList.add(new Employee(2,"gopal31",18));
        empList.add(new Employee(2,"gopal4",38));
        empList.add(new Employee(2,"gopal5",13));

        List<Employee> modifiedone = empList.stream().
                sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());

        System.out.println(modifiedone);

        String fileName = "sa.mple.txt";
        int ind = fileName.lastIndexOf(".");
        if(ind>=0){
            fileName = fileName.substring(0,ind);
        }
        System.out.println(fileName);
    }
}
