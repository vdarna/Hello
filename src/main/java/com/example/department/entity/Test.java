package com.example.department.entity;



import java.math.BigDecimal;
        import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        BigDecimal originalValue = new BigDecimal("1234567895555.123456789");
        int newPrecision = 9;
        int newScale = 2;

        BigDecimal decreasedValue = originalValue.setScale(newScale, RoundingMode.HALF_UP)
                .setScale(9, RoundingMode.HALF_UP);

        System.out.println("Decreased Value: " + decreasedValue);

        String mainStr = "welcome file PricingData_062023.json";
        String substr = "PricingData_062023.json";

        if(mainStr.contains(substr)){
            System.out.println("Found");
        }
        String m = mainStr.substring(3,50);
    }
}
