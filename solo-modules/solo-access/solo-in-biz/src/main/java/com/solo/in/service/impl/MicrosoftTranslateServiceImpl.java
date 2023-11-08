package com.solo.in.service.impl;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.solo.common.core.utils.StringUtils;
import com.solo.in.api.entity.UniversalTranslation;
import com.solo.in.service.TranslateService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 微软翻译Service实现
 * @author 十一
 * @since 2023/11/06 09:45
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class MicrosoftTranslateServiceImpl implements TranslateService {

    /** 令牌 */
    private String token = null;

    /** 令牌过期时间 */
    private Long exp = null;

    /** 重试次数 */
    private static final int RETRY_TIMES = 10;

    /** 锁 */
    private static final Object LOCK = new Object();

    /**
     * 刷新令牌
     */
    private void refreshToken() {
        String thisToken = null;
        for (int i = 1; i <= RETRY_TIMES; i++) {
            try {
                thisToken = HttpUtil.get("https://edge.microsoft.com/translate/auth");
                if (thisToken != null && !thisToken.isEmpty()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("获取微软翻译token失败,重试第" + i + "次");
            }
        }
        if (thisToken == null || thisToken.isEmpty()) {
            throw new RuntimeException("重试" + RETRY_TIMES + "次后获取微软token仍失败");
        }
        Long thisExp = JSON.parseObject(Base64.getUrlDecoder().decode(thisToken.split("\\.")[1])).getLong("exp");
        token = thisToken;
        exp = thisExp;
    }

    /**
     * 获取令牌
     * @return 字符串
     */
    private String getToken() {
        if (token != null && exp != null && exp * 1000L > System.currentTimeMillis()) {
            return token;
        }
        synchronized (LOCK) {
            if (token != null && exp != null && exp * 1000L > System.currentTimeMillis()) {
                return token;
            }
            refreshToken();
        }
        return token;
    }

    @Override
    public String text(UniversalTranslation translation) {
        String token = getToken();
        StringBuilder to = new StringBuilder();
        String from = translation.getFrom();
        if (StringUtils.isNotBlank(from)) {
            to.append("&from=").append(from);
        }
        to.append("&to=").append(translation.getTo());
        String url = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&textType=plain" + to;
        JSONArray body = new JSONArray();
        JSONObject textObject = new JSONObject();
        textObject.put("Text", translation.getQ());
        body.add(textObject);
        String body1 = HttpRequest.post(url).header(Header.AUTHORIZATION, "Bearer " + token).
                body(body.toJSONString()).execute().body();
        JSONArray jsonArray = JSON.parseArray(body1);
        JSONObject item = jsonArray.getJSONObject(0);
        JSONArray translations = item.getJSONArray("translations");
        return translations.getJSONObject(0).getString("text");
    }

}
