package model.GameChallenge.pirate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Soldier extends Combatant {

    public Soldier(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}
