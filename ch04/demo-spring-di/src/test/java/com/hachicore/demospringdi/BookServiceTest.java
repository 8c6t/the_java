package com.hachicore.demospringdi;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Test
    public void di() throws Exception {
        BookRepository bookRepositoryMock = mock(BookRepository.class);

        Book hibernateBook = new Book();
        hibernateBook.setTitle("Hibernate");
        when(bookRepositoryMock.save(any())).thenReturn(hibernateBook);

        BookService bookService = new BookService(bookRepositoryMock);

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

    @Test
    public void di_cglib() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new BookService();
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("aaaa");
                    Object invoke = method.invoke(bookService, objects);
                    System.out.println("bbbb");
                    return invoke;
                }
                return method.invoke(bookService, objects);
            }
        };

        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);

        bookService.returnBook(book);
    }

    @Test
    public void di_bytebuddy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookService bookService = new BookService();
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("aaaa");
                        Object invoke = method.invoke(bookService, objects);
                        System.out.println("bbbb");
                        return invoke;
                    }
                }))
                .make().load(BookService.class.getClassLoader()).getLoaded();

//        Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
//                .method(named("rent")).intercept(InvocationHandlerAdapter.of((o, method, objects) -> {
//                    BookService bookService = new BookService();
//                    System.out.println("aaaa");
//                    Object invoke = method.invoke(bookService, objects);
//                    System.out.println("bbbb");
//                    return invoke;
//                }))
//                .make().load(BookService.class.getClassLoader()).getLoaded();

        BookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);

        bookService.returnBook(book);
    }

}