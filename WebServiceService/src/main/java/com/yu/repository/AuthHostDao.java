package com.yu.repository;

import com.yu.domain.AuthHost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-5-8
 * @Description: 授权主机持久层
 */
@Mapper
public interface AuthHostDao {

    List<AuthHost> selectAuthHost(AuthHost authHost);
}
