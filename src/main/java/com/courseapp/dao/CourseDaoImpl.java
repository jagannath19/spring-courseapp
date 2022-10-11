package com.courseapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.courseapp.model.Course;
import com.courseapp.util.CourseMapper;
import com.courseapp.util.Queries;


/**
 * @author JagannathSutar
 * @implNote implements ICourseDao
 * This class use for do all the course operation with database
 */
@Repository
public class CourseDaoImpl implements ICourseDao {

	@Autowired
	private JdbcTemplate jdbcTemplete;
	@Override
	public void addCourse(Course course) {
		Object[] courseArray= {course.getCourseName(),course.getFacultyName(),course.getMode(),course.getCategory(),course.getDurationInDays(),course.getCourseFee()};
		jdbcTemplete.update(Queries.QueryaddCourse,courseArray);
	}

	@Override
	public Course findById(int courseId) {
		Course ncourse=jdbcTemplete.queryForObject(Queries.QueryCourseById, (rs,rowNum)->{
		Course course=new Course();
		course.setCourseName(rs.getString("courseName"));
		course.setCourseId(rs.getInt("courseId"));
		course.setFacultyName(rs.getString("facultyName"));
		course.setMode(rs.getString("mode"));
		course.setCategory(rs.getString("category"));
		course.setDurationInDays(rs.getInt("durationInDays"));
		course.setCourseFee(rs.getDouble("courseFee"));
	return course;
		},courseId);
		return ncourse;
	}

	@Override
	public int updateCourse(int courseId, double courseFee) {
		int result=jdbcTemplete.update(Queries.QueryUpdate,courseFee,courseId);
		return result;
	}

	@Override
	public int deleteCourse(int courseId) {
		int result=jdbcTemplete.update(Queries.QueryDelete, courseId);
		return result;
	}

	@Override
	public List<Course> findAllCourse() {
		List<Course> courses=jdbcTemplete.query(Queries.QueryAllCourses, new CourseMapper());
		return courses;
	}

	@Override
	public List<Course> findByCategory(String category) {
		List<Course> courses=jdbcTemplete.query(Queries.QueryCourseByCategory,new CourseMapper(),category);
		return courses;
	}

	@Override
	public List<Course> findByCategoryAndLessFee(String category, double courseFees) {
		List<Course> courses=jdbcTemplete.query(Queries.QueryCourseByCategoryAndFee,new CourseMapper(),category,courseFees);
		return courses;
	}

	@Override
	public List<Course> findByCategoryAndFaculty(String category, String facultyName) {
		List<Course> courses=jdbcTemplete.query(Queries.QueryCourseByCategoryAndFaculty,new CourseMapper(),category,facultyName);
		return courses;
	}

	@Override
	public List<Course> findByNameContaining(String name) {
		List<Course> courses=jdbcTemplete.query(Queries.QueryCourseByCourseName,new CourseMapper(),name);
		return courses;
	}

	@Override
	public List<Course> findByNameAndFaculty(String name, String faculty) {
		List<Course> courses=jdbcTemplete.query(Queries.QueryCourseByCourseNameAndFaculty,new CourseMapper(),name,faculty);
		return courses;
	}
	
	
	
}
