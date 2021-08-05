package me.whiteship.java;

import me.whiteship.java.optional.Progress;
import me.whiteship.java.stream.OnlineClass;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        List<String> name = new ArrayList<>();
//        name.add("jiwon");
//        name.add("erica");
//        name.add("lina");
//        name.add("lucy");
//        name.add("lucy2");
//        // foreach
//        name.forEach( m -> {
//            System.out.println(m);
//        });
//        name.forEach(System.out::println);

        /**
         * 자바 8 API의 기본 메소드와 스태틱 메소드
         */
        // spliterator
//        Spliterator<String> spliterator = name.spliterator();
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println("=====");
//        while (spliterator1.tryAdvance(System.out::println));
//
//        // stream()
//        List<String> result = name.stream().map(String::toUpperCase)
//                .filter(m -> m.startsWith("L"))
//                .collect(Collectors.toList());
//        System.out.println("c = " + result);
//
//        // comparator()
//        System.out.println("==comparator()==");
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        name.sort(compareToIgnoreCase.reversed());  // reverse()추가하면 역순으로 sort
//        name.forEach(System.out::println);
//
//        // removeIf()
//        System.out.println("==removeIf()==");
//        name.removeIf(m -> m.startsWith("l"));
//        name.forEach(System.out::println);
//        System.out.println("");

        /**
         * Stream
         */
//        List<String> streamEx = new ArrayList<>();
//        streamEx.add("lina");
//        streamEx.add("erica");
//        streamEx.add("jiwon");
//        streamEx.add("yuki");
//
//        // 중계 Operator 예시 (ex. stream())
//        Stream<String> stringStream = streamEx.stream().map(m -> {
//            System.out.println("m = " + m);
//            return m.toUpperCase();
//        });
//
//        // 종료 Operator 예시 (ex. collect())
//        List<String> collect = streamEx.stream().map(s -> {
//            System.out.println("s = " + s);
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
//        collect.forEach(System.out::println);

        /**
         * Stream API 각종 예시
         */
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("--spring으로 시작하는 수업--");
        springClasses.stream()
                .filter(m -> m.getTitle().startsWith("spring"))
                .forEach(m -> System.out.println(m.getTitle()));

        System.out.println("--close 되지 않은 수업--");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))  // .filter(m -> !m.isClosed())
                .forEach(m -> System.out.println(m.getTitle()));

        System.out.println("--수업 이름만 모아서 스트림 만들기--");
        springClasses.stream()
                .map(OnlineClass::getTitle)
               // .map(m -> m.getTitle())
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> linaEvents = new ArrayList<>();
        linaEvents.add(springClasses);
        linaEvents.add(javaClasses);

        System.out.println("--두 수업 목록에 들어있는 모든 수업 아이디 출력--");
        linaEvents.stream()
                .flatMap(Collection::stream)
                .forEach(m -> System.out.println(m.getId()));

        System.out.println("--10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만 출력--");
        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("--자바 수업 중에 Test가 들어있는 수업이 있는지 여부 확인--");
        boolean test = javaClasses.stream()
                .anyMatch(m -> m.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("-- 스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기 --");
        List<String> result = springClasses.stream()
                .filter(m -> m.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        List<String> result2 = springClasses.stream()  // 위에것돠 filter, map 순서만 바꾼 동일 결과 코드
                .map(OnlineClass::getTitle)
                .filter(s -> s.contains("spring"))
                .collect(Collectors.toList());
        result2.forEach(System.out::println);

        /**
         * Optional
         */
        System.out.println("==Optional 예시==");
        List<OnlineClass> optionalClasses = new ArrayList<>();
        optionalClasses.add(new OnlineClass(1, "spring boot", true));
        optionalClasses.add(new OnlineClass(5, "rest api development", true));

        Optional<OnlineClass> optional = optionalClasses.stream()
                .filter(m -> m.getTitle().startsWith("spring"))
                .findFirst();

        System.out.println(optional.isPresent());
        optional.ifPresent(onlineClass -> System.out.println(onlineClass.getTitle()));

        OnlineClass orElseResult = optional.orElse(createNewClass());  // 있으면 반환 및 createNewClass(), 없으면 createNewClass()
        System.out.println("orElseResult = " + orElseResult.getTitle());

        OnlineClass orElseGetResult = optional.orElseGet(App::createNewClass);  //있으면 반환 없으면 createNewClass()
        System.out.println("orElseGetResult = " + orElseGetResult.getTitle());

        OnlineClass orElseThrowResult = optional.orElseThrow();  // 있으면 반환 없으면 NoSuchElementException()
        OnlineClass orElseThrowResult2 = optional.orElseThrow(IllegalStateException::new);
        System.out.println("orElseThrowResult = " + orElseThrowResult.getTitle());
        System.out.println("orElseThrowResult2 = " + orElseThrowResult2.getTitle());

        Optional<OnlineClass> optionalFilter = optional.filter(Predicate.not(OnlineClass::isClosed));
        System.out.println(optionalFilter.isEmpty());

        Optional<Integer> optionalMap = optional.map(OnlineClass::getId);
        System.out.println(optionalMap.isPresent());

        // 가져오려믄 타입이 Optional -> Optional<Optional<Progress>> 이런식으로 나와 복잡해짐
        Optional<Optional<Progress>> badOptionalType = optional.map(OnlineClass::getProgress);
        Optional<Progress> badOptionalTypeR = badOptionalType.orElse(Optional.empty());

        // 위 방법에 대한 개선 방법 (flatMap 사용 !)
        Optional<Progress> goodOptionalType = optional.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
