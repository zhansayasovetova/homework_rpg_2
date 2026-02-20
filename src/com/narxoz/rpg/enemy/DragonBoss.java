package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class DragonBoss extends Enemy {

    private String element;
    private Map<Integer, Integer> phases;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name,
                      int health,
                      int damage,
                      int defense,
                      int speed,
                      String element,
                      List<Ability> abilities,
                      LootTable lootTable,
                      String aiBehavior,
                      boolean canFly,
                      boolean hasBreathAttack,
                      int wingspan) {

        super(name, health, damage, defense, speed, abilities, lootTable);

        this.element = element;
        this.phases = new LinkedHashMap<>();
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    public void addPhase(int phase, int hpThreshold) {
        phases.put(phase, hpThreshold);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Can Fly: " + canFly);
        System.out.println("Breath Attack: " + hasBreathAttack);
        System.out.println("Wingspan: " + wingspan);

        for (Map.Entry<Integer, Integer> e : phases.entrySet()) {
            System.out.println("Phase " + e.getKey()
                    + " at HP " + e.getValue());
        }
    }

    @Override
    public Enemy clone() {
        DragonBoss copy = (DragonBoss) super.clone();

        copy.phases = new LinkedHashMap<>(this.phases);
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;
        copy.canFly = this.canFly;
        copy.hasBreathAttack = this.hasBreathAttack;
        copy.wingspan = this.wingspan;

        return copy;
    }

    public void setElement(String element) {
        this.element = element;
    }


}
