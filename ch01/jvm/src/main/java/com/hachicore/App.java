package com.hachicore;

/**
 * Hello world!
 */
public class App {

    static String name = "hachicore";

    public static void main(String[] args) {
        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());  // native로 구현되어 실제로 있으나 볼 수는 없음
    }
}
