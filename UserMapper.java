package com.del.test_project_1.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.del.test_project_1.dto.UserDTO;

@Mapper
public interface UserMapper {
	@Insert("""
			insert into userinfo(name, id, password) values(#{name}, #{id}, #{pw})
			""")
	public int addUser(UserDTO userDTO);
	
	@Select("""
			select * from userinfo where id=#{id} and password=#{pw}
			""")
	public UserDTO loginUser(UserDTO userDTO);
	
	@Update("update userinfo set password=#{pw} where name=#{name}")
	public int updateUser(UserDTO userDTO);
	
	@Delete("delete from userinfo where password=#{pw}")
	public int deleteUser(UserDTO userDTO);
}
