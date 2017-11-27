package com.innkp.Innkp.dao;

import org.springframework.data.repository.CrudRepository;

import com.innkp.Innkp.entity.CorpsDo;

public interface CorpsDao extends CrudRepository<CorpsDo, Long> {
	CorpsDo readByName(String name);

	CorpsDo findByNameLike(String name);

	CorpsDo findByName(String name);

	CorpsDo findOne(Long id);

}
