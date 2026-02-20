package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new SimpleAbility("Flame Breath", 25, "Burns enemies in front.", AbilityType.DAMAGE),
                new SimpleAbility("Fire Shield", 0, "Reduces incoming damage.", AbilityType.DEFENSE),
                new SimpleAbility("Meteor Storm", 45, "Ultimate: huge fire damage.", AbilityType.ULTIMATE)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new SimpleLootTable(
                List.of("Fire Gem", "Dragon Scale", "Flame Rune"),
                120,
                80
        );
    }

    @Override
    public String createAIBehavior() {
        return "AGGRESSIVE";
    }
}
