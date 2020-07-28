package com.rain.mapper;

import com.rain.pojo.Goods;
import com.rain.pojo.SuperAngGoods;
import org.apache.ibatis.annotations.Delete;
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
 * @since 2020/4/7 5:58
 */
@Mapper
@Repository
public interface SuperAndGoodsMapper {
    @Select("select super_name from superandgoods group by super_name")
    List<SuperAngGoods> queryGroupSuper_Name();

    @Select("select * from superandgoods")
    List<SuperAngGoods> queryGoodsAndSupernameList();

    @Select("select category_id from superandgoods where super_name=#{super_name}")
    List<SuperAngGoods> getCategory_idBysuper_name(String super_name);

    @Insert("insert superandgoods (super_name,category_id)values(#{super_name},#{category_id})")
    int addGoods(SuperAngGoods superAngGoods);

    @Delete("delete from superandgoods where category_id = #{category_id}")
    int deleteRow(String  category_id);
}
