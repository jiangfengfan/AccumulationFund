package com.aaa.controller;

import com.aaa.service.NewsService;
import com.aaa.util.FileUtil;
import com.aaa.service.NewsService;
import com.aaa.util.FileUtil;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * className:NewsController
 * discription:
 * author:zz
 * createTime:2018-11-22 09:48
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;



    /**
     * 新闻列表
     * @return
     */
    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("newsList",newsService.getList());
        return "/example/list";
    }

    /**
     * 测试test
     */

    @RequestMapping("test")
    public String test(Model model){
        model.addAttribute("name","黑马程序员");
        return "test";
    }

    /**
     * 测试添加
     * @return
     */
    @RequestMapping("add")
    public String add(){
        return "/example/add";
    }
    /**
     * 测试更新
     * @return
     */
    @RequestMapping("update")
    public String update(){
        return "/example/update";
    }
    /**
     * 测试登录
     */
    @RequestMapping("toLogin")
    public String login(){
        return "login";
    }
    /**
     * 未授权提示页面
     */
    @RequestMapping("unAuth")
    public String unAuth(){
        return "unAuth";
    }
    /**
     * 登录逻辑处理
     */
    @RequestMapping("login")
    public String Login(String name,String password,Model model){
        System.out.println("name="+name);
        /**
         * 使用shiro编写认证操作
         */
        //1. 获取subject
        Subject subject = SecurityUtils.getSubject();
       // 2. 封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        //3. 执行登录方法
        try {
            subject.login(token);
            //登录成功
            //跳转到test.html
            return "forward:test";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
