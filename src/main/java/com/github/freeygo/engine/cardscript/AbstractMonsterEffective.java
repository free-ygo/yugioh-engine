package com.github.freeygo.engine.cardscript;

import com.github.freeygo.engine.MonsterCard;

import java.util.function.Predicate;

/**
 * @author 戴志勇
 */
public abstract class AbstractMonsterEffective<T, R> implements Effective<T, MonsterCard, R> {


    private RoundRange roundRange;

    private StageRange stageRange;

    private ActionScript script;

    private Predicate<T> condition;

    private EffectStatus status;

    private T target;

    private MonsterCard source;

    private EffectType effectType;

    private EffectSpeed effectSpeed;


    @Override
    public boolean isTarget(T t) {
        return t instanceof MonsterCard;
    }

    @Override
    public boolean isAvailable(T t) {
        return isTarget(t) && condition != null && condition.test((t));
    }

    @Override
    public R execute(T t) {
        return isAvailable(t) ? script.action() : null;
    }

    @Override
    public Predicate<T> getCondition() {
        return condition;
    }

    @Override
    public void setCondition(Predicate<T> condition) {
        this.condition = condition;
    }

    @Override
    public EffectStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(EffectStatus status) {
        this.status = status;
    }

    @Override
    public ActionScript getScript() {
        return script;
    }

    @Override
    public void setScript(ActionScript script) {
        this.script = script;
    }

    @Override
    public void notifyEvent(Object event) {

    }

    @Override
    public EffectSpeed getEffectSpeed() {
        return effectSpeed;
    }

    @Override
    public void setEffectSpeed(EffectSpeed speed) {
        this.effectSpeed = speed;
    }

    @Override
    public MonsterCard getSource() {
        return source;
    }

    @Override
    public void setSource(MonsterCard source) {
        this.source = source;
    }

    @Override
    public T getTarget() {
        return target;
    }

    @Override
    public void setTarget(T target) {
        this.target = target;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public void setCost(int cost) {

    }

    @Override
    public EffectType getEffectType() {
        return effectType;
    }

    @Override
    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }


    @Override
    public CommandType getCommandType() {
        return CommandType.NORMAL;
    }

    @Override
    public void setEffectiveRange(StageRange stageRange) {
        this.stageRange = stageRange;
    }

    @Override
    public StageRange getEffectiveStage() {
        return stageRange;
    }

    @Override
    public RoundRange getEffectRound() {
        return roundRange;
    }

    @Override
    public void setEffectRound(RoundRange range) {
        this.roundRange = range;
    }

}
