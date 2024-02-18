<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Solo Admin v2024.1.1</h1>
<h4 align="center">基于 Jdk 21/Spring Boot 3.2/Spring Cloud 2023 & Alibaba/Sa token 和 Vue3/Element Plus 前后端分离的分布式微服务架构</h4>

## 平台简介

**Solo Admin**，是一款以开发者为中心，代码全部开源的快速开发平台，个人与企业可 100% 免费使用。平台宗旨：`优雅永不过时`。

- 平台采用前后端分离的模式，微服务版本前端(基于 [solo-ui](https://gitee.com/eleven-gentleman/solo-ui))。
- 后端基于 Jdk21、Spring Boot 3.2、Spring Cloud 2023、 Sa Token 的 RBAC **权限管理系统**
- 注册中心、配置中心选型Nacos，缓存使用Redis。
- orm框架选型Mybatis-Flex，数据库使用MySQL。理论上支持所有主流数据库，如Oracle、SQL Server、PostgreSQL、DB2、H2等。
- 代码生成器采用基于Velocity模板引擎的代码生成器，可生成Java、Vue、Html、Xml、Sql等代码。
- 前端界面采用Vue3、Element Plus等主流前端技术开发。
- 代码简洁，架构清晰，适合学习和直接项目中使用。

## 模块说明

~~~
com.solo     
├── solo-ui               // 前端框架 [80]
├── solo-nacos            // 注册、配置中心 [8488]
├── solo-gateway          // 网关服务 [8888]
├── solo-auth             // 认证中心 [9001]
├── solo-common           // 通用模块
│       └── solo-common-core                         // 核心模块
│       └── solo-common-excel                        // 导入导出 [easy excel]
│       └── solo-common-logger                       // 日志记录
│       └── solo-common-orm                          // orm模块 [mybatis-flex]
│       └── solo-common-redis                        // 缓存服务 [redis]
│       └── solo-common-rpc                          // 服务调用 [dubbo]
│       └── solo-common-satoken                      // 权限认证 [sa-token]
│       └── solo-common-security                     // 安全模块
├── solo-modules          // 业务模块
│       └── solo-access                              // 通道服务 [9101]
│       └── solo-system                              // 系统模块 [9201]
│       └── solo-codegen                             // 代码生成 [9301]
│       └── solo-job                                 // 定时任务 [9401]
├─
~~~

## 内置功能

| 功能    | 描述                              |
|-------|---------------------------------|
| 用户管理  | 用户是系统操作者，该功能主要完成系统用户配置          |
| 角色管理  | 角色菜单权限分配、设置角色按机构进行数据范围权限划分      |
| 菜单管理  | 配置系统菜单，操作权限，按钮权限标识等             |
| 部门管理  | 配置系统组织机构（公司、部门、小组），树结构展现支持数据权限  |
| 岗位管理  | 配置系统用户所属担任职务                    |
| 字典管理  | 对系统中经常使用的一些较为固定的数据进行维护          |
| 参数管理  | 对系统动态配置常用参数                     |
| 登录日志  | 记录系统用户的登录日志，包含登录异常              |
| 操作日志  | 记录系统用户执行操作的日志，如：添加用户、角色、菜单等     |
| 数据源管理 | 配置系统的数据库数据源，可设置多数据源             |
| 代码生成  | 生成包括 java、html、js、xml、sql 等各类代码 |

## 技术选型

| 项目        | Star                                             |
|-----------|--------------------------------------------------|
| Java      | jdk                                              |
| Spring全家桶 | Spring Boot 3.2 & Spring Cloud 2023              |
| api网关     | SpringCloud Gateway                              |
| 服务调用      | Dubbo                                            |
| 注册中心      | Nacos                                            |
| 配置中心      | Nacos                                            |
| 消息队列      | 暂定                                               |
| 安全框架      | SaToken                                          |
| orm       | mybatis-flex                                     |
| 数据库       | MySQL、Oravle、Sql Server H2等                      |
| 数据库连接池    | hikaricp                                         |
| 缓存服务      | redis                                            |
| 前端框架      | vue 3 & Vite & Element-Plus & TypeScript & Pinia |

## 系统演示

<table>
    <tr>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E7%99%BB%E5%BD%95.png"></td>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E5%8D%95%E8%A1%A8.png"></td>
    </tr>
    <tr>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E6%A0%91%E8%A1%A8.png"></td>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E6%A0%91%E8%A1%A82.png"></td>
    </tr>
    <tr>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E5%B7%A6%E6%A0%91%E5%8F%B3%E8%A1%A8.png"></td>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E5%9B%BD%E9%99%85%E5%8C%96.png"></td>
    </tr>
    <tr>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E4%B8%BB%E9%A2%98%E8%AE%BE%E7%BD%AE.png"></td>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E6%96%B0%E5%A2%9E.png"></td>
    </tr>
    <tr>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E9%A1%B6%E9%83%A8%E6%A8%A1%E5%BC%8F.png"></td>
        <td><img src="https://solo-admin.oss-cn-beijing.aliyuncs.com/%E6%B7%B7%E5%90%88%E6%A8%A1%E5%BC%8F.png"></td>
    </tr>
</table>