package com.alvin.mapper;

import com.alvin.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Insert("insert into user(username, password, create_time, update_time) " +
			" values(#{username},#{md5String},now(),now())")
	void add(final String username, final String md5String);

	@Select("select * from user where username = #{username}")
	User findByUsername(final String username);
}
