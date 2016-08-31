package org.icesure.privatetest.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.icesure.privatetest.entity.ImageEntity;
import org.icesure.privatetest.entity.MysqlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

@Repository
public class MysqlDaoJdbc implements MysqlDao {

	private BoneCP connectionPool = null;
	private Connection conn = null;
	private Statement stmt = null;

	private static int initflag = 0;

	@Autowired
	private MysqlEntity mysqlEntity;

	@Override
	public void close() {
		try {
			if (stmt != null) {
				this.stmt.close();
			}
			if (conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet imageQueryForShow() {
		// TODO Auto-generated method stub
		init();
		String sql = "select id,thumpath,filesize,creattime,filename from image where status = 0";
		ResultSet resultSet = null;
		try {
			// 从数据库连接池获取一个数据库连接
			conn = connectionPool.getConnection(); // fetch a connection
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		if (initflag == 0) {
			getConnection();
			initflag = 1;
		}
	}

	private void getConnection() {
		String url = mysqlEntity.getUrl();
		try {
			Class.forName(mysqlEntity.getDriver());// 动态加载mysql驱动
			// 设置连接池配置信息
			BoneCPConfig config = new BoneCPConfig();
			// 数据库的JDBC URL
			config.setJdbcUrl(url);
			// 数据库用户名
			config.setUsername(mysqlEntity.getUsername());
			// 数据库用户密码
			config.setPassword(mysqlEntity.getPassword());
			// 数据库连接池的最小连接数
			config.setMinConnectionsPerPartition(5);
			// 数据库连接池的最大连接数
			config.setMaxConnectionsPerPartition(10);
			//
			config.setPartitionCount(1);
			// 设置数据库连接池
			connectionPool = new BoneCP(config);
		} catch (Exception e) {
			// logger.warn(e.getMessage());
		}
	}

	@Override
	public int imageAdd(ImageEntity imageEntity) {
		init();
		String sql = "insert into image (path,filename,thumpath,filesize) values "
				+ "('" + imageEntity.getPath() + "','" + imageEntity.getFileName() + "','"
				+ imageEntity.getThumPath() + "','" + imageEntity.getFileSize()
				+ "')";
		//System.out.println(sql);
		int resultSet = -1;
		try {
			// 从数据库连接池获取一个数据库连接
			conn = connectionPool.getConnection(); // fetch a connection
			stmt = conn.createStatement();
			resultSet = stmt.executeUpdate(sql);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int imageDel(int id) {
		// TODO Auto-generated method stub
		init();
		String sql = "update image status = 1 where id = " + id;
		int resultSet = -1; 
		try {
			// 从数据库连接池获取一个数据库连接
			conn = connectionPool.getConnection(); // fetch a connection
			stmt = conn.createStatement();
			resultSet = stmt.executeUpdate(sql);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
