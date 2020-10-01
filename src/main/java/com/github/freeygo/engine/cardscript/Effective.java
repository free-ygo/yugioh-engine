package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.Duel;

/**
 * @author 戴志勇
 */
public interface Effective {
    /*
    效果有效时间：
    发动回合
    发动回合至数回合内。
    发动卡片离场前

    效果发动时机
    效果生效时机

    卡片生命周期：
    卡组     -----> 手牌 --> 场地 -> 墓地
    效果生命周期：
    未发动 -> 发动 -> 生效 -> 失效
     */

    /**
     * 效果状态初始化。
     */
    void initEffect();

    /**
     * 效果是否可以发动。
     *
     * @return true，可以发动；false，不可以发动。
     */
    boolean isAvailable();

    /**
     * 发动效果
     *
     * @return 效果处理结果。
     */
    Object active(Event event);

    /**
     * 设置效果生效时间
     *
     * @param start 有效开始时间
     * @param end   有效结束时间
     */
    void setWorkTime(int start, int end);

    /**
     * 设置效果作用对象
     *
     * @param duel 效果生效对象
     */
    void setWorkObject(Object duel);


    /**
     * 效果状态：未发动，发动中，生效，失效。
     *
     * @return 效果状态
     */
    int getStatus();

    /**
     * 设置效果状态
     *
     * @param status 未发动，发动中，生效，失效。
     */
    void setStatus(int status);

    /**
     * 设置效果脚本
     *
     * @param script 效果脚本
     */
    void setScript(String script);

    void getScript();

    void setDuel(Duel duel);

    /**
     * 作为效果对象的时候。
     *
     * @param event 作为效果对象
     */
    void notifyEvent(Object event);

    /*
    如果这张卡片被送入墓地，对手的全部魔法卡和陷阱卡被破坏。

     */
}
