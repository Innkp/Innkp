package com.innkp.Innkp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author yangxue9
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDTO extends BaseDTO {

	public Long id;

	public String name;

	public String url;

	public String cover;

}
