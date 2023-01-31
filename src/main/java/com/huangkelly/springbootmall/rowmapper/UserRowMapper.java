package com.huangkelly.springbootmall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.huangkelly.springbootmall.model.User;

//將資料庫的結果去轉換成一個User Object
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet,int i) throws SQLException {
		User user = new User();
		user.setUserId(resultSet.getInt("user_id"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		user.setCreateDate(resultSet.getTimestamp("created_date"));
		user.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
		
		return user;
		
	}
}
