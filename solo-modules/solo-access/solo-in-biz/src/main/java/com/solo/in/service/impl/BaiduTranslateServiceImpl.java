//package com.solo.in.service.impl;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.crypto.digest.DigestUtil;
//import cn.hutool.http.HttpUtil;
//import com.solo.in.api.entity.UniversalTranslation;
//import com.solo.in.service.TranslateService;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
//@Service
//public class BaiduTranslateServiceImpl implements TranslateService {
//
//    @Override
//    public String translate(UniversalTranslation translation) {
//        translation.setAppid("20230317001603857");
//        translation.setSalt("10");
//        String sign = translation.getAppid() + translation.getQ() + translation.getSalt() + "SxD3Qu_AFRNdkDQhRtwg";
//        translation.setSign(DigestUtil.md5Hex(sign));
//        Map<String, Object> paramMap = BeanUtil.beanToMap(translation);
//        return HttpUtil.get("https://fanyi-api.baidu.com/api/trans/vip/translate", paramMap);
//    }
//
//}
