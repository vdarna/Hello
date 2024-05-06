package com.example.department.entity;

import java.util.regex.Pattern;

public class tess {


        public static void main(String[] args) {

            String input = "   Hello   World          Example   Validation      purpose   ";
            int substringLength = 7;
            int inputLength = input.length();
            String[] arr;
            for (int i = 0; i < inputLength; i += substringLength) {
               int len =0;
                int endIndex = Math.min(i + substringLength, inputLength);
                for(int k=i;k<endIndex;k++){
                    if(input.charAt(i)==' '){
                        i++;
                        endIndex++;
                    }
                }
                String substring = input.substring(i, endIndex);

                System.out.println("start::"+i+"end::"+endIndex);
                substring = substring.replaceFirst("^\\s+", ""); // Remove leading spaces


                System.out.println(substring);
            }

           // System.out.println("String after replacing a character's first occurrence: "+res);

        }
    }
