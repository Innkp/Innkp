package com.innkp.Innkp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innkp.Innkp.dao.VideoDao;
import com.innkp.Innkp.dto.VideoDTO;
import com.innkp.Innkp.dto.VideosDTO;
import com.innkp.Innkp.entity.VideoDo;

/**
 *
 * @author yangxue9
 */
@Service
public class VideoService {
	@Autowired
	private DTOHelper dtoHelper;
	@Autowired
	private VideoDao videoDao;

	public VideoDTO getVideoByName(String name) {
		VideoDo videoDo = videoDao.findByName(name);

		if (videoDo != null) {
			System.out.println(videoDo.toString());
			return dtoHelper.buildVideoDTO(videoDo);
		} else {
			System.out.println("videoDo==null");
			return null;
		}
	}

	public VideoDTO getVideoById(Long id) {
		VideoDo videoDo = videoDao.findOne(id);

		if (videoDo != null) {
			System.out.println(videoDo.toString());
			return dtoHelper.buildVideoDTO(videoDo);
		} else {
			System.out.println("videoDo==null");
			return null;
		}
	}

	public VideosDTO getVideos() {
		VideosDTO dto = new VideosDTO();
		List<VideoDTO> videos = new ArrayList<VideoDTO>();
		Iterable<VideoDo> videosIt = videoDao.findAll();

		videosIt.forEach(single -> {
			videos.add(dtoHelper.buildVideoDTO(single));
		});
		dto.videos = videos;
		return dto;
	}

	public void initVideos() {
		videoDao.deleteAll();
		List<VideoDo> videos = new ArrayList<VideoDo>();
		VideoDo v1 = new VideoDo();
		v1.setCover("111");
		v1.setName("111");
		v1.setUrl("111");
		v1.setCreatedDate(new Date());
		videos.add(v1);
		VideoDo v2 = new VideoDo();
		v2.setCover("222");
		v2.setName("222");
		v2.setUrl("222");
		v2.setCreatedDate(new Date());
		videos.add(v2);
		VideoDo v3 = new VideoDo();
		v3.setCover("333");
		v3.setName("333");
		v3.setUrl("333");
		v3.setCreatedDate(new Date());
		videos.add(v3);
		videoDao.save(videos);
	}
}