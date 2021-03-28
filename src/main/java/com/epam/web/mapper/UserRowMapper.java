package com.epam.web.mapper;

import com.epam.web.entities.Role;
import com.epam.web.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    private static final Logger LOGGER = LogManager.getLogger(UserRowMapper.class);

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(User.ID);
        String login = resultSet.getString(User.LOGIN);
        String password = resultSet.getString(User.PASSWORD);
        String name = resultSet.getString(User.NAME);
        String lastname = resultSet.getString(User.LASTNAME);
        String role = resultSet.getString(User.ROLE);
        LOGGER.debug("map -- resultSet.next() ---- " + resultSet.next());
        return new User(id, login, password, name, lastname, Role.valueOf(role));
    }
}
