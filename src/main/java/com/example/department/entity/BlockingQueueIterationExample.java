package com.example.department.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueIterationExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("Item1_go");
        queue.add("Item2_kep");
        queue.add("Item3_stp");
      // String resp =  queue.stream().filter(x->x.contains("Item")).collect().toString();
        //List<String> items = new ArrayList<>();
       // queue.drainTo(items);

        String item = queue.stream()
                .filter(i -> i.contains("Item2")) // Apply the condition (e.g., item should be greater than 15)
                .findFirst()         // Find the first item that matches the condition
                .orElse(null);

        System.out.println(item);
    }
}
