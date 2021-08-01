package me.whiteship.java;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        Plus10 plus = new Plus10();
        System.out.println("plus10 = " + plus.apply(1));

        // 함수형 인터페이스

        Function<Integer, Integer> plus10 = (i) -> i + 10; // Function -> UnaryOperator 타입으로 변경 가능
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        System.out.println("==Function==");
        System.out.println(plus10.compose(multiply2).apply(2)); // compose 먼저한 결과값을 plus10에 대입
        System.out.println(plus10.andThen(multiply2).apply(2)); // plus10 결과앖을 multiply에 대입

        UnaryOperator<Integer> uPlus10 = (i) -> i + 10;
        UnaryOperator<Integer> uMultiply2 = (i) -> i * 2;

        System.out.println("==UnaryOperator==");
        System.out.println(uPlus10.compose(uMultiply2).apply(2)); // compose 먼저한 결과값을 plus10에 대입
        System.out.println(uPlus10.andThen(uMultiply2).apply(2)); // plus10 결과앖을 multiply에 대입

        Consumer<Integer> printT = (i) -> System.out.println("Consumer<T> : " + i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println("Supplier<T> : " + get10.get());

        Predicate<String> startsWithJiwon = (s) -> s.startsWith("jiwon");
        Predicate<Integer> isEven = (i) -> i%2 == 0;
    }
}
