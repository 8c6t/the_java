package com.hachicore;

// @MyAnnotation(name="hachicore", number=8620)
@MyAnnotation("hachicore")
public class Book {

    @MyAnnotation
    private String a = "a";

    private static String b = "BOOK";

    private static final String C = "BOOK";

    public String d = "d";

    protected  String e = "e";

    public Book() {
    }

    // @MyAnnotation
    @AnotherAnnotation
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    @AnotherAnnotation
    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }

}
