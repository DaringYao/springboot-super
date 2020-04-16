package com.rain.service.impl;

import com.rain.mapper.GoodsMapper;
import com.rain.pojo.Goods;
import com.rain.pojo.User;
import com.rain.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/22 1:31
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoodsList() {
        return goodsMapper.queryGoodsList();
    }

    @Override
    public User queryUserById(int id) {
        return null;
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return 0;
    }

    @Override
    public int deleteGoods(int id) {
        return 0;
    }
}
