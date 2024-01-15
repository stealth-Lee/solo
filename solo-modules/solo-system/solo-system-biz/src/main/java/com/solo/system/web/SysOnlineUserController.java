package com.solo.system.web;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.global.R;
import com.solo.common.core.utils.BeanUtils;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.satoken.utils.LoginHelper;
import com.solo.system.model.online.user.resp.OnlineUserResp;
import com.solo.system.model.user.req.UserQueryReq;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 在线用户控制器
 * @author 十一
 * @since 2023/12/28 15:05
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/system/online-user")
public class SysOnlineUserController {

    /**
     * 强退在线用户
     * @param userIds 用户 ID
     * @return {@link R}<{@link Boolean}>
     */
    @DeleteMapping("/offline/{userIds}")
    @SaCheckPermission("system-online-user-offline")
    @Logger(value = "强退在线用户", type = LoggerType.OTHER)
    public R<Boolean> offline(@PathVariable("userIds") Long[] userIds) {
        for (Long userId : userIds) {
            StpUtil.kickout(userId);
        }
        return R.success();
    }

    /**
     * 分页查询在线用户
     * @param page 页
     * @param req  要求
     * @return {@link R}<{@link Page}<{@link OnlineUserResp}>>
     */
    @GetMapping("/page")
    @SaCheckPermission("system-online-user-query")
    public R<Page<OnlineUserResp>> page(Page<OnlineUserResp> page, UserQueryReq req) {
        List<OnlineUserResp> onlineUsers = new ArrayList<>();
        List<String> sessionIdList = StpUtil.searchSessionId("", (int) page.offset(), (int) page.getPageSize(), false);
        for (String sessionId : sessionIdList) {
            SaSession session = StpUtil.getSessionBySessionId(sessionId);
            OnlineUserResp resp = BeanUtils.toBean(session.getDataMap().get(LoginHelper.LOGIN_USER_KEY), OnlineUserResp.class);
            resp.setNumber(session.getTokenSignList().size());
            onlineUsers.add(resp);
        }
        page.setRecords(onlineUsers);
        return R.success(page);
    }


}
