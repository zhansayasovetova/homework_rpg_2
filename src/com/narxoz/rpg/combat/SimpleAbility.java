package com.narxoz.rpg.combat;

import java.util.Objects;

public class SimpleAbility implements Ability {

    private final String name;
    private final int damage;
    private final String description;
    private final AbilityType type;

    public SimpleAbility(String name, int damage, String description, AbilityType type) {
        this.name = Objects.requireNonNull(name);
        this.damage = damage;
        this.description = Objects.requireNonNull(description);
        this.type = Objects.requireNonNull(type);
    }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return type; }

    @Override
    public Ability clone() {
        // fields are immutable -> new object = deep copy
        return new SimpleAbility(name, damage, description, type);
    }

    @Override
    public String toString() {
        return displayLine();
    }
}
