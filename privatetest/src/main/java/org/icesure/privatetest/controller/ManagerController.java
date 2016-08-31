package org.icesure.privatetest.controller;

import java.awt.Image;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.icesure.privatetest.Dao.MysqlDaoJdbc;
import org.icesure.privatetest.Service.ImageService;
import org.icesure.privatetest.entity.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagerController {

	@Autowired
	ImageService imageService;
	
    @RequestMapping("/image")
    public ModelAndView login() throws Exception {
        ModelAndView mv = new ModelAndView("manage/image");
        List<ImageEntity> list = imageService.getImageEntities();
        mv.addObject("imagelist", list);
        return mv;
    }
    
    @RequestMapping("/upload")
    public ModelAndView upload() throws Exception {
        ModelAndView mv = new ModelAndView("manage/upload");
        return mv;
    }
    
    @RequestMapping("/uploadfile")
    @ResponseBody
    public Map<String, String> uploadfile(HttpServletRequest request) throws Exception {
    	Map<String, String> map = new HashMap<String, String>();       
        request.setCharacterEncoding("utf-8"); // 设置编码
		ImageEntity imageEntity = imageService.saveFile(request);
		if(imageEntity.getPath() != null && imageEntity.getPath() != ""){
			imageEntity.setThumPath(imageService.makethumbnail(imageEntity.getPath()));
		}
		imageService.saveMysql(imageEntity);
		map.put("msg", "success");
		map.put("thumpath", imageEntity.getThumPath());
        return map;
    }
  
}
