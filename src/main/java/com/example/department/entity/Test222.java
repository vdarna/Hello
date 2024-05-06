package com.example.department.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test222 {

    public static void main(String args[]){
        TimeZone timeZone1 = TimeZone.getTimeZone("America/Los_Angeles");

        System.out.println(""+timeZone1.getDisplayName(false,TimeZone.SHORT));

        List<String> phoneNumbers = new ArrayList();
        phoneNumbers.add("1234567890");
        phoneNumbers.add("123-456-7890");
        phoneNumbers.add("123.456.7890");
        phoneNumbers.add("123 456 7890");
        phoneNumbers.add("(123) 456 7890");

//Invalid phone numbers
        phoneNumbers.add("12345678");
        phoneNumbers.add("12-12-111");

        String regex1 = "^\\(?([0-9]{3})\\)?[-\\s]?([0-9]{3})[-\\s]?([0-9]{4})$";
        String regex = "^\\(?([0-9]{3})\\)?-?([0-9]{3})-?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);

        for(String email : phoneNumbers)
        {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email +" : "+ matcher.matches());
        }
    }
}
