package com.hello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hello.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(User user) {
		String sql = "INSERT INTO users " + "(id, username) VALUES (seq_users_id.nextval, ?)";

		jdbcTemplate.update(sql, new Object[] { user.getUsername() });
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM users";

		return jdbcTemplate.query(sql,
				(resultSet, rowNum) -> new User(resultSet.getLong("ID"), resultSet.getString("USERNAME")));
	}
}
