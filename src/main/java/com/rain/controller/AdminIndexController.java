package com.rain.controller;

import com.rain.mapper.GoodsMapper;
import com.rain.mapper.ShopUserMapper;
import com.rain.mapper.UserMapper;
import com.rain.pojo.Goods;
import com.rain.pojo.SuperUser;
import com.rain.pojo.User;
import com.rain.service.impl.GoodsServiceImpl;
import com.rain.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/29 3:00
 */
@Controller
public class AdminIndexController {
    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopUserMapper shopUserMapper;
    @RequestMapping("/admin")
    public String adminIndex(){
        return "admin/index";
    }
    @RequestMapping("/goAddGoods")
    public String goAddGoods(){
        return "admin/tgls/goodsManage/goods_add";
    }

    @RequestMapping("/addGoods")
    public String addGoods(@RequestParam("name") String name,
                           @RequestParam("file")MultipartFile file,
                           @RequestParam("price") Double price,
                           @RequestParam("category_id") String category_id,
                           @RequestParam("group_class") String group_class,
                           Model model){
        System.out.println(name);
        System.out.println(file);
        System.out.println(price);
        System.out.println(category_id);
        System.out.println(group_class);
        System.out.println();
        System.out.println(file);

        UploadUtil uploadUtil = new UploadUtil();
        String fileUpload = uploadUtil.fileUpload(file);
        Goods goods = new Goods();
        goods.setName(name);
        goods.setImg_url(fileUpload);
        goods.setPrice(price);
        goods.setCategory_id(category_id);
        goods.setGroup_class(group_class);
        int i = goodsMapper.addGoods(goods);
        if (i==1){
            model.addAttribute("addgoods","商品已添加，继续添加");
            return "admin/tgls/goodsManage/goods_add";
        }else{
            model.addAttribute("addgoods","商品添加失败或商品已存在，继续添加");
            return "admin/tgls/goodsManage/goods_add";
        }
    }
    @RequestMapping("/agent_list")
    public String agent(Model model){
        List<User> user_list = userMapper.queryUserList();
        model.addAttribute("user_list",user_list);
        return "admin/tgls/base/custom_list";
    }
    @RequestMapping("/super_list")
    public String super_list(Model model){
        List<SuperUser> superUsers = shopUserMapper.querySuperUserList();
        model.addAttribute("super_list",superUsers);
        return "admin/tgls/base/super_list";
    }
    @RequestMapping("/good_list")
    public String good_list(Model model){
        List<Goods> queryGoodsList = goodsMapper.queryGoodsList();
        model.addAttribute("good_list",queryGoodsList);
        for (Goods goods:queryGoodsList) {
            System.out.println(goods.getImg_url());
        }
        return "admin/tgls/goodsManage/goods_list";
    }

}
