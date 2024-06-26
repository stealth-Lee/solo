package com.solo.system.web;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.mybatisflex.core.paginate.Page;
import com.solo.common.core.aop.annotation.Runtime;
import com.solo.common.core.global.R;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.enums.LoggerType;
import com.solo.common.orm.core.query.Wrappers;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.model.config.SysConfigConvert;
import com.solo.system.model.config.req.ConfigCreateReq;
import com.solo.system.model.config.req.ConfigQueryReq;
import com.solo.system.model.config.req.ConfigUpdateReq;
import com.solo.system.model.config.resp.ConfigGetResp;
import com.solo.system.model.config.resp.ConfigListResp;
import com.solo.system.service.SysConfigService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

import static com.solo.system.api.entity.table.SysConfigTableDef.SysConfigTable;

/**
 * 系统配置控制器
 * @author 十一
 * @since 2023-10-18 17:30
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/system/config")
public class SysConfigController {

    private final SysConfigService sysConfigService;

    /**
     * 新增系统配置
     * @param req 系统配置新增对象
     * @return 响应信息
     */
    @PostMapping
    @SaCheckPermission("system-config-create")
    @Logger(value = "创建系统配置", type = LoggerType.CREATE)
    public R<Boolean> create(@Valid @RequestBody ConfigCreateReq req) {
        SysConfig entity = SysConfigConvert.INSTANCE.convert(req);
        return R.success(sysConfigService.save(entity));
    }

    /**
     * 删除系统配置
     * @param configIds 系统配置集合
     * @return 响应信息
     */
    @SaCheckPermission("system-config-delete")
    @DeleteMapping("/{configIds}")
    @Logger(value = "删除系统配置", type = LoggerType.DELETE)
    public R<Boolean> delete(@PathVariable Long[] configIds) {
        return R.success(sysConfigService.removeByIds(Arrays.asList(configIds)));
    }

    /**
     * 更新系统配置
     * @param req 系统配置更新对象
     * @return 响应信息
     */
    @PutMapping
    @SaCheckPermission("system-config-update")
    @Logger(value = "更新系统配置", type = LoggerType.UPDATE)
    public R<Boolean> update(@Valid @RequestBody ConfigUpdateReq req) {
        SysConfig entity = SysConfigConvert.INSTANCE.convert(req);
        return R.success(sysConfigService.updateById(entity));
    }

    /**
     * 获取系统配置
     * @param configId 系统配置
     * @return 响应信息
     */
    @GetMapping("/{configId}")
    @SaCheckPermission("system-config-query")
    public R<ConfigGetResp> get(@PathVariable Long configId) {
        return R.success(SysConfigConvert.INSTANCE.convertGet(sysConfigService.getById(configId)));
    }

    /**
     * 根据key获取系统配置
     * @param key 系统配置key
     * @return 响应信息
     */
    @GetMapping("/key/{key}")
    @SaCheckPermission("system-config-query")
    public R<SysConfig> selectConfigByKey(@PathVariable String key) {
        return R.success(sysConfigService.queryChain().where(SysConfigTable.Key.eq(key)).one());
    }

    /**
     * 分页查询系统配置列表
     * @param page 分页对象
     * @param req 系统配置查询对象
     * @return 响应信息
     */
    @Runtime
    @GetMapping("/page")
    @SaCheckPermission("system-config-query")
    public R<Page<ConfigListResp>> page(Page<ConfigListResp> page, ConfigQueryReq req) {
        Page<ConfigListResp> list = sysConfigService.pageAs(page, Wrappers.builder(req), ConfigListResp.class);
        return R.success(list);
    }

    @PostMapping("/import")
    @SaCheckPermission("system-config-import")
    @Logger(value = "导入系统配置", type = LoggerType.IMPORT)
    public void importExcel(MultipartFile file) throws IOException {
        sysConfigService.importExcel(file);
    }

    @GetMapping("/export")
    @SaCheckPermission("system-config-export")
    @Logger(value = "导出系统配置", type = LoggerType.EXPORT)
    public void exportExcel(HttpServletResponse response, ConfigQueryReq req) throws IOException {
        sysConfigService.exportExcel(response, req);
    }

}
