package com.innkp.Innkp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.innkp.Innkp.dao.DAOHelper;
import com.innkp.Innkp.dto.VideoDTO;
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
		return dto;
	}

}
