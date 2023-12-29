package com.solo.system.api.consts.menu;

public class Meta {

    /**
     * 菜单名称（兼容国际化、非国际化，如果用国际化的写法就必须在根目录的locales文件夹下对应添加）
     */
    public static final String TITLE = "title";

    /**
     * 菜单图标
     */
    public static final String ICON = "icon";

    /**
     * 是否显示该菜单
     */
    public static final String SHOW_LINK = "showLink";

     /**
      * 是否显示父级菜单
      */
    public static final String SHOW_PARENT = "showParent";

    /**
     * 页面级别权限设置
     */
    public static final String ROLES = "roles";

    /**
     * 按钮级别权限设置
     */
    public static final String AUTHS = "auths";

    /**
     * 是否缓存该路由页面（开启后，会保存该页面的整体状态，刷新后会清空状态）
     */
    public static final String KEEP_ALIVE = "keepAlive";

    /**
     * 需要内嵌的iframe链接地址
     */
    public static final String FRAME_SRC = "frameSrc";

    /**
     * 内嵌的iframe页面是否开启首次加载动画
     */
    public static final String FRAME_LOADING = "frameLoading";

    /**
     * 当前菜单名称或自定义信息禁止添加到标签页
     */
    public static final String HIDDEN_TAG = "hiddenTag";

    /**
     * 显示在标签页的最大数量，需满足后面的条件：不显示在菜单中的路由并且是通过query或params传参模式打开的页面。在完整版全局搜dynamicLevel即可查看代码演示
     */
    public static final String DYNAMIC_LEVEL = "dynamicLevel";

}
