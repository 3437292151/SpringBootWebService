package com.yu.repository;

import com.yu.domain.AuthUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-5-7
 * @Description: 授权用户持久层
 */
@Mapper
public interface AuthUserDao {

    List<AuthUser> selectAuthUser(AuthUser authUser);

}
