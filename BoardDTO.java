package com.del.test_project_1.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int index;
	private String id;
	private String title;
	private String contents; 
	private Date  date;
}
