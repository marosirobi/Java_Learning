package model.GameChallenge.pirate;
import model.GameChallenge.Player;

import java.util.*;

public record Town(String name, String island, int level,
                   Set<Loot> loot, Set<Feature> features, List<? extends Player> opponents) {

    public Town {
        loot = Loot.getRandomSetLoot();
        features = Feature.getRandomSetFeature();

        opponents = getOpponents(new Random().nextInt(2));
    }

    public Town(String name, String island, int level) {
        this(name, island, level, Set.of(), Set.of(), List.of());
    }

//    private List<Combatant> getOpponents(int size) {
//
//        List<Combatant> opponents = new ArrayList<>(List.of(
//                new Islander("Islander",Weapon.AXE),
//                new Soldier("Soldier of Godrick")
//        ));
//        if(size == 1) {
//            return List.of(opponents.get(new Random().nextInt(2)));
//        }
//        return opponents;
//    }
}
