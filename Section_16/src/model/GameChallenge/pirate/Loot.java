package model.GameChallenge.pirate;

import java.util.*;

public enum Loot {

    GOLD_COINS(10),
    PEARL_NECKLACE(25),
    DIAMOND(40),
    MONEY(20),
    SILVER(15);

    private final int value;

    private Loot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Loot getRandomLoot(){
        return Loot.values()[(int)(new Random().nextInt(Loot.values().length))];
    }

    public static Set<Loot> getRandomSetLoot() {
        Set<Loot> set = new HashSet<>();
        for (int i = 0; i<Loot.values().length; i++) {
            set.add(Loot.values()[new Random().nextInt(Loot.values().length)]);
        }
        return set;
    }

    public static List<Feature> getFeatureList(){
        return new ArrayList<>(EnumSet.allOf(Feature.class));
    }
}
