package com.innkp.Innkp.dao;

import org.springframework.data.repository.CrudRepository;

import com.innkp.Innkp.entity.VideoDo;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VideoDao extends CrudRepository<VideoDo, Long> {
	VideoDo readByName(String name);

	VideoDo findByNameLike(String name);

	VideoDo findByName(String name);

	VideoDo findOne(Long id);

	// @Query("select * from video where id=?")
	// VideoDo findById(int id);
}
