package com.lsl.controller;

import com.lsl.service.LoginService;
import com.lsl.utils.CookieUtils;
import com.lsl.utils.EasyUIDataGridResult;
import com.lsl.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public EasyUIDataGridResult login(String username, String password,
                                      HttpServletRequest request, HttpServletResponse response){
        Message result = loginService.userLogin(username, password);

        if (result.getData()!=null) {
            String token = result.getData().toString();
            CookieUtils.setCookie(request,response,"TOKEN",token);
        }
        return result.getResult();
    }

    @RequestMapping("/")
    public String index(){
        return "loginindex";
    }

}
