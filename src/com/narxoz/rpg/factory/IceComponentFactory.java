package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new SimpleAbility("Frost Breath", 20, "Freezes and damages.", AbilityType.DAMAGE),
                new SimpleAbility("Ice Shield", 0, "Raises defense with ice armor.", AbilityType.DEFENSE),
                new SimpleAbility("Blizzard", 35, "Ultimate: damages and slows.", AbilityType.ULTIMATE)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new SimpleLootTable(
                List.of("Ice Gem", "Frost Scale", "Ice Rune"),
                110,
                85
        );
    }

    @Override
    public String createAIBehavior() {
        return "DEFENSIVE";
    }
}
