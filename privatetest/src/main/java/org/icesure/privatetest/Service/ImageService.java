package org.icesure.privatetest.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.icesure.privatetest.entity.ImageEntity;

public interface ImageService {

	public List<ImageEntity> getImageEntities();
	public ImageEntity saveFile(HttpServletRequest request);
	public String makethumbnail(String path);
	public int saveMysql(ImageEntity imageEntity);
	
}
