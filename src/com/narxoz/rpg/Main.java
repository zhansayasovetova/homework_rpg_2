package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;

import com.narxoz.rpg.combat.AbilityType;
import com.narxoz.rpg.combat.SimpleAbility;

import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;

import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;

import com.narxoz.rpg.prototype.EnemyRegistry;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");


        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("FIRE abilities: " + fireFactory.createAbilities());
        System.out.println("FIRE loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println("FIRE AI: " + fireFactory.createAIBehavior());
        System.out.println();

        System.out.println("ICE abilities: " + iceFactory.createAbilities());
        System.out.println("ICE loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println("ICE AI: " + iceFactory.createAIBehavior());
        System.out.println();

        System.out.println("SHADOW abilities: " + shadowFactory.createAbilities());
        System.out.println("SHADOW loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("SHADOW AI: " + shadowFactory.createAIBehavior());
        System.out.println();




        EnemyDirector bossDirector = new EnemyDirector(new BossEnemyBuilder());
        Enemy dragon = bossDirector.createRaidBoss(fireFactory);
        System.out.println("Built Boss via Director + BossEnemyBuilder:");
        dragon.displayInfo();

        EnemyDirector basicDirector = new EnemyDirector(new BasicEnemyBuilder());
        Enemy minion = basicDirector.createMinion(iceFactory);
        System.out.println("Built Basic via Director + BasicEnemyBuilder:");
        minion.displayInfo();



        EnemyRegistry registry = new EnemyRegistry();

// Template 1: Goblin
        Goblin goblinTemplate = new Goblin("Goblin");
        goblinTemplate.addAbility(new SimpleAbility("Stab", 10, "Quick hit.", AbilityType.DAMAGE));
        registry.registerTemplate("goblin", goblinTemplate);

// Template 2: Dragon (use built dragon)
        registry.registerTemplate("dragon", dragon);

// Template 3: Skeleton (built by BasicEnemyBuilder)
        Enemy skeletonTemplate = new BasicEnemyBuilder()
                .setName("Skeleton")
                .setHealth(80)
                .setDamage(12)
                .setDefense(4)
                .setSpeed(15)
                .setAI("DEFENSIVE")
                .build();
        registry.registerTemplate("skeleton", skeletonTemplate);

        System.out.println("Registered templates: " + registry.listTemplates());
        System.out.println();


        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);

        Enemy championGoblin = registry.createFromTemplate("goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.getAbilities().add(
                new SimpleAbility("Poison Stab", 15, "Stab + poison.", AbilityType.DEBUFF)
        );


        System.out.println("Deep copy proof (Goblin):");
        System.out.println("Template abilities count: " + goblinTemplate.getAbilities().size());
        System.out.println("Champion abilities count: " + championGoblin.getAbilities().size());
        System.out.println();


        Enemy fireDragon = registry.createFromTemplate("dragon");
        ((DragonBoss) fireDragon).setElement("FIRE");

        Enemy iceDragon = registry.createFromTemplate("dragon");
        ((DragonBoss) iceDragon).setElement("ICE");

        Enemy shadowDragon = registry.createFromTemplate("dragon");
        ((DragonBoss) shadowDragon).setElement("SHADOW");


        Enemy eliteSkeleton = registry.createFromTemplate("skeleton");
        eliteSkeleton.multiplyStats(2.0);




        Enemy demonLord = new EnemyDirector(new BossEnemyBuilder()).createRaidBoss(shadowFactory);
        registry.registerTemplate("demon-lord", demonLord);

        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.multiplyStats(2.0);

        Enemy ancientDemon = registry.createFromTemplate("demon-lord");
        ancientDemon.multiplyStats(5.0);

        System.out.println("Demon Lord (base):");
        demonLord.displayInfo();

        System.out.println("Greater Demon (2x):");
        greaterDemon.displayInfo();

        System.out.println("Ancient Demon (5x):");
        ancientDemon.displayInfo();


        System.out.println("Abstract Factory: Fire/Ice/Shadow themed component families");
        System.out.println("Builder: Fluent construction + Director recipes");
        System.out.println("Factory Method: build() inside builders creates Enemy product");
        System.out.println("Prototype: EnemyRegistry cloning with deep copy");


        System.out.println("\n=== Demo Complete ===");
    }


}
