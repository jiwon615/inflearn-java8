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

        BinaryOperator<Integer> sum = (a, b) -> a+ b;

        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;  // effective final 변수: final 이란 키워드 없이도 사실상 final 변수 역할로서, 아래에서 참조 가능

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11; // 왼쪽 변수가 위에 선언된 동일이름의 변수를 가린 것
                System.out.println(baseNumber);  // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) { // 여기서 baseNumber는 위에 선언된 baseNumber참조 안함.
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };
        printInt.accept(10);
    }
}
