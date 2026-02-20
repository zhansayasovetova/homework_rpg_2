package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new SimpleAbility("Shadow Strike", 22, "Fast hit from shadows.", AbilityType.DAMAGE),
                new SimpleAbility("Vanish", 0, "Escape into darkness.", AbilityType.DEFENSE),
                new SimpleAbility("Dark Nova", 40, "Ultimate: shadow burst damage.", AbilityType.ULTIMATE)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new SimpleLootTable(
                List.of("Shadow Gem", "Dark Essence", "Shadow Rune"),
                130,
                90
        );
    }

    @Override
    public String createAIBehavior() {
        return "TACTICAL";
    }
}
