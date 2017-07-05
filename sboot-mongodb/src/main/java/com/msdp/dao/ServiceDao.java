package com.msdp.dao;

import com.msdp.entity.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by shixk1 on 2017/7/4.
 */
@Repository
public interface ServiceDao extends MongoRepository<Service,String> {
    @Query(value="{'service_name':?0},{'deleted':'false'}")
    Service findServiceByServiceName(String ServiceName);
}
