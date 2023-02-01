package com.config;

import lombok.Data;

/**
 * @author steed
 * @since 2021/11/10
 **/
@Data
public class DingTalkYiDaConfig {

    private String domain;

    /**
     * 应用ID
     */
    private String appType;

    /**
     * 应用秘钥
     */
    private String systemToken;
}
