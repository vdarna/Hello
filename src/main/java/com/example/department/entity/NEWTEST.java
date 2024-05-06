package com.example.department.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NEWTEST {

    public static void main(String args[]) {
        String value = null; // Set the value to null to cause an exception in .toString()

        String res = "This is. TMP and tmp.a1234";
        String REGeX = "[0-9]+";
        Pattern p = Pattern.compile(REGeX);
        Matcher m = p.matcher(res.substring(res.lastIndexOf(".")+1));

        System.out.println(m.matches());

    }
}