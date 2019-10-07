package com.hachicore.demospringdi;

public class BookService {

    BookRepository bookRepository;

    public BookService() {
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void rent(Book book) {
        Book save = bookRepository.save(book);
        System.out.println("rent: " + save.getTitle());
    }

    public void returnBook(Book book) {
        Book save = bookRepository.save(book);
        System.out.println("return: " + save.getTitle());
    }

}
