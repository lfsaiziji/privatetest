package org.icesure.privatetest.Dao;

import java.sql.ResultSet;

import org.icesure.privatetest.entity.ImageEntity;

public interface MysqlDao {

	public int imageAdd(ImageEntity imageEntity);
	public ResultSet imageQueryForShow();
	public int imageDel(int id);
	public void close();
	public void init();
}
