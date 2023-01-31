package com.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class YiDaConfig {

    public JSONObject getDingTalkConfig() {
        return JSON.parseObject("{\"appKey\":\"dingdinptvadmovjqkal\",\"agentId\":2383375175,\"appSecret\":\"hZSP-GTUOWLgOGt4izPa50gjwE-0bf0U38U10ETqpXAfNSn8JmLg50j-D5QG-b5i\"}");
    }

    public JSONObject getDingTalkYiDaConfig() {
        return JSON.parseObject("{\"domain\":\"https://api.dingtalk.com\",\"userId\":\"2500140603\",\"appType\":\"APP_F7H3H8KLJGMM40HWD78A\",\"systemToken\":\"E8866MB1VKG717CJ68UVX55H1UUT3QPUXFIDLJB\"}");
    }

    public JSONObject getFormConfig() {
        return JSON.parseObject("{\"customer\":{\"formUuid\":\"FORM-BH766Y616SB727QWD9IGMD6SK4ZG2YQUXFIDL5N1\"},\"supplier\":{\"formUuid\":\"FORM-BH766Y616SB727QWD9IGMD6SK4ZG2YQUXFIDLEN1\"},\"warehouse\":{\"formUuid\":\"FORM-BH766Y616SB727QWD9IGMD6SK4ZG2YQUXFIDLON1\"}}");
    }
}
