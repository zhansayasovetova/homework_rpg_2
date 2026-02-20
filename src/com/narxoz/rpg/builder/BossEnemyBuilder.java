package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class BossEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;

    private int damage = 10;
    private int defense = 5;
    private int speed = 10;

    private String element = "NONE";
    private final List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    private String aiBehavior = "NEUTRAL";
    private boolean canFly = false;
    private boolean hasBreathAttack = false;
    private int wingspan = 10;

    private final Map<Integer, Integer> phases = new LinkedHashMap<>();


    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(Objects.requireNonNull(ability));
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.clear();
        this.abilities.addAll(Objects.requireNonNull(abilities));
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }


    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    @Override
    public Enemy build() {

        if (name == null || name.isBlank()) {
            throw new IllegalStateException("DragonBoss must have a name!");
        }
        if (health <= 0) {
            throw new IllegalStateException("DragonBoss must have health > 0!");
        }

        DragonBoss boss = new DragonBoss(
                name,
                health,
                damage,
                defense,
                speed,
                element,
                new ArrayList<>(abilities),
                lootTable,
                aiBehavior,
                canFly,
                hasBreathAttack,
                wingspan
        );


        if (phases.isEmpty()) {
            boss.addPhase(1, health);
            boss.addPhase(2, (int) (health * 0.6));
            boss.addPhase(3, (int) (health * 0.3));
        } else {
            for (Map.Entry<Integer, Integer> e : phases.entrySet()) {
                boss.addPhase(e.getKey(), e.getValue());
            }
        }

        return boss;
    }
}
