package com.rain.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/17 23:19
 */
@Controller
public class TestController {
    @RequestMapping("/yl")
    public String testtoiao(){

        return "admin/tgls/goodsManage/goods_list";
    }
    @RequestMapping("/yls")
    
    public String testtiao(HttpServletRequest request){
        String pp = request.getParameter("pp");
        System.out.println(pp);

        return pp;
    }
}
