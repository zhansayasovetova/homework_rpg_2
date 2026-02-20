package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy implements Cloneable {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;

    protected List<Ability> abilities;
    protected LootTable lootTable;

    public Enemy(String name,
                 int health,
                 int damage,
                 int defense,
                 int speed,
                 List<Ability> abilities,
                 LootTable lootTable) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = new ArrayList<>(abilities);
        this.lootTable = lootTable;
    }

    // --- Getters ---

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<Ability> getAbilities() { return abilities; }
    public LootTable getLootTable() { return lootTable; }

    public void displayInfo() {
        System.out.println("Enemy: " + name);
        System.out.println("HP: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);

        System.out.println("Abilities:");
        for (Ability ability : abilities) {
            System.out.println("- " + ability.getName());
        }

        System.out.println("Loot: " + lootTable);
        System.out.println();
    }

    public void multiplyStats(double multiplier) {
        this.health = (int) (health * multiplier);
        this.damage = (int) (damage * multiplier);
        this.defense = (int) (defense * multiplier);
        this.speed  = (int) (speed  * multiplier);
    }


    @Override
    public Enemy clone() {
        try {
            Enemy copy = (Enemy) super.clone();

            copy.abilities = new ArrayList<>();
            for (Ability ability : this.abilities) {
                copy.abilities.add(ability.clone()); 
            }

            copy.lootTable = (this.lootTable == null) ? null : this.lootTable.clone();

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
