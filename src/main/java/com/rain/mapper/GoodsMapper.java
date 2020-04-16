package com.rain.mapper;

import com.rain.pojo.All;
import com.rain.pojo.Goods;
import com.rain.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yls
 * @since 2020/3/22 1:27
 */
@Mapper
@Repository
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> queryGoodsList();

    @Select("select * from goods where category_id=#{category_id}")
    Goods queryGoodsByCategory_id(String category_id);



    @Insert("insert goods (name,price,img_url,category_id,group_class)values(#{name},#{price},#{img_url},#{category_id},#{group_class})")
    int addGoods(Goods goods);
    int updateGoods(Goods goods);
    int deleteGoods(int id);
}
