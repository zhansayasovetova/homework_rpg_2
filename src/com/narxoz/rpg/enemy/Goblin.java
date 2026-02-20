package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.SimpleLootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Enemy {

    public Goblin(String name) {
        super(
                name,
                100,
                15,
                5,
                35,
                new ArrayList<>(),
                new SimpleLootTable(
                        List.of("Rusty Dagger", "Torn Cloth"),
                        10,
                        5
                )
        );
    }

    @Override
    public Enemy clone() {
        return super.clone();
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }
}
