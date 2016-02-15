package org.j45.nursery;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Predicates {

    public static void main(String[] args) {
        System.out.println("Testing predicates");
        Predicates.UnitTest ut1 = new Predicates.UnitTest(1, "Basic scenario", new String[]{"test_PositiveSearch_RT_trip", "test_PositiveScenario_Open_Jaw"});
        Predicates.UnitTest ut2 = new Predicates.UnitTest(2, "Failure scenario", new String[]{});
        Predicates.UnitTest ut3 = new Predicates.UnitTest(3, "Custom scenario", new String[]{"test_OK", "test_NOK"});

        Predicates.UnitTest[] arr = {ut1, ut2, ut3};
        List<Predicates.UnitTest> unitTests = Arrays.asList(arr);

        List<Predicates.UnitTest> emptyTests = getEmptyTests(unitTests, isEmptyTest());
        System.out.println("Empty tests size:  " + emptyTests.size());
        System.out.println("Empty tests: " + emptyTests.get(0));
    }

    public static class UnitTest {
        private Integer id;
        private String description;
        private String[] testMethods;

        public UnitTest(Integer id, String description, String[] methods) {
            this.id = id;
            this.description = description;
            this.testMethods = methods;
        }

        public String[] getTestMethods() {
            return testMethods;
        }

        public String toString() {
            return "Unit Test: " + id + ", description: " + description;
        }
    }

    public static Predicate<UnitTest> isEmptyTest() {
        return p -> p.getTestMethods().length == 0;
    }

    public static List<Predicates.UnitTest> getEmptyTests(List<Predicates.UnitTest> inputTests, Predicate<UnitTest> utPredicate) {
        Stream<Predicates.UnitTest> testsStream = inputTests.stream();
        testsStream = testsStream.filter(utPredicate);
        return testsStream.collect(Collectors.<Predicates.UnitTest>toList());
    }

}