package com.courseapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.dao.ICourseDao;
import com.courseapp.model.Course;


/**
 * @author JagannathSutar 
 * This class methods are call the CourseDao class
 * methods and handle exception if there
 */
@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private ICourseDao courseDao;

	@Override
	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}

	@Override
	public Course getById(int courseId) {

			return courseDao.findById(courseId);
	}

	@Override
	public int updateCourse(int courseId, double courseFee) {
		return courseDao.updateCourse(courseId, courseFee);
	}

	@Override
	public int deleteCourse(int courseId) {
		return courseDao.deleteCourse(courseId);
	}

	@Override
	public List<Course> getAllCourse() {
		
		return courseDao.findAllCourse();
	}

	@Override
	public List<Course> getByCategory(String category) {
		return courseDao.findByCategory(category);
	}

	@Override
	public List<Course> getByCategoryAndLessFee(String category, double courseFees) {
		return courseDao.findByCategoryAndLessFee(category, courseFees);
	}

	@Override
	public List<Course> getByCategoryAndFaculty(String category, String facultyName) {
		return courseDao.findByCategoryAndFaculty(category, facultyName);
	}

	@Override
	public List<Course> getByNameContaining(String name) {
		return courseDao.findByNameContaining(name);
	}

	@Override
	public List<Course> getByNameAndFaculty(String name, String faculty) {
		// TODO Auto-generated method stub
		return courseDao.findByCategoryAndFaculty(name, faculty);
	}

}
