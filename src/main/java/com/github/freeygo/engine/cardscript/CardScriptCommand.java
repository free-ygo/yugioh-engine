package com.github.freeygo.engine.cardscript;


import com.github.freeygo.engine.Card;
import com.github.freeygo.engine.DuelDisk;

/**
 * 获得对手
 */
public interface CardScriptCommand {


    void call();

    void initEffect();

    /*
    效果：
    1.1. 效果发动条件（时间、地点）
    1.3. 效果作用对象
    1.4. 效果作用范围
    1.5. 效果处理结果
    1.6. 效果处理优先级
    1.7. 效果生效时间
    2. 效果发动处理
    */

    void draw(DuelDisk duelDisk, int n);

    void normalSummon(Card card);

    void specialSummon(Card card);


}
