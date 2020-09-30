csc = {
    selectCard = function()
    end
}

thisCard = {}

effect = {
    e1 = function()
        if thisCard.successCall then
            thisCard.caller()
                    .cardPlace().grave().hand().extraDeck().deck().collect()
                    .selectCard(selectCardCondition)
                    .specialCall(cardSelectFunction)
                    .invalidEffect() -- 效果无效化
        end
    end,
    e2 = function()
        thisCard.isActive().setRoundEffect(roundNum, roundEffect) -- 设置回合效果
        thisCard.isActive().setFieldEffect(fieldEffect) -- 设置场地效果
        thisCard.whenCaller().doSomething()
        thisCard.whenSpecialCaller().doSomething()
        thisCard.callSuccess().enemyDo(enemyDo)
        thisCard.owner().point().add(-1)
    end,
    e3 = function()
    end
}