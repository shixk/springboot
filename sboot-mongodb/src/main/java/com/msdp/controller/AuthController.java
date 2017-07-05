package com.msdp.controller;

import com.msdp.common.Constants;
import com.msdp.dao.AppDao;
import com.msdp.dao.ServiceDao;
import com.msdp.dao.UserLoginInfoDao;
import com.msdp.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shixk1 on 2017/7/4.
 */
@RestController
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserLoginInfoDao userLoginInfoDao;
    @Autowired
    private AppDao appDao;
    @Autowired
    private ServiceDao serviceDao;
    @RequestMapping(value="/getLoginUser/{username}")
    public UserLoginInfo getLoginUser(HttpServletRequest request, @PathVariable String username){
        return userLoginInfoDao.findByUsername(username);
    }

    @RequestMapping(value="/authAppToService/{appKey}/{serviceName}")
    public ResultEntity AuthAppToService(HttpServletRequest request, @PathVariable String appKey, @PathVariable String serviceName){
        if(StringUtils.isEmpty(appKey)||StringUtils.isEmpty(serviceName)){
            return new ResultEntity(Constants.NotAuthCode,Constants.NotAuthMsg);
        }
        logger.info("访问鉴权服务，参数appkey:"+appKey+"  serviceName:"+serviceName);
        ResultEntity result=new ResultEntity();
        try{
            App app=appDao.findByAppKey(appKey);
            Service serv=serviceDao.findServiceByServiceName(serviceName);
            result=JudgeAuthority(app,serv);
        }catch (Exception e){
            logger.info("鉴权服务发生异常:"+e.getMessage());
            result.setCode(Constants.ErrorCode);
            result.setMsg(Constants.ErrorMsg);
        }

        return result;
    }

    private ResultEntity JudgeAuthority(App app,Service serv){
        ResultEntity result=new ResultEntity();
        result.setCode(Constants.NotAuthCode);
        result.setMsg(Constants.NotAuthMsg);
        if(null==app||null==serv){
            logger.info("访问鉴权服务，查询到的app或者service为空。退出");
            return result;
        }else{
            for(AppService item:app.getAppServices()){
                if(item.getService_id().equals(serv.getId())){
                    result.setCode(Constants.AuthCode);
                    result.setMsg(Constants.AuthMsg);
                    break;
                }
            }
        }
        return result;
    }

}
