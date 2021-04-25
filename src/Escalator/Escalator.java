// 159.355 Assignment 2, Author: Yiming Shi, ID: 19023253
package Escalator;

import java.util.LinkedList;

public class Escalator extends Thread{
    public boolean direction = false;   // False means going downstairs, true means going upstairs.
    public boolean entrance_open = true;
    LinkedList<Thread> queue = new LinkedList<Thread>();

    public synchronized void run() {
        while (true) {
            // Reverse.
            if (direction) {
                direction = false;
                System.out.println("*** The escalator is going downstairs. ***");
            } else {
                direction = true;
                System.out.println("*** The escalator is going upstairs. ***");
            }

            // Running in this direction for a while.
            try {
                wait(200);
            } catch (InterruptedException e) {
                return;     // All done.
            }

            // Close the entrance and wait the rest passengers to get off.
            entrance_open = false;
            System.out.println("Ready to reverse, entrance closed.");
            if (queue.size() != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            entrance_open = true;
            // Ready to reverse, see you next loop!
        }
    }

    public synchronized boolean enterEscalator(int thread_id, boolean thread_direction) {
        // return false if the escalator is full.
        if (queue.size() >= 10 || this.direction != thread_direction) return false;

        //Get on.
        System.out.println("Thread-" + thread_id + " is getting ON.");
        queue.add(Thread.currentThread());
        if (queue.size() == 10) {System.out.println("*** Maximum capacity reached! ***");}

        // Wait until reach the destination.
        try {
            wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get off.
        System.out.println(queue.get(0).getName() + " is getting OFF.");
        queue.removeFirst();

        // Tell the escalator all passengers have get off.
        if (!entrance_open && queue.size() == 0) {
            notify();
        }
        return true;
    }
}
