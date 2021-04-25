// 159.355 Assignment 2, Author: Yiming Shi, ID: 19023253
package Library;

public class Book {
    int book_id;
    public Book(int book_id) {
        this.book_id = book_id;
    }
    public synchronized void get_book(int id) {
        //Thread gets the book
        System.out.println("Library gives book " + this.book_id + " to thread " + id + ".");
        //Thread keeps the book for a while.
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread returns the book
        System.out.println("Thread " + id + " returns book " + this.book_id + " to library.");
    }
}
