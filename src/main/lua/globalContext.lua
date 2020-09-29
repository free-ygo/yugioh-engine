-- 
-- Based on Lua 5.2
-- This file defines a lot of global variables.

-- Java Bindings variables.
__BINDINGS__ = {}
__GLOBAL__ = {}

if __BINDINGS__ then
    if __BINDINGS__.enemy then
        __GLOBAL__.enemy = __BINDINGS__.enemy
    else
        local enemy = {
            deck = {},
            dp = 8000,
        }
        --        __GLOBAL__.enemy = enemy
    end
end



function playCard(card, opration, cost)
    -- 触发效果
end

Card = { name = "", attack = 0, defend = 0, desc = "", type = "", attrbute = "", tags = {} }

function Card:new(card)
end

function Card:initialize()
end

function Card:effect()
end


Rectangle = { area = 0, length = 0, breadth = 0 }
function Rectangle:new(o, length, breadth)
    o = o or {}
    setmetatable(o, self)
    self.__index = self
    self.length = length or 0
    self.breadth = breadth or 0
    self.area = length * breadth
    return o
end

function Rectangle:printArea()
    print("fdfd", self.area)
end

r = Rectangel:new(nil, 10, 20)
print(r.length)