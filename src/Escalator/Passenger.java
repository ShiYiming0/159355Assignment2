// 159.355 Assignment 2, Author: Yiming Shi, ID: 19023253
package Escalator;

public class Passenger extends Thread{
    private Escalator escalator;
    private int thread_id;
    private boolean thread_direction;

    Passenger(Escalator escalator, int thread_id, boolean thread_direction){
        this.escalator = escalator;
        this.thread_id = thread_id;
        this.thread_direction = thread_direction;
    }

    public void run() {
        // Don't want all the threads trying at once!
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Try to get on the escalator.
        while (true) {
            if (!escalator.entrance_open) {
                continue;
            }
            if (!escalator.enterEscalator(thread_id, thread_direction)) {
                // No more space, so get away and come back later.
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {break;}
        }
    }
}
