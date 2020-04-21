package com.rain.controller;

import com.rain.mapper.GoodsMapper;
import com.rain.mapper.ShopUserMapper;
import com.rain.mapper.SuperAndGoodsMapper;
import com.rain.mapper.UserMapper;
import com.rain.pojo.*;
import com.rain.util.GetDistanceByLatAndLng;
import com.rain.util.GetLatAndLngByBaidu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/22 1:33
 */
@Controller
public class CustomerController {
    @Autowired
    private SuperAndGoodsMapper superAndGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopUserMapper superUser;

    /**
     *
     * @param session
     * @param model
     * @return book请求页面
     * @throws IOException
     */
    @RequestMapping("/book")
    public String book(HttpSession session, Model model) throws IOException {
        //获取登录用户名
        String loginmsg = (String) session.getAttribute("loginmsg");
        //根据登录名查询地址
        String address1 = userMapper.queryAddress(loginmsg).getAddress();
        System.out.println("标记---用户地址+++"+address1);

//        创建集合返回前端
        List<All> arrayList = new ArrayList();
//        遍历查询超市名和条形码编号
        for (SuperAngGoods superAngGoods : superAndGoodsMapper.queryGoodsAndSupernameList()) {
//
            String superName = superAngGoods.getSuper_name();
            String categoryId = superAngGoods.getCategory_id();
            String address2 = superUser.queryAddress(superName).getAddress();
            System.out.println("标记---超市地址+++"+address2);
            GetDistanceByLatAndLng getDistanceByLatAndLng = new GetDistanceByLatAndLng();
            String distance = getDistanceByLatAndLng.distance(address1, address2);
            System.out.println("标记--距离" + "+++" + distance);
//            通过商品条形码查询商品
            Goods goods = goodsMapper.queryGoodsByCategory_id(categoryId);
            All all = new All();
            all.setA(goods.getName());//商品名
            all.setB(goods.getImg_url());//图片地址
            all.setD_a(goods.getPrice());//价格
            all.setC(superName);//商铺信息
            all.setD(distance);//距离
            all.setE(categoryId);//商品条形码

            arrayList.add(all);

        }
        System.out.println(arrayList.get(1).getA());
        model.addAttribute("books", arrayList);
        return "customer/list";

    }
    @RequestMapping("/add/goods/{E}")
    public String ec(@PathVariable("E") String E){
        String[] split = E.split(".");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split);
        return "success";
    }
}
