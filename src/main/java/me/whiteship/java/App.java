package me.whiteship.java;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        /**
         * Functional Interfadce
         */
//        UnaryOperator<String> lamdaEx = (s) -> "hi " + s;  // 람다
//        UnaryOperator<String> methodRef = Greeting::hi; // 1. 스태틱 메소드 참조 (타입::스태틱메소드)
//
//        Greeting greeting = new Greeting();
//        UnaryOperator<String> instanceRef = greeting::hello;  // 2. 특정 객체의 인스턴스 메소드 참조 (객체레퍼런스::인스턴스메소드)
//        System.out.println(instanceRef.apply("jiwon"));
//
//        String[] names = {"watermelon", "banana", "apple"};
//       // Arrays.sort(names, (o1, o2) -> 0);  // 람다
//        Arrays.sort(names, String::compareToIgnoreCase);  // 3. 임의 객체의 인스턴스 메소드 참조 (타입::인스턴스 메소드)
//        System.out.println(Arrays.toString(names));  // apple, banana, watermelon
//
//        // 타입을 봐야 디폴트 생성자/사용자정의 생성자를 참조하는지 알 수 있다
//        Supplier<Greeting> newGreeting = Greeting::new;  // 4-1. 생성자 참조 (타입::new)
//        Greeting result = newGreeting.get();
//
//        Function<String, Greeting> jiwonGreeting = Greeting::new; // 4-2. 생성자 참조
//        Greeting lina = jiwonGreeting.apply("lina");
//        System.out.println(lina.getName());

        List<String> name = new ArrayList<>();
        name.add("jiwon");
        name.add("erica");
        name.add("lina");
        name.add("lucy");
        name.add("lucy2");
        // foreach
        name.forEach( m -> {
            System.out.println(m);
        });
        name.forEach(System.out::println);

        /**
         * 자바 8 API의 기본 메소드와 스태틱 메소드
         */
        // spliterator
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=====");
        while (spliterator1.tryAdvance(System.out::println));

        // stream()
        List<String> result = name.stream().map(String::toUpperCase)
                .filter(m -> m.startsWith("L"))
                .collect(Collectors.toList());
        System.out.println("c = " + result);

        // comparator()
        System.out.println("==comparator()==");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());  // reverse()추가하면 역순으로 sort
        name.forEach(System.out::println);

        // removeIf()
        System.out.println("==removeIf()==");
        name.removeIf(m -> m.startsWith("l"));
        name.forEach(System.out::println);
        System.out.println("");
    }
}
