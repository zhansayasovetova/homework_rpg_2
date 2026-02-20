package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleLootTable implements LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;

    public SimpleLootTable(List<String> items, int goldDrop, int experienceDrop) {
        this.items = new ArrayList<>(Objects.requireNonNull(items));
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items); // защита от изменения
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public String getLootInfo() {
        return "Items=" + items + ", Gold=" + goldDrop + ", XP=" + experienceDrop;
    }

    @Override
    public LootTable clone() {
        // deep copy: новый список items + новый объект
        return new SimpleLootTable(items, goldDrop, experienceDrop);
    }

    @Override
    public String toString() {
        return getLootInfo();
    }
}
