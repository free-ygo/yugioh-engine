package com.github.freeygo.engine;

public interface DuelContext {

    String MAX_ROUND = ""; // 最大对局数


    /**
     * 决斗环境上下文中的属性名为{@code name}的属性。
     *
     * @param name 属性名称
     * @param <T>  属性类型
     * @return 属性值
     */
    <T> T getAttribute(String name);


    /**
     * 为当前的执行上下文添加一个名为{@code name}，值为{@code value}的属性。
     *
     * @param name  属性名
     * @param value 属性值
     */
    void setAttribute(String name, Object value);


}
