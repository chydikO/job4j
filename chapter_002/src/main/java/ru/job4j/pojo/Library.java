package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Head First Java", 381);
        Book book2 = new Book("Java. Методы программирования", 456);
        String searchString = "Clean code";
        Book book3 = new Book(searchString, 789);
        Book book4 = new Book("Java 8. Руководство для начинающих", 987);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int index = 0; index < books.length; index++) {
            System.out.format("book name: %s, page: %s\n", books[index].getName(), books[index].getPages());
        }

        System.out.println("----------");

        Book tmpBook = books[3];
        books[3] = books[0];
        books[0] = tmpBook;

        for (int index = 0; index < books.length; index++) {
            System.out.format("book name: %s, page: %s\n", books[index].getName(), books[index].getPages());
        }

        System.out.println("----------");

        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals(searchString)) {
                System.out.format("book name: %s, page: %s\n", books[index].getName(), books[index].getPages());
            }
        }
    }
}
