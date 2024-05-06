package com.example.department.entity;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test2 {


    public static void main(String args[]) throws InterruptedException {

        HashMap<String, List<Integer>> hashMapOfLists = new HashMap<>();

        // Add values to the list associated with each key
        addValue(hashMapOfLists, "key1", 1);
        addValue(hashMapOfLists, "key1", 2);
        addValue(hashMapOfLists, "key2", 3);
        addValue(hashMapOfLists, "key2", 4);
        addValue(hashMapOfLists, "key2", 5);

        // Print the values for each key
        for (String key : hashMapOfLists.keySet()) {
            System.out.println(key + ": " + hashMapOfLists.get(key));
        }


        // Create a blocking queue with a fixed capacity of 3s
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // Create and start producer and consumer threads
      //  Thread producerThread = new Thread(() -> {
           // try {
                // Add elements to the blocking queue
                blockingQueue.put("Message 1");

                blockingQueue.put("Message 2");

                blockingQueue.put("Message 3");

                // The next put() will block until space is available in the queue
                blockingQueue.put("Message 4");
        while (!blockingQueue.isEmpty()) {
            String item = blockingQueue.poll();
            System.out.println(item);
        }
           /* } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

       /* Thread consumerThread = new Thread(() -> {
            try {
                // Retrieve elements from the blocking queue
                Thread.sleep(2000); // Simulate some processing time
                System.out.println("Consumer got: " + blockingQueue.take());
                Thread.sleep(2000); // Simulate some processing time
                System.out.println("Consumer got: " + blockingQueue.take());
                Thread.sleep(2000); // Simulate some processing time
                System.out.println("Consumer got: " + blockingQueue.take());
                // The next take() will block until an element is available in the queue
                System.out.println("Consumer got: " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/


    }

    private static <K, V> void addValue(Map<K, List<V>> map, K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);

    }
}
