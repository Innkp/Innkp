package com.innkp.Innkp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.innkp.Innkp.dao.DAOHelper;
import com.innkp.Innkp.dto.CorpsDTO;
import com.innkp.Innkp.dto.VideoDTO;
import com.innkp.Innkp.entity.CorpsDo;
import com.innkp.Innkp.entity.VideoDo;

/**
 *
 * @author yangxue9
 */
@Component
public class DTOHelper {

	@Autowired
	private DAOHelper daoHelper;
	@Autowired
	private ServiceHelper serviceHelper;

	public VideoDTO buildVideoDTO(VideoDo f) {
		final VideoDTO dto = new VideoDTO();
		dto.id = f.getId();
		dto.name = f.getName();
		dto.url = f.getUrl();
		dto.cover = f.getCover();
		dto.createdDate = f.getCreatedDate();
		return dto;
	}

	public CorpsDTO buildCorpsDTO(CorpsDo f) {
		final CorpsDTO dto = new CorpsDTO();
		dto.id = f.getId();
		dto.name = f.getName();
		dto.label = f.getLabel();
		dto.captain = f.getCaptain();
		dto.createdDate = f.getCreatedDate();
		dto.details = f.getDetails();
		dto.num = f.getNum();
		return dto;
	}

}
