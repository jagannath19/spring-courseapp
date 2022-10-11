package com.courseapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.courseapp.model.Course;

/**
 * @author JagannathSutar
 * @implNote IRowMapper
 */
public class CourseMapper implements RowMapper<Course> {

	/**
	 * @param resultset
	 * @return list of course
	 * @throws SQLException
	 * this  method use to set the output in a resultset 
	 */
	
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course course=new Course();
			course.setCourseName(rs.getString("courseName"));
			course.setCourseId(rs.getInt("courseId"));
			course.setFacultyName(rs.getString("facultyName"));
			course.setMode(rs.getString("mode"));
			course.setCategory(rs.getString("category"));
			course.setDurationInDays(rs.getInt("durationInDays"));
			course.setCourseFee(rs.getDouble("courseFee"));
		return course;
	}

	

}
