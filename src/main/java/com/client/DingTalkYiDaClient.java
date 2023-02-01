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
     * 获取流程详情
     *
     * @param processInstanceId 流程实例id
     * @param userId            用户id
     * @return responseBody
     */
    public String getProcess(String processInstanceId, String userId) {
        String url = DingTalkYiDaConstant.GET_PROCESS + "/%s?appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, processInstanceId, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.GET, null);
    }

    /**
     * 获取流程设计的节点信息
     *
     * @param processCode 流程编码
     * @param userId      用户id
     * @return responseBody
     */
    public String getProcessActivities(String processCode, String userId) {
        String url = DingTalkYiDaConstant.GET_PROCESS_ACTIVITIES + "?processCode=%s&appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, processCode, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.GET, null);
    }

    /**
     * 获取流程运行任务
     *
     * @param processInstanceId 流程实例id
     * @param userId            用户id
     * @return responseBody
     */
    public String getProcessRunningTask(String processInstanceId, String userId) {
        String url = DingTalkYiDaConstant.GET_PROCESS_RUNNING_TASK + "?processInstanceId=%s&appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, processInstanceId, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.GET, null);
    }

    /**
     * 发起流程
     *
     * @param formUuid     表单id
     * @param processCode  流程id
     * @param formDataJson 表单数据
     * @param userId       用户id
     * @return responseBody
     */
    public String createProcess(String formUuid, String processCode, String formDataJson, String userId) {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("appType", yiDaConfig.getAppType());
        bodyObj.put("systemToken", yiDaConfig.getSystemToken());
        bodyObj.put("userId", userId);
        bodyObj.put("formUuid", formUuid);
        bodyObj.put("processCode", processCode);
        bodyObj.put("formDataJson", formDataJson);
        return this.request(DingTalkYiDaConstant.CREATE_PROCESS, Method.POST, bodyObj.toJSONString());
    }

    /**
     * 更新流程表单数据
     *
     * @param processInstanceId 流程实例id
     * @param formDataJson      表单数据
     * @param userId            用户id
     * @return responseBody
     */
    public String updateProcess(String processInstanceId, String formDataJson, String userId) {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("appType", yiDaConfig.getAppType());
        bodyObj.put("systemToken", yiDaConfig.getSystemToken());
        bodyObj.put("userId", userId);
        bodyObj.put("processInstanceId", processInstanceId);
        bodyObj.put("updateFormDataJson", formDataJson);
        return this.request(DingTalkYiDaConstant.UPDATE_PROCESS, Method.PUT, bodyObj.toJSONString());
    }

    /**
     * 执行审批任务
     *
     * @param processInstanceId 流程实例id
     * @param taskId            任务id
     * @param outResult         审批结果 AGREE(同意)、DISAGREE(不同意)
     * @param remark            审批意见
     * @param formDataJson      更新的表单值
     * @param userId            用户的userid
     * @return responseBody
     */
    public String executeTask(String processInstanceId, String taskId, String outResult, String remark, String formDataJson, String userId) {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("appType", yiDaConfig.getAppType());
        bodyObj.put("systemToken", yiDaConfig.getSystemToken());
        bodyObj.put("userId", userId);
        bodyObj.put("processInstanceId", processInstanceId);
        bodyObj.put("taskId", taskId);
        bodyObj.put("outResult", outResult);
        bodyObj.put("remark", remark);
        bodyObj.put("formDataJson", formDataJson);
        return this.request(DingTalkYiDaConstant.EXECUTE_TASK, Method.POST, bodyObj.toJSONString());
    }

    /**
     * 删除流程数据
     *
     * @param processInstanceId 流程实例id
     * @param userId            用户id
     * @return responseBody
     */
    public String deleteProcess(String processInstanceId, String userId) {
        String url = DingTalkYiDaConstant.DELETE_PROCESS + "?processInstanceId=%s&appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, processInstanceId, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.DELETE, null);
    }

    /**
     * 终止流程
     *
     * @param processInstanceId 流程实例id
     * @param userId            用户id
     * @return responseBody
     */
    public String terminateProcess(String processInstanceId, String userId) {
        String url = DingTalkYiDaConstant.TERMINATE_PROCESS + "?processInstanceId=%s&appType=%s&systemToken=%s&userId=%s";
        url = String.format(url, processInstanceId, yiDaConfig.getAppType(), yiDaConfig.getSystemToken(), userId);
        return this.request(url, Method.PUT, null);
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
