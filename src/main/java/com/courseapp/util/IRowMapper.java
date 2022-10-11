package com.courseapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.courseapp.model.Course;

/**
 * @author JagannathSutar
 *
 */
public interface IRowMapper {
	List<Course> mapRow(ResultSet resultset) throws SQLException;

}
