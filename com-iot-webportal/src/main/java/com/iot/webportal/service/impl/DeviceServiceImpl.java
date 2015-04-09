package com.iot.webportal.service.impl;

import com.google.gson.reflect.TypeToken;
import com.iot.utils.JsonUtils;
import com.iot.webportal.dto.Device;
import com.iot.webportal.dto.ResultCode;
import com.iot.webportal.service.DeviceService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户设备控制相关
 */
@Service
public class DeviceServiceImpl extends ServiceBase implements DeviceService {

    @Override
    public Device get(Long id) {
        WebApiResult<Device> result = null;
        try {
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("id", String.valueOf(id));

            String ret = WebApiRequest.get("device/get", paramMap);

            Type type = new TypeToken<WebApiResult<Device>>() {
            }.getType();
            result = JsonUtils.fromJson(ret, type);
            // 成功
            if (result.getCode() == ResultCode.STATUS_OK) {
                return result.getData();
            }
        } catch (Exception ex) {
            logger.error(ex);
            result = new WebApiResult<Device>();
            result.setCode(ResultCode.SERVER_ERROR);
            result.setMsg(ex.toString());
        }
        return null;
    }

    @Override
    public Long add(Device device) {

        WebApiResult<Long> result = null;
        try {
            String entityData = JsonUtils.toJson(device);
            String ret = WebApiRequest.post("device/add", null, entityData, null);

            Type type = new TypeToken<WebApiResult<Long>>() {
            }.getType();
            result = JsonUtils.fromJson(ret, type);
            // 成功
            if (result.getCode() == ResultCode.STATUS_OK) {
                return result.getData();
            }
        } catch (Exception ex) {
            logger.error(ex);
            result = new WebApiResult<Long>();
            result.setCode(ResultCode.SERVER_ERROR);
            result.setMsg(ex.toString());
        }
        return null;
    }

    @Override
    public List<Device> getList(long userId, int pageIndex, int pageSize) {
        WebApiResult<List<Device>> result = null;
        try {
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("userId", String.valueOf(userId));
            paramMap.put("pageIndex", String.valueOf(pageIndex));
            paramMap.put("pageSize", String.valueOf(pageSize));

            String ret = WebApiRequest.get("device/list", paramMap);

            Type type = new TypeToken<WebApiResult<List<Device>>>() {
            }.getType();
            result = JsonUtils.fromJson(ret, type);
            // 成功
            if (result.getCode() == ResultCode.STATUS_OK) {
                return result.getData();
            }
        } catch (Exception ex) {
            logger.error(ex);
            result = new WebApiResult<List<Device>>();
            result.setCode(ResultCode.SERVER_ERROR);
            result.setMsg(ex.toString());
        }
        return null;
    }

    @Override
    public Long getCount(long userId) {
        WebApiResult<Long> result = null;
        try {
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("userId", String.valueOf(userId));

            String ret = WebApiRequest.get("device/count", paramMap);

            Type type = new TypeToken<WebApiResult<Long>>() {
            }.getType();
            result = JsonUtils.fromJson(ret, type);
            // 成功
            if (result.getCode() == ResultCode.STATUS_OK) {
                return result.getData();
            }
        } catch (Exception ex) {
            logger.error(ex);
            result = new WebApiResult<Long>();
            result.setCode(ResultCode.SERVER_ERROR);
            result.setMsg(ex.toString());
        }
        return null;
    }

}
