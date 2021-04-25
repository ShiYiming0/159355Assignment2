// 159.355 Assignment 2, Author: Yiming Shi, ID: 19023253
package Library;

public class runLibrary {
    public static int number_of_books = 20;
    public static int number_of_people = 100;

    public static void main(String[] args) {
        Book[] library = new Book[number_of_books];
        Person[] people = new Person[number_of_people];
        java.util.Random r = new java.util.Random();

        for (int i = 0; i < number_of_books; i++) {
            library[i] = new Book(i+1);
        }
        for (int i = 0; i < number_of_people; i++) {
            people[i] = new Person(i+1, library[r.nextInt(number_of_books)], library[r.nextInt(number_of_books)], library[r.nextInt(number_of_books)]);
            people[i].start();
        }
    }
}
