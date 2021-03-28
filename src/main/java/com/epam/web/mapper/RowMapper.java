package com.epam.web.mapper;

import com.epam.web.entities.Entity;
import com.epam.web.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper <T extends Entity> {

    T map (ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Entity> create(String table) {
        switch (table){
            case User.TABLE: return new UserRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table => " + table);
        }
    }

}
