package com.hachicore.demospringdi;

public class BookServicProxy implements BookService {

    BookService bookService;

    public BookServicProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("aaaaa");
        bookService.rent(book);
        System.out.println("bbbbb");
        // System.out.println("rent: hibernate");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("aaaaa");
        bookService.returnBook(book);
    }
}
