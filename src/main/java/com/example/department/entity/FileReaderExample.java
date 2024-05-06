package com.example.department.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        int chunkSize = 5; // Number of lines per chunk

        try (BufferedReader reader = new BufferedReader(new
                FileReader("C:\\Users\\admin\\Downloads\\sample-2mb-text-file.txt"))) {
            String[] lines = new String[chunkSize];
            int linesRead;
            int m =0;
            while ((linesRead = readChunk(reader, lines)) > 0 && m<2) {
               // processChunk(lines, linesRead);
                for (int i = 0; i < linesRead; i++) {
                    System.out.println(i+"---"+lines[i]);
                    m++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int readChunk(BufferedReader reader, String[] lines) throws IOException {
        int linesRead = 0;
        String line;
        while (linesRead < lines.length && (line = reader.readLine()) != null) {
            lines[linesRead++] = line;
        }
        return linesRead;
    }

    private static void processChunk(String[] lines, int linesRead) {
        // Process the chunk of lines here
        for (int i = 0; i < linesRead; i++) {
            System.out.println(i+"---"+lines[i]);
        }
    }
}

