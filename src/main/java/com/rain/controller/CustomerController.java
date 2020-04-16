package com.rain.controller;

import com.rain.mapper.GoodsMapper;
import com.rain.mapper.SuperAndGoodsMapper;
import com.rain.pojo.All;
import com.rain.pojo.Goods;
import com.rain.pojo.SuperAngGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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


    @RequestMapping("/book")
    public String book(HttpSession session, Model model) {
        String loginmsg = (String) session.getAttribute("loginmsg");
//        创建集合返回前端
        List<All> arrayList = new ArrayList();
//        遍历查询超市名和条形码编号
        for (SuperAngGoods superAngGoods :superAndGoodsMapper.queryGoodsAndSupernameList()) {
            String superName = superAngGoods.getSuper_name();
            String categoryId = superAngGoods.getCategory_id();
//                根据条形码编号查询商品信息
                Goods goods = goodsMapper.queryGoodsByCategory_id(categoryId);
                All all = new All();
                all.setA(goods.getName());
                all.setB(goods.getImg_url());
                all.setD_a(goods.getPrice());
                all.setC(superName);
                arrayList.add(all);

        }
        System.out.println(arrayList.get(1).getA());
        model.addAttribute("books",arrayList);
        return "customer/list";
    }
}
