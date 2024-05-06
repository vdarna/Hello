package com.example.department.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class PropertyCheckPassword {



    public static void main(String args[]){
    try {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                //System.exit(1);

            }
            System.out.println("Password is :" + i);
        }
    }catch (Exception e){
        System.out.println("Exception occured "+e);
    }
    }
}
