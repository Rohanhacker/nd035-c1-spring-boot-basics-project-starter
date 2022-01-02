package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from USERS where username = #{username}")
    User getUser(String username);

    @Insert("insert into USERS (firstname, lastname, username, password, salt) values (#{firstname}, #{lastname}, #{username}, #{password}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);
}
