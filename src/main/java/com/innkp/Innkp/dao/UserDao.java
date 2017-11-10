package com.innkp.Innkp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.innkp.Innkp.entity.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserDao extends CrudRepository<User, Long> {

	User findByLoginNameLike(String name);

	User readByLoginName(String name);

	List<User> getByCreatedateLessThan(Date star);
}
