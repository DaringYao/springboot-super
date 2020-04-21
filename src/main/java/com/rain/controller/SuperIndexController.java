package com.rain.controller;

import com.rain.mapper.GoodsMapper;
import com.rain.mapper.SuperAndGoodsMapper;
import com.rain.pojo.Goods;
import com.rain.pojo.SuperAngGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/26 2:04
 */
@Controller
@RequestMapping("/super")
public class SuperIndexController {
    @Autowired
    private SuperAndGoodsMapper superAndGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String returnList(HttpSession session,
                             Model model){
        String superloginmsg = (String) session.getAttribute("superloginmsg");
        List<SuperAngGoods> super_nameToGoodsList = superAndGoodsMapper.getSuper_nameToGoodsList(superloginmsg);
        ArrayList<Goods> super_list = new ArrayList();
        for (SuperAngGoods goodsss : super_nameToGoodsList){
            String category_id = goodsss.getCategory_id();
            Goods goodss = goodsMapper.queryGoodsByCategory_id(category_id);
            super_list.add(goodss);
        }
        System.out.println(super_list.get(1).getImg_url());
        model.addAttribute("super_list",super_list);
        return "super/list";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/add")
    public String returnAdd(){
        return "super/add";
    }

    /**
     *
     * @param category_id
     * @param model
     * @return
     */
    @RequestMapping("/addGoodsquery001")

    public String addGoodsquery(@RequestParam("category_id") String category_id,
                                Model model){
        System.out.println(category_id);

        Goods queryGoodsByCategory_id = goodsMapper.queryGoodsByCategory_id(category_id);
        model.addAttribute("category",queryGoodsByCategory_id);
        return "super/addqurey";
    }
    @RequestMapping("/add/{Category_id}")
    public String updateGoods(@PathVariable("Category_id") String category_id,
                              HttpSession session,
                              Model model){
        System.out.println(category_id);
        String super_name = (String) session.getAttribute("superloginmsg");
        System.out.println(super_name);
        SuperAngGoods superAngGoods = new SuperAngGoods();
        superAngGoods.setSuper_name(super_name);
        superAngGoods.setCategory_id(category_id);
        int i;
        try {
            i = superAndGoodsMapper.addGoods(superAngGoods);
                model.addAttribute("super_add","商品已添加，继续添加");
                return "super/add";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("super_add","商品已存在，无需重复添加");
            return "super/add";
        }

    }
}
