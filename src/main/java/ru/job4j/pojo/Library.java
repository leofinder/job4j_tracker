package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book code = new Book("Clean code", 464);
        Book algorithms = new Book("Grokking algorithms", 288);
        Book java = new Book("Thinking in Java", 1168);
        Book interview = new Book("Cracking the coding interview", 688);
        Book[] books = new Book[4];
        books[0] = code;
        books[1] = algorithms;
        books[2] = java;
        books[3] = interview;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + ". Pages: " + book.getPages());
        }
        System.out.println("Replace 0 and 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + ". Pages: " + book.getPages());
        }
        System.out.println("Show only Clean code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ". Pages: " + book.getPages());
            }
        }
    }
}
