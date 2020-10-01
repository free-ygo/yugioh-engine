package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.DuelContext;

/**
 * while 玩家发动效果 {
 * 效果入栈
 * if 效果是可以连锁的 and 存在可发动和连锁的效果{
 * 通知玩家发动连锁
 * if 没有玩家发动连锁 {
 * 跳出循环
 * }
 * }
 * }
 * 计算栈中的效果
 * 计算方法：
 * 1. 取出效果A
 * 2. 执行效果A
 *
 * @author 戴志勇
 */
public interface CardScriptContext {
    /*
            while 玩家发动效果 {
            效果入栈
            if 效果是可以连锁的 and 存在可发动和连锁的效果{
                通知玩家发动连锁
                if 没有玩家发动连锁 {
                    跳出循环
                }
            }
        }
        计算栈中的效果
        计算方法：
            1. 取出效果A
            2. 执行效果A
    */

    /**
     * 获得本卡片脚本上下文环境的决斗上下文。
     *
     * @return 决斗上下文
     */
    DuelContext getDuelContext();

    /**
     * 设置卡片脚本上下文的决斗上下文
     *
     * @param context 决斗上下文
     */
    void setDuelContext(DuelContext context);

    /**
     * 卡片脚本调用接口
     *
     * @param cardId
     */
    void load(String cardId);

}
