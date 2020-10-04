//package com.github.freeygo.engine;
//
///**
// * @author 戴志勇
// */
//public interface MonsterCard extends Card {
//
//    @Override
//    default Category getCategory() {
//        return Category.MONSTER;
//    }
//
//    String getDescription();
//
//    void setDescription(String description);
//
//    int getLevel();
//
//    void setLevel(int level);
//
//    int getAttack();
//
//    void setAttack(int attack);
//
//    int getDefense();
//
//    void setDefense(int defense);
//
//    Race getRace();
//
//    void setRace(Race race);
//
//    Type getType();
//
//    void setType(Type type);
//
//    Attribute getAttribute();
//
//    void setAttribute(Attribute attribute);
//
//    enum Race {
//        SPELLCASTER, DRAGON, ZOMBIE, WARRIOR, BEAST_WARRIOR, BEAST, WINGED_BEAST,
//        FIEND, FAIRY, INSECT, DINOSAUR, REPTILE, FISH, SEA_SERPENT, AQUA, PYRO,
//        THUNDER, ROCK, PLANT, MACHINE, PSYCHIC, DIVINE_BEAST, WYRM, CYBERSE
//    }
//
//    enum Type {
//        NORMAL, EFFECT, RITUAL, FUSION, SYNCHRO, XYZ, TOON, SPIRIT, UNION, GEMINI,
//        TUNER, FLIP, PENDULUM, LINK
//    }
//
//    enum Attribute {
//        DARK, LIGHT, EARTH, WATER, FIRE, WIND, DIVINE
//    }
//}
