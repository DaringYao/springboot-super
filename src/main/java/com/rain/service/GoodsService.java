package com.rain.service;

import com.rain.pojo.Goods;
import com.rain.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/22 1:30
 */
public interface GoodsService {
    List<Goods> queryGoodsList();
    User queryUserById(int id);
    int addGoods(Goods goods);
    int updateGoods(Goods goods);
    int deleteGoods(int id);
}
