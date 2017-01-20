package com.example.dao;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDAO {
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

   public void createTable() {
        String SQL = "CREATE  TABLE IF NOT EXISTS `User`(" +
                "id INT(11) NOT NULL  AUTO_INCREMENT ," +
                "firstName VARCHAR(20) NOT NULL," +
                "lastName VARCHAR(20) NOT NULL," +
                "PRIMARY KEY(id) )";
        jdbcTemplateObject.execute(SQL);
    }

    public void create(String firstName, String lastName) {
        String SQL = "INSERT INTO User (firstName, lastName) VALUES (?, ?)";

        jdbcTemplateObject.update(SQL, firstName, lastName);
        System.out.println("INSERT INTO User firstName = "
                + firstName + " lastName = " + lastName);
    }

    User getUser(Integer id) {
        String SQL = "SELECT * FROM User WHERE id = ?";
        User user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new UserMapper());
        System.out.println("SELECT User with ID = " + id +
                " firstName = " + user.getFirstName()+
                " lastName = " + user.getLastName());
        return user;
    }

    public void delete(Integer id) {
        String SQL = "DELETE  FROM User WHERE id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("DELETE User with ID = " + id);
    }

   public void update(Integer id,String firstName, String lastName) {
        String SQL = "UPDATE User SET firstName = ?,lastName = ? WHERE id = ?";
        jdbcTemplateObject.update(SQL,firstName, lastName, id);
        System.out.println("UPDATE User with ID = " + id + " firstName = " + firstName + " lastName = " + lastName);
    }

    public List<User> listUsers() {
        String SQL = "SELECT * FROM User";
        return jdbcTemplateObject.query(SQL,
                new UserMapper());
    }



}