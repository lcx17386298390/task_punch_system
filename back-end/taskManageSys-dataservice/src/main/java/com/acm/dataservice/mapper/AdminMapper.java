package com.acm.dataservice.mapper;

import com.acm.api.model.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where username=#{username}")
    Admin findAuthByName(String username);
    @Insert("insert into admin (email,username,password,role) values(#{email},#{username},#{password},#{role})")
    int addAdmin(String email,String username,String password,String role);
}