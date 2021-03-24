package com.epam.web.service;

import com.epam.web.entities.User;
import com.epam.web.exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

public class UserDao {

    private static final String DB_PARAM_USER = "user";
    private static final String DB_PARAM_PASSWORD = "password";
    private static final String DB_PARAM_RECONNECT = "autoReconnect";
    private static final String DB_PARAM_ENCODING = "characterEncoding";
    private static final String DB_PARAM_UNICODE = "useUnicode";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/music_wizard";
    private static final String TRUE = "true";
    private static final String UTF_8 = "UTF-8";

    private static final String SQL_QUERY_FIND_USER = "SELECT id, name FROM USER WHERE EMAIL = ? AND PASSWORD  = ?";


    public Optional<User> findUserByEmailAndPassword(String email, String password) throws DaoException, SQLException {
        Properties properties = new Properties();
        properties.put(DB_PARAM_USER, USERNAME);
        properties.put(DB_PARAM_PASSWORD, PASSWORD);
        properties.put(DB_PARAM_RECONNECT, TRUE);
        properties.put(DB_PARAM_ENCODING, UTF_8);
        properties.put(DB_PARAM_UNICODE, TRUE);

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        try {
            Connection connection = DriverManager.getConnection(URL, properties);

            try (PreparedStatement statement = connection.prepareStatement(SQL_QUERY_FIND_USER)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    statement.setString(1, email);
                    statement.setString(2, password);

                    if (resultSet.next()) {
                        return Optional.of(new User(resultSet.getLong("id"), resultSet.getString("name")));
                    }
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }
}
