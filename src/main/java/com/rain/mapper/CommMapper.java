package com.rain.mapper;

import com.rain.pojo.Comm;
import com.rain.pojo.User;
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
public interface CommMapper {

    @Select("select * from comm")
    List<Comm> query();



}
