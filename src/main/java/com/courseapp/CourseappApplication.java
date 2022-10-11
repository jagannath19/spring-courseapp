package com.courseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.courseapp.service.ICourseService;

@SpringBootApplication
public class CourseappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseappApplication.class, args);
	}
	
	@Autowired
	private ICourseService courseService;
	
	@Override
	public void run(String... args) throws Exception {
//		courseService.addCourse(new Course("Spring", "sripriya", "ONLINE", "software", 15, 1500));
		System.out.println("----------");
		System.out.println(courseService.getById(1));
		courseService.updateCourse(1, 1258);
//		courseService.deleteCourse(7);
		courseService.getAllCourse().forEach(System.out::println);
		System.out.println("-------------");
		courseService.getByCategory("DEVELOPER").forEach(System.out::println);
		System.out.println("-------------");
		courseService.getByCategoryAndFaculty("DEVELOPER", "madhu").forEach(System.out::println);
		
	}

}
