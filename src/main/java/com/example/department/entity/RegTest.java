package com.example.department.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

    public static void main(String args[]){
        String input = "Some text 4  CUSIP:12345678123456788999997878878785588888A INCR Some more text 4  CUSIP:98765432A INCR";
        //String input = "Some text 4  CUSIP:A INCR Some more text";
        String regex = "4\\s{2}CUSIP:(.*?)A INCR";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println("Hello"+matcher.group(1));
        }
    }
}
