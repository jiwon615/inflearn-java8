package me.whiteship.java;

public class Foo {

    public static void main(String[] args) {
        // 익명 내부 클래스
        RunSomething runSomething = new RunSomething() {

            @Override
            public void doIt() {
                System.out.println("Hello");
                System.out.println("World");
            }
        };
        runSomething.doIt();
    }
}
