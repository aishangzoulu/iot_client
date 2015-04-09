package com.iot.webportal.config;

/**
 * Created by RayLew on 2014/11/14.
 */
class AppConfigImpl implements AppConfig
{
    private String doraWebApiBaseUrl;

    public String getDoraWebApiBaseUrl() {
        return doraWebApiBaseUrl;
    }

    public void setDoraWebApiBaseUrl(String doraWebApiBaseUrl) {
        this.doraWebApiBaseUrl = doraWebApiBaseUrl;
    }
}
