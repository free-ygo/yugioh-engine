package com.github.freeygo.engine;

public interface DuelEngine {


    /**
     * 设置引擎执行上下文。
     *
     * @param context 引擎执行上下文
     */
    void setContext(DuelContext context);


    /**
     * 获取引擎当前的执行上下文。
     *
     * @return 引擎执行上下文
     */
    DuelContext getContext();


    /**
     * 发送脚本给引擎执行，并返回指令的结果。
     *
     * @param script 脚本
     * @return 脚本返回结果
     */
    Object send(String script);


    /**
     * 使用指定的{@link DuelContext}作为执行环境执行指定的脚本。
     * @param script 脚本
     * @param context 执行环境上下文
     * @return 脚本返回的结果
     */
    Object send(String script, DuelContext context);

}
