package org.icesure.privatetest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.icesure.privatetest.entity.SessionEntity;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private HttpSession httpSession;

    @RequestMapping("/login")
    public ModelAndView login() throws Exception {
        ModelAndView mv = new ModelAndView("main/login");
        return mv;
    }
    
    @RequestMapping("/loginin")
    @ResponseBody
    public ModelAndView loginin(String username,String password,HttpServletRequest request) throws Exception {
    	SessionEntity sessionEntity = null;
    	if(username.equals("root") && password.equals("1234")){
        	httpSession = request.getSession();
        	sessionEntity = new SessionEntity();
        	sessionEntity.setId(1);
        	sessionEntity.setPetName("aa");
        	httpSession.setAttribute("sessionEntity",sessionEntity);
        	httpSession.setAttribute("test","123");
        	httpSession.setMaxInactiveInterval(300);
        	return new ModelAndView("main/index");
        }
        else{
        	return new ModelAndView("main/login");
        }

    }
    
    @RequestMapping("/index")
    public ModelAndView index() throws Exception {
        ModelAndView mv = new ModelAndView("main/index");
        System.out.println("index");
        return mv;
    }

}
