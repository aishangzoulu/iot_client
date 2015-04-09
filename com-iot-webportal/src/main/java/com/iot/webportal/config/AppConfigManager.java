package com.iot.webportal.config;

import com.iot.webportal.common.ApplicationContextHelper;

/**
 * Created by RayLew on 2014/11/15.
 */
public class AppConfigManager {

    private static final AppConfig appConfig;

    static {
        appConfig = (AppConfig) ApplicationContextHelper.getBean("appConfig");
    }

    /**
     * 获取 DoraWebApiBaseUrl 配置
     * @return
     */
    public static String getDoraWebApiBaseUrl()
    {
        return appConfig.getDoraWebApiBaseUrl();
    }
}
