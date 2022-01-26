package com.demo.services;

import com.demo.patterns.classes.Employee;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeService {

    public static void sorting() {
        Employee employee = new Employee("Arjun", 1);
        Employee employee2 = new Employee("Rakesh", 2);
        Employee employee3 = new Employee("Rakesh", 9);
        Employee employee4 = new Employee("Piyush", 5);
        Employee employee5 = new Employee("Karan", 3);

        List<Employee> emps = List.of(employee, employee2, employee3, employee4, employee5);
        System.out.println(emps.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId))
                .collect(Collectors.toList()));

        HashMap<String, Integer> map = new HashMap();
        map.put("a", 2);
        map.put("z", 1);
        map.put("k", 3);

        /** Sorted hashmap */
        Map<String , Integer> newMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        /** Grouping */
        Map<String, Long> s = emps.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        Collections.sort(emps, new CustomComparator());
    }

    static class CustomComparator implements Comparator<Employee>
    {
        @Override
        public int compare(Employee e1, Employee e2)
        {
            return e1.getName().compareTo(e2.getName());
        }
    }

    public static void getDummyData() {
        List<String> data = List.of("Spring", "Demo", "More items");
        List<String> items = data.stream().filter(i -> i.length() > 4).map(x -> x + " " + x).collect(Collectors.toList());

        List<Integer> numbers = List.of(0, 1, 2, 9, 10, 12, 5 , 7, 8);
        System.out.println( numbers.stream().reduce(0, Integer::sum) );
        System.out.println( numbers.stream().reduce(Integer.MAX_VALUE, Integer::min) );
        System.out.println( numbers.stream().distinct().sorted(Comparator.comparing(str -> str*3)).collect(Collectors.groupingBy(
                Integer::valueOf, Collectors.counting()
        )) );
    }

    public static void structures() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "");
        System.out.println(map.size());

        int[] a= new int[]{3, 6, 8, 9};
        System.out.println(Arrays.stream(a).sum());

        ArrayList<Integer> list = new ArrayList<>(List.of(3, 2, 1, 4, 6, 7, 0, 100, 5));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));;
    }

}
