package com.iot.webportal.service.impl;

import com.google.gson.reflect.TypeToken;
import com.iot.utils.JsonUtils;
import com.iot.webportal.dto.ResultCode;
import com.iot.webportal.dto.UserInfo;
import com.iot.webportal.service.UserService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户账户控制相关
 */
@Service
public class UserServiceImpl extends ServiceBase implements UserService {

    @Override
    public WebApiResult<Long> register(UserInfo userInfo) {

        WebApiResult<Long> result = null;
        try {
            String entityData = JsonUtils.toJson(userInfo);
            String ret = WebApiRequest.post("user", null, entityData, null);

            Type type = new TypeToken<WebApiResult<Long>>() {
            }.getType();
            result = JsonUtils.fromJson(ret, type);
            // 成功
            if (result.getCode() == ResultCode.STATUS_OK) {
                return result;
            }
        } catch (Exception ex) {
            logger.error(ex);
            result = new WebApiResult<Long>();
            result.setCode(ResultCode.SERVER_ERROR);
            result.setMsg(ex.toString());
        }
        return result;
    }

    @Override
    public WebApiResult<UserInfo> login(String loginName, String password) {
        WebApiResult<UserInfo> result = null;
        try {
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("loginName", loginName);
            paramMap.put("password", password);

            String ret = WebApiRequest.get("user", paramMap);

            Type type = new TypeToken<WebApiResult<UserInfo>>() {
            }.getType();
            result = JsonUtils.fromJson(ret, type);
            // 成功
            if (result.getCode() == ResultCode.STATUS_OK) {
                return result;
            }
        } catch (Exception ex) {
            logger.error(ex);
            result = new WebApiResult<UserInfo>();
            result.setCode(ResultCode.SERVER_ERROR);
            result.setMsg(ex.toString());
        }
        return result;
    }

}
