package com.modules.scheduler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.client.DingTalkYiDaClient;
import com.config.DingTalkConfig;
import com.config.DingTalkYiDaConfig;
import com.config.YiDaConfig;
import com.modules.customer.entity.CustomerEntity;
import com.modules.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class CustomerTask {

    private YiDaConfig yiDaConfig;

    private JSONObject formConfig;

    private String managerUserId;

    private DingTalkYiDaClient yiDaClient;

    @Autowired
    private CustomerService customerService;


    @Scheduled(cron = "0 25 12 * * ?")
    public void run() {
        log.info("客户更新任务start");
        this.run(new HashMap<>(0));
        log.info("客户更新任务end");
    }

    public void run(Map<String, Object> params) {
        // 初始化
        this.load();
        String customerFormUuid = this.formConfig.getJSONObject("customer").getString("formUuid");
        // 查询客户表单数据
        JSONObject searchFieldJsonObject = new JSONObject();
        List<JSONObject> resultList = this.getFormDataList(customerFormUuid, searchFieldJsonObject.toJSONString());
        if (resultList == null) {
            return;
        }
        List<JSONObject> dataList = new ArrayList<>();
        resultList.forEach(result -> {
            dataList.add(result.getJSONObject("formData"));
        });
        // 处理数据
        this.handleData(dataList);
    }

    /**
     * 初始化
     */
    public void load() {
        // 初始化 yiDaConfig
        this.yiDaConfig = new YiDaConfig();
        // 初始化 formConfig
        this.formConfig = this.yiDaConfig.getFormConfig();
        // 初始化managerId
        this.managerUserId = yiDaConfig.getDingTalkYiDaConfig().getString("userId");
        // 设置dingTalkConfig
        DingTalkConfig dingTalkConfig = new DingTalkConfig();
        dingTalkConfig.setAgentId(yiDaConfig.getDingTalkConfig().getLong("agentId"));
        dingTalkConfig.setAppKey(yiDaConfig.getDingTalkConfig().getString("appKey"));
        dingTalkConfig.setAppSecret(yiDaConfig.getDingTalkConfig().getString("appSecret"));
        // 设置dingTalkYiDaConfig
        DingTalkYiDaConfig dingTalkYiDaConfig = new DingTalkYiDaConfig();
        dingTalkYiDaConfig.setDomain(yiDaConfig.getDingTalkYiDaConfig().getString("domain"));
        dingTalkYiDaConfig.setAppType(yiDaConfig.getDingTalkYiDaConfig().getString("appType"));
        dingTalkYiDaConfig.setSystemToken(yiDaConfig.getDingTalkYiDaConfig().getString("systemToken"));

        // 初始化 yiDaClient
        this.yiDaClient = new DingTalkYiDaClient(dingTalkConfig, dingTalkYiDaConfig);
    }

    /**
     * 根据条件查询单条数据
     *
     * @param formUuid        表单id
     * @param searchFieldJson 查询条件
     * @return formData
     */
    public List<JSONObject> getFormDataList(String formUuid, String searchFieldJson) {
        int startPage = 1;
        int pageSize = 99;
        JSONObject paramsObject = new JSONObject();
        paramsObject.put("formUuid", formUuid);
        paramsObject.put("userId", managerUserId);
        paramsObject.put("pageSize", pageSize);
        paramsObject.put("searchFieldJson", searchFieldJson);
        paramsObject.put("currentPage", startPage);
        log.info("searchForm: {}", paramsObject.toJSONString());
        try {
            String respStr = yiDaClient.searchForm(paramsObject);
            log.info("respStr: {}", respStr);
            JSONObject respObj = JSONObject.parseObject(respStr);
            JSONArray respData = respObj.getJSONArray("data");
            if (respObj.getInteger("totalCount") == 0) {
                return null;
            }
            return respData.toJavaList(JSONObject.class);
        } catch (Exception e) {
            return getFormDataList(formUuid, searchFieldJson);
        }
    }

    /**
     * 处理数据
     */
    public void handleData(List<JSONObject> dataList) {
        // 先删除所有数据
        customerService.deleteAll();
        // 后新增
        dataList.forEach(data -> {
            // 处理主表的客户信息
            CustomerEntity customer = new CustomerEntity();
            customer.setNumber(data.getString("textField_kxjohve2"));
            customer.setName(data.getString("textField_kxjohve3"));
            customer.setGrade(data.getString("radioField_kxjohve4_id"));
            customer.setAddress(data.getString("addressField_kxjohve6_id"));
            customerService.insert(customer);
            // 处理联系人信息
            JSONArray concatArray = data.getJSONArray("tableField_kxjp76k0");
            System.out.println(concatArray);
        });
    }
}
