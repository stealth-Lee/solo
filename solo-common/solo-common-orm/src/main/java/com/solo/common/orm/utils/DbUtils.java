package com.solo.common.orm.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DB工具类
 * @author 十一
 * @since 2023/10/09 13:58
 * 人生若只如初见，何事秋风悲画扇
 **/
public class DbUtils {

    private static final int LOGIN_TIMEOUT_SECONDS = 6;

    /**
     * 是否连接成功
     * @param url 数据源URL地址
     * @param username 用户名
     * @param password 密码
     * @return 是否连接成功
     */
    public static boolean isConnection(String url, String username, String password) {
        DriverManager.setLoginTimeout(LOGIN_TIMEOUT_SECONDS);
        try (Connection ignored = DriverManager.getConnection(url, username, password)) {
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
