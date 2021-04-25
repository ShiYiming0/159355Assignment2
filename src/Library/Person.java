// 159.355 Assignment 2, Author: Yiming Shi, ID: 19023253
package Library;

public class Person extends Thread {
    int id;
    Book[] books;
    public Person(int id, Book book1, Book book2, Book book3) {
        this.id = id;
        this.books = new Book[3];
        this.books[0] = book1;
        this.books[1] = book2;
        this.books[2] = book3;
    }
    public void run() {
        // Don't want all the threads trying at once!
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i ++) {
            // Try to get the book.
            System.out.println("Thread " + this.id + " wants book " + books[i].book_id + ".");
            books[i].get_book(this.id);
        }

    }
}
