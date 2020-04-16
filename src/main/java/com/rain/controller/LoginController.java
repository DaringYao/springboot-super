package com.rain.controller;

import com.rain.mapper.ShopUserMapper;
import com.rain.mapper.UserMapper;
import com.rain.pojo.SuperUser;
import com.rain.pojo.User;
import com.rain.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/16 15:45
 */
@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ShopUserMapper shopUserMapper;
    @RequestMapping("/")
    public String userNameLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam("UserName") String username,
                        @RequestParam("Password") String password,
                        Model model, HttpSession session){
        for (int i = 0; i <= userService.queryUserList().size(); i++) {
            if (username.equals(userService.queryUserList().get(i).getUsername()) && password.equals(userService.queryUserList().get(i).getPassword())) {
                session.setAttribute("loginmsg",username);
                return "customer/home";
            }
            else {
                model.addAttribute("msg", "请输入正确的用户名或密码");
                return "login";
            }
        }
        return "";
    }
    @RequestMapping("/userRegister")
    /*(id,username,password,phone,email,address)*/
    public String userRegister(){
        return "register";
    }
    @RequestMapping("/register")
    /*(id,username,password,phone,email,address)*/
    public String userNameRegister(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("email") String email
                                   ){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        int i = userService.addUser(user);
        System.out.println(i);
        if (i==1){
            return "success";
        }
        return "login";
    }
    @RequestMapping("/super_lo")
    public String shopLogin(){
        return "super_login";
    }
    @RequestMapping("/super_log")
    public String shopLoginSubmit(
            @RequestParam("Username") String username,
            @RequestParam("Password") String password,
            Model m, HttpSession session){
            for (int i = 0; i <= shopUserMapper.querySuperUserList().size(); i++) {
                if (username.equals(shopUserMapper.querySuperUserList().get(i).getUserName())&&password.equals(shopUserMapper.querySuperUserList().get(i).getPassword())) {
                    session.setAttribute("superloginmsg",username);
                    return "super/index";
                }
                else {
                    m.addAttribute("supermsg", "请输入正确的用户名或密码");
                    return "super_login";
                }
            }
            return "";
        }
        @RequestMapping("/super_register")
    public String super_register(@RequestParam("Username") String username,
                                 @RequestParam("Password")String password,
                                 @RequestParam("Phone") String phone,
                                 @RequestParam("coding") String coding,
                                 @RequestParam("address") String address,
                                 @RequestParam("shop_class") String shop_class,
                                 Model model){
            SuperUser superUser = new SuperUser();
            superUser.setUserName(username);
            superUser.setPassword(password);
            superUser.setPhone(phone);
            superUser.setConding(coding);
            superUser.setAddress(address);
            superUser.setShop_class(shop_class);
            int i = shopUserMapper.addSuperUser(superUser);
            if (i==1){
                model.addAttribute("super_login_msg","注册失败，请更换用户名或营业执照编号");
                return "super_login";
            }
            return "";
        }
}
