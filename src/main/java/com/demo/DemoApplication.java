package com.demo;

import com.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		getDummyData();
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

}
