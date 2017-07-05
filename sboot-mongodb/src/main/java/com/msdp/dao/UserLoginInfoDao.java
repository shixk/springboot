package com.msdp.dao;

import com.msdp.entity.UserLoginInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shixk1 on 2017/7/4.
 */
@Repository
public interface UserLoginInfoDao extends MongoRepository<UserLoginInfo,String> {
    UserLoginInfo findByUsername(String name);
}
