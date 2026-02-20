package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BasicEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;

    private int damage = 10;
    private int defense = 5;
    private int speed = 10;

    private String element = "NONE";
    private final List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    private String aiBehavior = "NEUTRAL";

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
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public Enemy build() {

        if (name == null || name.isBlank()) {
            throw new IllegalStateException("BasicEnemy must have a name!");
        }
        if (health <= 0) {
            throw new IllegalStateException("BasicEnemy must have health > 0!");
        }

        return new BasicEnemy(
                name,
                health,
                damage,
                defense,
                speed,
                element,
                new ArrayList<>(abilities),
                lootTable,
                aiBehavior
        );
    }
}
