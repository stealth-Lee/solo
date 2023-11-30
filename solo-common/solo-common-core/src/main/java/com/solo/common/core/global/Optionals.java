package com.solo.common.core.global;

import java.util.Objects;
import java.util.Optional;

/**
 * 响应信息主体工具类
 * @author Gentleman.Lee
 * @since 2023/11/17 10:08
 * 人生若只如初见，何事秋风悲画扇
 **/
public class Optionals<T> {

    private final R<T> original;

    private Optionals(R<T> original) {
        this.original = original;
    }

    /**
     * 之
     * @param value 响应对象
     * @return {@link Optionals}<{@link T}>
     */
    public static <T> Optionals<T> of(R<T> value) {
        return new Optionals<>(Objects.requireNonNull(value));
    }

    /**
     * 获取响应对象数据信息
     * @return {@link Optional}<{@link T}>
     */
    public Optional<T> getData() {
        return Optional.ofNullable(original.getData());
    }

}
