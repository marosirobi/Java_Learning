package model.GameChallenge.pirate;

import java.util.*;

public enum Feature {
    ALLIGATOR(-40),
    PINEAPPLE(15),
    ZOMBIE(-30),
    LAVA(-10),
    MEAT(20),
    PIES(40);


    private final int adjValue;

    Feature(int adjValue) {
        this.adjValue = adjValue;
    }

    public int getAdjValue() {
        return adjValue;
    }
    public static Set<Feature> getRandomSetFeature() {
        Set<Feature> set = new HashSet<>();
        for (int i = 0; i<Feature.values().length; i++) {
            set.add(Feature.values()[new Random().nextInt(Feature.values().length)]);
        }
        return set;
    }

    public static List<Feature> getFeatureList() {
        return new ArrayList<>(EnumSet.allOf(Feature.class));
    }
}
