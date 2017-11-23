package com.innkp.Innkp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author yangxue9
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideosDTO extends BaseDTO {
	public List<VideoDTO> videos;
}
