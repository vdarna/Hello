package com.example.department.entity;

import org.apache.commons.validator.routines.DateValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingLocalDate extends DateValidator {
    private String dateFormat;
    public DateValidatorUsingLocalDate(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String args[]){

        DateValidatorUsingLocalDate d = new DateValidatorUsingLocalDate("MM/dd/yyyy");
        System.out.println(d.isValid("12/02/2020"));
    }
}
