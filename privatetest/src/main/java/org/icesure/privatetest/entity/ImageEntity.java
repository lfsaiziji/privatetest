package org.icesure.privatetest.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ImageEntity {

	private int id;
	private String path;
	private String thumPath;
	private int fileSize;
	private int statue;
	private Timestamp createTime;
	private String fileName;
	
}
