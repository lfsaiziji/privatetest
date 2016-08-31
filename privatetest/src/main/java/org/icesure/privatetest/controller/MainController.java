package org.icesure.privatetest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/login")
    public ModelAndView login() throws Exception {
        ModelAndView mv = new ModelAndView("main/login");
        return mv;
    }
    
    @RequestMapping("/loginin")
    @ResponseBody
    public ModelAndView loginin(String username,String password) throws Exception {
    	System.out.println("in");
        if(username.equals("root") && password.equals("1234")){
        	System.out.println("index");
        	return new ModelAndView("main/index");
        }
        else{
        	System.out.println("login");
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
