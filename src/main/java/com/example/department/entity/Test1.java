package com.example.department.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.MDC;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String args[]) throws JsonProcessingException {

        String jsonVal = "[\"a.txt\",\"b.txt\"]";

        System.out.println(jsonVal);

        ObjectMapper mapper = new ObjectMapper();
        List<String> files = mapper.readValue(jsonVal,new TypeReference<List<String>>(){ });

        System.out.println("Files vals"+files.toString());

        List<Integer> filterParam2 = new ArrayList<>();
        filterParam2.add(1545);
        filterParam2.add(1546);

        List<Integer> primaryFilter = new ArrayList<>();
        primaryFilter.add(1549);
        primaryFilter.add(1550);
        primaryFilter.add(1545);

        List<Department> depts = new ArrayList<>();
        Department d1 = new Department(1,"name1","add1","code1");
        Department d2 = new Department(2,"name2",null,"code2");
        Department d3 = new Department(3,"name3","add3","code3");
        depts.add(d1);
        depts.add(d2);
        depts.add(d3);

        System.out.println("------>"+CollectionUtils.containsAny(primaryFilter,filterParam2));
        boolean var = primaryFilter.stream().anyMatch(element -> !filterParam2.contains(element));
        System.out.println("------>"+ var);

        boolean isnull = depts.stream().anyMatch(element -> element.getDepartmentAddress() == null || element.getDepartmentAddress()=="");
        System.out.println("------>"+ isnull);

     /*  String vaal = String.join("*", filterParam2.toString());
        System.out.println(vaal);
        String pattern = "[\\[\\]]";
       String result = filterParam2.toString().replaceAll(pattern,"");
        System.out.println(result); */

    }
}


