package com.sailheader.testng.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Porsche
 * @Date 2024/6/10 14:06
 */
@Slf4j
public class HttpUtil {

    public static String doPost(String url, String param){
        log.info("doPost url:{}, param:{}", url, param);
        return "第三方系统返回的结果：" + url;
    }
}
