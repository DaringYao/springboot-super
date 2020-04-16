package com.rain.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
 * @since 2020/3/13 13:41
 */
@Mapper
@Repository
public interface UserMapper {


    List<User> queryUserList();
    User queryUserById(int id);
    @Insert("insert into user (username,password,phone,email) values (#{username},#{password},#{phone},#{email})")
    int aaddUser(User user);

    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);

}
