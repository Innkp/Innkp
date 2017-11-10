package com.innkp.Innkp.dao;

import org.springframework.data.repository.CrudRepository;

import com.innkp.Innkp.entity.Video;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VideoDao extends CrudRepository<Video, Long> {
}
