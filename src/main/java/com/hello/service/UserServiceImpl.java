package com.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.UserDao;
import com.hello.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
	    this.userDao = userDao;
	}

	@Override
	public void create(User user) {
		userDao.create(user);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
}
