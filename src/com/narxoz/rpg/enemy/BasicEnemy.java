package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class BasicEnemy extends Enemy {

    private String element;
    private String aiBehavior;

    public BasicEnemy(String name,
                      int health,
                      int damage,
                      int defense,
                      int speed,
                      String element,
                      List<Ability> abilities,
                      LootTable lootTable,
                      String aiBehavior) {

        super(name, health, damage, defense, speed, abilities, lootTable);
        this.element = element;
        this.aiBehavior = aiBehavior;
    }

    public String getElement() {
        return element;
    }
    public String getAiBehavior() {
        return aiBehavior;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println();
    }

    @Override
    public Enemy clone() {
        BasicEnemy copy = (BasicEnemy) super.clone();
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;
        return copy;
    }

    public void setElement(String element) {
        this.element = element;
    }
    public void setAIBehavior(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }


}

