package com.example.department.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx11 {

    public static void main(String args[]){
        String dateStr = "12.20.2020";
        String regex = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d{2}$";
        String regex2 = "^(?:(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)\\d{2})|(0[1-9]|1[0-2])\\.(0[1-9]|[12][0-9]|3[01])\\.(19|20)\\d{2}$";

        Pattern relaxedPattern = Pattern.compile(regex2);
        Matcher relaxedMatcher = relaxedPattern.matcher(dateStr);

        if (relaxedMatcher.matches()) {
            System.out.println("Date format matched");
        } else {
            System.out.println("Date format does not match");
        }
    }
}
