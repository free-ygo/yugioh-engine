package com.github.freeygo.engine;

import com.github.freeygo.engine.cardscript.Effective;

import java.util.List;

public interface Card {

//    int NORMAL_MONSTER = 1001;
//    int EFFECT_MONSTER = 1002;
//    int NORMAL_MAGIC = 1101;
//    int FAST_MAGIC = 1102;
//    int EQUIP_MAGIC = 1103;
//    int FIELD_MAGIC = 1104;
//    int RITUAL_MAGIC = 1105;
//    int CONTINUOUS_MAGIC = 1106;
//    int COUNTER_MAGIC = 1107;

    //    void setType(int type);
    int UNCOVER_ATTACK = 1201;
    int COVER_DEFENSE = 1202;
    int COVER_UP = 1203;


    CardType getCategory();

    Effective getEffective();

    void setEffective(Effective effective);

    int getRepresentation();

    void setRepresentation(int representation);

    List<Effective> getEffects();

    void setEffects(List<Effective> effects);

//    EffectSpeed getEffectSpeed();
//
//    void setEffectSpeed(EffectSpeed speed);


    enum CardType {
        MONSTER, MAGIC, TRAP
    }

}
