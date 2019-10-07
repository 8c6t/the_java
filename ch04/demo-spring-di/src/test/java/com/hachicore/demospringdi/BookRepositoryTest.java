package com.hachicore.demospringdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
// @SpringBootTest
@DataJpaTest // 테스트 시 SQL 로깅 지원
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void di() {
        assertNotNull(bookRepository);

        Book book = new Book();
        book.setTitle("spring");
        bookRepository.save(book);
        bookRepository.findAll();

    }

}