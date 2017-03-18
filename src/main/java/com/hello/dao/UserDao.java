package com.hello.dao;

import java.util.List;

import com.hello.model.User;

public interface UserDao {

	public void create(User user);

	public List<User> getAll();
}
