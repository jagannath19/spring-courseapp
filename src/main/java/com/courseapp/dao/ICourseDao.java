package com.courseapp.dao;

import java.util.List;

import com.courseapp.model.Course;

/**
 * @author JagannathSutar
 */
public interface ICourseDao {
	
	
	
	
	void addCourse(Course course);
	Course findById(int courseId);
	int updateCourse(int courseId,double courseFee);
	int deleteCourse(int courseId);
	List<Course> findAllCourse();
	
	
	List<Course> findByCategory(String category);
	
	List<Course> findByCategoryAndLessFee(String category,double courseFees);
	List<Course> findByCategoryAndFaculty(String category,String facultyName);
	List<Course> findByNameContaining(String name);
	List<Course> findByNameAndFaculty(String name,String faculty);
	
	
	

}
