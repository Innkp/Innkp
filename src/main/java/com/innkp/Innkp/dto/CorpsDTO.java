package com.innkp.Innkp.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author yangxue9
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorpsDTO extends BaseDTO {

	public Long id;
	public String name;
	public String captain;
	public String label;
	public String details;
	public Integer num;
	public Date createdDate;
}
