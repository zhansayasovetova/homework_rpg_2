package com.narxoz.rpg.combat;

public interface Ability extends Cloneable {

    String getName();

    int getDamage();

    String getDescription();

    AbilityType getType(); // DAMAGE, BUFF, DEBUFF, DEFENSE, ULTIMATE

    Ability clone();

    default String displayLine() {
        return getName() + " [" + getType() + "] dmg=" + getDamage() + " — " + getDescription();
    }
}
