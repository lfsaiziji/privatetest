package org.icesure.privatetest.Impl;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.icesure.privatetest.Dao.MysqlDao;
import org.icesure.privatetest.Service.ImageService;
import org.icesure.privatetest.Util.ImageUtil;
import org.icesure.privatetest.entity.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

	protected final Logger logger = Logger.getLogger(ImageServiceImpl.class);
	
	// 保存文件的目录
	//private static String PATH_FOLDER = "C://Users//thinkpad//git//privatetest//privatetest//src//main//webapp//image//uploadfile//";
	private static String PATH_FOLDER = "F://up//save//";
	// 存放临时文件的目录
	private static String TEMP_FOLDER = "F://up//temp//";
	
	@Autowired
	MysqlDao mysqlDao;
	
	@Override
	public List<ImageEntity> getImageEntities()  {
		ResultSet resultSet = mysqlDao.imageQueryForShow();
		List<ImageEntity> imageEntities = new LinkedList<ImageEntity>();
		try {
			while (resultSet.next()) {
				ImageEntity imageEntity = new ImageEntity();
				imageEntity.setId(resultSet.getInt("id"));
				imageEntity.setThumPath(resultSet.getString("thumpath"));
				imageEntity.setFileSize(resultSet.getInt("filesize"));
				imageEntity.setCreateTime(resultSet.getTimestamp("creattime"));
				imageEntity.setFileName(resultSet.getString("filename"));
				imageEntities.add(imageEntity);
			}
			mysqlDao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return imageEntities;
	}

	@Override
	public ImageEntity saveFile(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(TEMP_FOLDER));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);	
		ImageEntity imageEntity = new ImageEntity();
		try {
			List<FileItem> list = upload.parseRequest(request);
			// 获取上传的文件
			for(FileItem item : list){
				// 获取文件名
				String filename = getUploadFileName(item);
				// 保存后的文件名
				String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
				// 保存后图片的浏览器访问路径
				//String picUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/image/uploadfile/"+saveName;
				String picUrl = PATH_FOLDER+saveName;
				// 真正写到磁盘上
				item.write(new File(PATH_FOLDER, saveName)); 
				imageEntity.setFileName(filename);
				imageEntity.setPath(picUrl);
				Long size = item.getSize();
				imageEntity.setFileSize(new Long(size/1024).intValue());
			}
		} catch (FileUploadException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}	
		return imageEntity;
	}
	
    private String getUploadFileName(FileItem item) {
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);		
		return filename;
	}

	@Override
	public String makethumbnail(String path) {
		// TODO Auto-generated method stub
		return "../image/uploadfile/" + ImageUtil.thumbnailImage(path, 200, 200);
	}

	@Override
	public int saveMysql(ImageEntity imageEntity) {
		// TODO Auto-generated method stub
		return mysqlDao.imageAdd(imageEntity);
	}

}
