package com.born2code.spring.web.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeRowMapper implements RowMapper<Notice> {

    @Override
    public Notice mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setAuthority(resultSet.getString("authority"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setEnabled(true);

        Notice notice = new Notice();
        notice.setId(resultSet.getInt("id"));
        notice.setText(resultSet.getString("text"));
        notice.setUser(user);
        return notice;
    }
}
