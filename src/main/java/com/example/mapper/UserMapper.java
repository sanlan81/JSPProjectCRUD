package com.example.mapper;

import com.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
       User user = new User();
       user.setId(rs.getInt("id"));
       user.setFirstName(rs.getString("firstName"));
       user.setLastName(rs.getString("lastName"));
       return user;
   }
}
