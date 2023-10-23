package com.solo.common.orm.core.converter;

import com.solo.common.orm.base.enums.BasicDict;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 字典转换工厂类
 * TODO 有待优化
 * @author 十一
 * @since 2023/10/09 17:46
 * 人生若只如初见，何事秋风悲画扇
 **/
public class DictConvertFactory implements ConverterFactory<Object, BasicDict> {

    private static final Map<Class, Converter> converterMap = new WeakHashMap<>();

    @Override
    public <T extends BasicDict> Converter<Object, T> getConverter(Class<T> targetType) {
        Converter result = converterMap.get(targetType);
        if(result == null) {
            result = new DictConverter<T>(targetType);
            converterMap.put(targetType, result);
        }
        return result;
    }

    /**
     * 字典转换类
     * @author 十一
     * @since 2023/10/09 17:47
     * 人生若只如初见，何事秋风悲画扇
     **/
    static class DictConverter<T extends BasicDict> implements Converter<String, T> {
        private final Map<String, T> enumMap = new HashMap<>();
        public DictConverter(Class<T> enumType) {
            T[] enums = enumType.getEnumConstants();
            for(T e : enums) {
                enumMap.put(e.getValue() + "", e);
            }
        }

        @Override
        public T convert(String source) {
            T result = enumMap.get(source);
            if(result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }

}
