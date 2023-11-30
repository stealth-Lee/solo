package com.solo.system.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.solo.system.api.entity.SysMenu;
import com.solo.system.mapper.SysMenuMapper;
import com.solo.system.service.SysMenuService;
import com.solo.common.orm.base.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solo.system.api.entity.table.SysMenuTableDef.SysMenuTable;
import static com.solo.system.api.entity.table.SysRoleMenuTableDef.SysRoleMenuTable;
import static com.solo.system.api.entity.table.SysRoleTableDef.SysRoleTable;
import static com.solo.system.api.entity.table.SysUserRoleTableDef.SysUserRoleTable;


/**
 * 菜单 Service实现类
 * @author 十一
 * @since 2023-11-14 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
public class ISysMenuServiceImpl extends BasicServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
