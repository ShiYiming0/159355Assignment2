// 159.355 Assignment 2, Author: Yiming Shi, ID: 19023253
package Escalator;

public class RunEscalator {
    public static int number_of_people = 100;

    public static void main(String[] args) {
        System.out.println("*** The escalator is running! ***");
        Escalator escalator = new Escalator();
        escalator.start();

        Passenger[] passengers = new Passenger[number_of_people];
        //Odd id wants to go downstairs, even id wants to go upstairs
        for (int i = 0; i < number_of_people; i ++) {
            if (i%2 == 1) {
                passengers[i] = new Passenger(escalator, i+1, true);
            } else {
                passengers[i] = new Passenger(escalator, i+1, false);
            }
            passengers[i].start();
        }

        // terminate gracefully
        for (int i = 0; i < number_of_people; i++) {
            try {
                passengers[i].join();
            } catch (InterruptedException e) {}
        }
        escalator.interrupt();
        System.out.println("*** All done! Terminate the escalator. ***");
    }
}
