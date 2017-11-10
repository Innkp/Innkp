package com.innkp.Innkp.service;

import com.innkp.Innkp.entity.User;

public interface UserService {
	
	public User readByLoginName(String name);
}
