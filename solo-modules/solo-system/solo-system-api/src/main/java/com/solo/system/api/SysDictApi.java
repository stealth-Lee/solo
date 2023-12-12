package com.solo.system.api;

import com.solo.system.api.entity.SysDictData;

import java.util.List;

/**
 * 字典Api
 * @author 十一
 * @since 2023/12/08 13:52
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysDictApi {

    List<SysDictData> selectByCode(String code);

}
