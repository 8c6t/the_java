package com.hachicore;

public class Masulsa {

    public static void main(String[] args) {
//        ClassLoader classLoader = Masulsa.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//        // 바이트 코드 변환
//        try {
//            new ByteBuddy().redefine(
//                    typePool.describe("com.hachicore.Moja").resolve(),
//                    ClassFileLocator.ForClassLoader.of(classLoader))
//                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit"))
//                    .make().saveIn(new File("D:\\workspace\\java\\the_java\\ch02\\bytecode\\target\\classes\\"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(new Moja().pullOut());
    }

}
