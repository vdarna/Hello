package com.example.department.entity;

public class tess222 {


        public static void main(String[] args) {

            String substring = "   Hello   World          Example   Validation      purpose   ";



            System.out.println(substring+"Before length of string::"+substring.length());
                int spaceCount=0;
                for(int k=0;k<63;k++) {
                    if (substring.charAt(k) == ' ') {
                        spaceCount++;
                        substring= substring.concat(" ");
                    }else{
                        break;
                    }

                }
                substring = substring.replaceFirst("^\\s+", ""); // Remove leading spaces

             

                System.out.println(substring+"length of string::"+substring.length());


           // System.out.println("String after replacing a character's first occurrence: "+res);

        }
    }
