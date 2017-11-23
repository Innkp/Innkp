package com.innkp.Innkp.entity;

import java.util.Date;

/**
 * 
 * @author yangxue9
 *
 */

public interface DBObject {

	Long getId();

	void setCreatedDate(Date createdDate);

	Date getCreatedDate();
}
