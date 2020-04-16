package com.rain.mapper;

import com.rain.pojo.SuperUser;
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
 * @since 2020/3/28 18:51
 */
@Mapper
@Repository
public interface ShopUserMapper {
    @Select("select * from superUser")
    List<SuperUser> querySuperUserList();
    @Insert("insert superUser (userName, password, phone, conding, address, shop_class) VALUES (#{userName},#{password},#{phone},#{conding},#{address},#{shop_class})")
    int addSuperUser (SuperUser superUser);
}
