package com.hachicore.demospringdi;

import org.junit.Test;

public class BookServiceTest {

    BookService bookService = new BookServicProxy(new DefaultBookService());

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
    }

}