package com.rain.mapper;

import com.rain.pojo.Cart;
import com.rain.pojo.Goods;
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
 * @author 澜阙望月
 * @since 2020/4/22 16:51
 */
@Mapper
@Repository
public interface CartMapper {
/*id
super_name
category_id
username     */
    @Insert("insert into cart (super_name,category_id,username)values(#{super_name},#{category_id},#{username})")
    int addGoods(Cart cart);
//    int id;
//String super_name;
//String category_id;
//String username;
    @Select("select  super_name from cart  where username = #{username} group by super_name")
    List<Cart> queryGroupSuper_nameByusername(String username);
    @Select("select category_id from cart where super_name = #{super_name}")
    List<Cart> queryCategory_idBySuper_name(String super_name);
}
