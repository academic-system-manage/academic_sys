package com.acasys.mapper;

import com.acasys.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * author:lixuewei
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from users where email=#{email}")
//    public User selectByEmail(String email);
//
//    @Select("select * from users where username=#{username}")
//    public User selectByUsername(String username);

//    @Insert("insert into users values(#{id},#{password},#{username},#{site},#{email})")
//    public int saveUser(User user);
//
//    @Update("update users set password=#{newPSW} where email=#{email}")
//    void updatePSW(String id, String newPSW);
}
