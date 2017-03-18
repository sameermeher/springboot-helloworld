package com.hello.service;

import java.util.List;

import com.hello.model.User;

public interface UserService {

	public void create(User user);

	public List<User> getAll();
}
