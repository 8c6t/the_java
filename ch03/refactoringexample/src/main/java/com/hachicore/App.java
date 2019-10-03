package com.hachicore;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        // type
        Class<Book> bookClass = Book.class;
        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s, %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println("================");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        System.out.println("================");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        System.out.println("================");
        System.out.println(MyBook.class.getSuperclass());

        System.out.println("================");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println("================");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

/*        // instance
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        // FQCN
        Class.forName("com.hachicore.Book");*/


    }
}
