package me.whiteship.java;

@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void printName() {
        System.out.println("Jiwon");
    }
    default void printAge() {
        System.out.println("28");
    }
}
