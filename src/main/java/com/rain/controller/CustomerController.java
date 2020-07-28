package com.rain.controller;

import com.rain.mapper.*;
import com.rain.pojo.*;
import com.rain.util.GetDistanceByLatAndLng;
import com.rain.util.GetLatAndLngByBaidu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
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
    @Autowired
    private CartMapper cartMapper;

    /**
     * @param session
     * @param model
     * @return book请求页面
     * @throws IOException
     */
    @RequestMapping("/book")
    public String book(HttpSession session, Model model) throws IOException {
//        获取登录用户名
        String loginmsg = (String) session.getAttribute("loginmsg");
//        根据登录名查询地址
        String address1 = userMapper.queryAddress(loginmsg).getAddress();
        System.out.println("标记---用户地址+++" + address1);


//        创建集合返回前端
        List<ShowGoods> arrayList = new ArrayList();

//         分组查询超市名
        for (SuperAngGoods superAngGoods : superAndGoodsMapper.queryGroupSuper_Name()) {
            String superName = superAngGoods.getSuper_name();
//            由超市名查询超市地址获取距离
            String address2 = superUser.queryAddress(superName).getAddress();
            System.out.println("标记---超市地址+++" + address2);
            GetDistanceByLatAndLng getDistanceByLatAndLng = new GetDistanceByLatAndLng();
            String distance = getDistanceByLatAndLng.distance(address1, address2);
            System.out.println("标记--距离" + "+++" + distance);

            ShowGoods showGoods = new ShowGoods();
            showGoods.setSuper_name(superName); //商铺信息
            showGoods.setDistance(distance);//距离

//            通过商品条形码查询商品
            List<Goods> list = new ArrayList<>();
            for (SuperAngGoods s : superAndGoodsMapper.getCategory_idBysuper_name(superName)) {
                String categoryId = s.getCategory_id();
                Goods goods = goodsMapper.queryGoodsByCategory_id(categoryId);
                Goods goods1 = new Goods();
                goods1.setName(goods.getName());//商品名
                goods1.setImg_url(goods.getImg_url());//图片地址
                goods1.setPrice(goods.getPrice());//价格
                goods1.setCategory_id(goods.getCategory_id());
                list.add(goods1);
            }
            showGoods.setList(list);


            //商品条形码

            arrayList.add(showGoods);

        }
        model.addAttribute("books", arrayList);
        return "customer/list";

    }

    /**
     * 添加商品至购物车
     *
     * @param super_name
     * @param category_id
     * @param session
     * @param model
     * @return
     */
//    /add/goods/'+${book.getSuper_name()}+'/'+${book1.getCategory_id()}
    @RequestMapping("/add/goods/{super_name}/{category_id}")
    public ModelAndView ec(@PathVariable("super_name") String super_name,
                           @PathVariable("category_id") String category_id,
                           HttpSession session,
                           Model model) {
        ModelAndView mv = new ModelAndView();
        System.out.println(super_name);
        System.out.println(category_id);
        String loginmsg = (String) session.getAttribute("loginmsg");
        Cart cart = new Cart();
        cart.setSuper_name(super_name);
        cart.setCategory_id(category_id);
        cart.setUsername(loginmsg);
        int i;
        try {
            i = cartMapper.addGoods(cart);
            model.addAttribute("list", "添加成功");
            mv.setViewName("redirect:/book");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("list", "添加失败");
            return mv;
        }
    }

    @RequestMapping("/cartList")
    public String cart(Model model,
                       HttpSession session) throws IOException {
        //        获取登录用户名
        String loginmsg = (String) session.getAttribute("loginmsg");
//        根据登录名查询地址
        String address1 = userMapper.queryAddress(loginmsg).getAddress();
        System.out.println("标记---用户地址+++" + address1);


//        创建集合返回前端
        List<ShowGoods> arrayList = new ArrayList();

//         分组查询超市名
        for (Cart cart : cartMapper.queryGroupSuper_nameByusername(loginmsg)) {
            String superName = cart.getSuper_name();
//            由超市名查询超市地址获取距离
            String address2 = superUser.queryAddress(superName).getAddress();
            System.out.println("标记---超市地址+++" + address2);
            GetDistanceByLatAndLng getDistanceByLatAndLng = new GetDistanceByLatAndLng();
            String distance = getDistanceByLatAndLng.distance(address1, address2);
            System.out.println("标记--距离" + "+++" + distance);

            ShowGoods showGoods = new ShowGoods();
            showGoods.setSuper_name(superName); //商铺信息
            showGoods.setDistance(distance);//距离

//            通过商品条形码查询商品
            List<Goods> list = new ArrayList<>();
            for (Cart cart1 : cartMapper.queryCategory_idBySuper_name(superName)) {
                String categoryId = cart1.getCategory_id();
                Goods goods = goodsMapper.queryGoodsByCategory_id(categoryId);
                Goods goods1 = new Goods();
                goods1.setName(goods.getName());//商品名
                goods1.setImg_url(goods.getImg_url());//图片地址
                goods1.setPrice(goods.getPrice());//价格
                goods1.setCategory_id(goods.getCategory_id());
                list.add(goods1);
            }
            showGoods.setList(list);


            //商品条形码

            arrayList.add(showGoods);

        }
        model.addAttribute("carts", arrayList);
        return "customer/cart";
    }

}
