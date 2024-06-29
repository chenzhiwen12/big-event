package com.alvin.mapper;

import com.alvin.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	@Insert("insert into user(username, password, create_time, update_time) " +
			" values(#{username},#{md5String},now(),now())")
	void add(final String username, final String md5String);

	@Select("select * from user where username = #{username}")
	User findByUsername(final String username);

	@Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
	void update(final User user);

	@Update("update user set user_pic=#{userPic},update_time=now() where id=#{id}")
	void updateAvatar(final String userPic, final Integer id);

	@Update("update user set password=#{updatePwd},update_time=now() where id=#{id}")
	void updatePwd(final Integer id, final String updatePwd);
}
