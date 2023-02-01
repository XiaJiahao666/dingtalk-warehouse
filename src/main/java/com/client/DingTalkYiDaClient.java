package com.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSONObject;
import com.config.DingTalkConfig;
import com.config.DingTalkYiDaConfig;
import com.constant.DingTalkYiDaConstant;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @author steed
 * @since 2021/11/10
 **/
@Slf4j
public class DingTalkYiDaClient extends DingTalkClient {

    private final DingTalkYiDaConfig yiDaConfig;

    public DingTalkYiDaClient(DingTalkConfig config, DingTalkYiDaConfig yiDaConfig) {
        super(config);
        this.yiDaConfig = yiDaConfig;
    }

    /**
     * 查询表单数据
     *
     * @param bodyObj 参数
     */
    public String searchForm(JSONObject bodyObj) {
        bodyObj.put("appType", yiDaConfig.getAppType());
        bodyObj.put("systemToken", yiDaConfig.getSystemToken());
        return this.request(DingTalkYiDaConstant.SEARCH_FORM, Method.POST, bodyObj.toJSONString());
    }

    /**
     * 获取表单详情
     *
     * @param formInstanceId 表单实例id
     * @param userId         用户id
     * @return responseBody
     */
    public String getForm(String formInstanceId, String userId) {
        String url = DingTalkYiDaConstant.GET_FORM + "/%s?appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, formInstanceId, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.GET, null);
    }

    /**
     * 保存表单数据
     *
     * @param formUuid     表单id
     * @param formDataJson 数据
     * @param userId       用户id
     * @return responseBody
     */
    public String createForm(String formUuid, String formDataJson, String userId) {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("appType", yiDaConfig.getAppType());
        bodyObj.put("systemToken", yiDaConfig.getSystemToken());
        bodyObj.put("userId", userId);
        bodyObj.put("formUuid", formUuid);
        bodyObj.put("formDataJson", formDataJson);
        return this.request(DingTalkYiDaConstant.CREATE_FORM, Method.POST, bodyObj.toJSONString());
    }

    /**
     * 更新表单数据
     *
     * @param formInstanceId 表单实例id
     * @param formDataJson   数据
     * @param userId         用户id
     * @return responseBody
     */
    public String updateForm(String formInstanceId, String formDataJson, String userId) {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("appType", yiDaConfig.getAppType());
        bodyObj.put("systemToken", yiDaConfig.getSystemToken());
        bodyObj.put("userId", userId);
        bodyObj.put("formInstanceId", formInstanceId);
        bodyObj.put("updateFormDataJson", formDataJson);
        return this.request(DingTalkYiDaConstant.UPDATE_FORM, Method.PUT, bodyObj.toJSONString());
    }

    /**
     * 删除表单数据
     *
     * @param formInstanceId 表单实例id
     * @param userId         用户id
     * @return responseBody
     */
    public String deleteForm(String formInstanceId, String userId) {
        String url = DingTalkYiDaConstant.DELETE_FORM + "?formInstanceId=%s&appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, formInstanceId, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.DELETE, null);
    }

    /**
     * 获取临时免登附件地址
     *
     * @param userId  用户id
     * @param fileUrl 文件地址
     * @return responseBody
     */
    public String temporaryUrls(String userId, String fileUrl) {
        String url = DingTalkYiDaConstant.TEMPORARY_URLS + "?systemToken=%s&userId=%s&fileUrl=%s&timeout=600000";
        url = String.format(url, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId, fileUrl);
        return this.request(url, Method.GET, null);
    }

    private String request(String url, Method method, String body) {
        url = yiDaConfig.getDomain() + url;
        HttpRequest request = HttpRequest.of(url);
        return request.method(method).timeout(30000)
                .header("x-acs-dingtalk-access-token", this.getToken())
                .body(body)
                .contentType("application/json")
                .charset(StandardCharsets.UTF_8)
                .execute().body();
    }
}
