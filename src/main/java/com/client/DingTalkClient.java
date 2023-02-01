package com.client;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import com.config.DingTalkConfig;
import com.constant.DingTalkConstant;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author steed
 * @date 2021/7/20
 */
@Slf4j
public class DingTalkClient {

    private final DingTalkConfig config;

    public DingTalkClient(DingTalkConfig config) {
        this.config = config;
    }

    /**
     * 获取access_token
     *
     * @return access_token
     */
    public String getToken() {
        String url = String.format(DingTalkConstant.GET_TOKEN + "?appkey=%s&appsecret=%s", config.getAppKey(), config.getAppSecret());
        String body = HttpRequest.get(url).execute().body();
        JSONObject respObj = JSON.parseObject(body);
        if (respObj.getInteger("errcode") != 0) {
            throw new HttpException("获取钉钉access_token错误: " + respObj.getString("errmsg"));
        }
        return respObj.getString("access_token");
    }
}
