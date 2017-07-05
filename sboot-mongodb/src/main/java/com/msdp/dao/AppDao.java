package com.msdp.dao;

import com.msdp.entity.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by shixk1 on 2017/7/4.
 */
@Repository
public interface AppDao extends MongoRepository<App,String> {
    @Query(value="{'app_key_info.app_key':?0}")
    public App findByAppKey(String appKey);
}
