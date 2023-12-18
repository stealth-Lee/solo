package com.solo.common.orm.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.mybatis.FlexConfiguration;
import com.mybatisflex.spring.boot.ConfigurationCustomizer;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import com.solo.common.core.base.entity.BasicEntity;
import com.solo.common.orm.listener.SoloFlexListener;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * mybatis-flex 配置类
 * @author 十一
 * @since 2023/09/08 14:26
 * 人生若只如初见，何事秋风悲画扇
 **/
@AutoConfiguration
public class SoloConfigurationCustomizer implements ConfigurationCustomizer, MyBatisFlexCustomizer {

    @Override
    public void customize(FlexConfiguration configuration) {
        // SQL打印到控制台
        configuration.setLogImpl(StdOutImpl.class);
    }

    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        flexGlobalConfig.registerInsertListener(new SoloFlexListener(), BasicEntity.class);
        flexGlobalConfig.registerUpdateListener(new SoloFlexListener(), BasicEntity.class);
    }

}
