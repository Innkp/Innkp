package com.innkp.Innkp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innkp.Innkp.dao.UserDao;
import com.innkp.Innkp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User readByLoginName(String name) {
		return userDao.readByLoginName(name);
	}

}
