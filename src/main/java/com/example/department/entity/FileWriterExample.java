package com.example.department.entity;


import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String data = "This is the data to be written to the file.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}