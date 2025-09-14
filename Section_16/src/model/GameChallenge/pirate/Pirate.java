package model.GameChallenge.pirate;

import java.util.*;

public final class Pirate extends Combatant {

    private final List<Town> townsVisited = new LinkedList<Town>();
    private List<Loot> loot;
    private List<Feature> features;
    private List<Combatant> opponents;

    public Pirate(String name) {
        super(name, Map.of("level", 0, "townIndex", 0));
        visitTown();
    }

    boolean useWeapon(){
        int count = opponents.size();
        if(count > 0){
            int opponentIndex = count-1;
            if(count > 1){
                opponentIndex = new Random().nextInt(count);
            }
            Combatant combatant = opponents.get(opponentIndex);
            if(super.useWeapon(combatant)){
                opponents.remove(opponentIndex);
            }else{
                return combatant.useWeapon(this);
            }
        }
        return false;
    }

    boolean visitTown(){
        List<Town> levelTowns = PirateGame.getTowns(value("level"));
        if(levelTowns == null){
            return false;
        }
        Town town = levelTowns.get(value("townIndex"));
        if(town != null){
            townsVisited.add(town);
            loot =town.loot();
            features = town.features();
            opponents = town.opponents();
            return false;
        }
        return true;
    }

    public String information() {
        var current = ((LinkedList<Town>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).name());
        return "---> " + current +
                "\nPirate " + super.information() +
                "\n\ttownsVisited = " + Arrays.toString(simpleNames);
    }

    private boolean visitNextTown(){
        int townIndex = value("townIndex");
        List<Town> towns = PirateGame.getTowns(value("level"));

        if(towns == null) return true;
        if(townIndex >= (towns.size()-1)){
            System.out.println("Leveling up! Bonus: 500 points!");
            adjustValue("score",500);
            adjustValue("level", 1);
            adjustValue("townIndex",0);
        }else{
            System.out.println("Sailing to the next town! Bonus: 50 points!");
            adjustValue("score", 50);
            adjustValue("townIndex", 1);
        }
        return visitTown();
    }

    boolean hasExperiences(){
        return (features != null && features.size() > 0);
    }

    boolean hasOpponents(){
        return (opponents != null && opponents.size() > 0);
    }

    boolean findLoot(){
        if(loot.size()>0){
            Loot item = loot.remove(0);
            System.out.println("Found " + item + "!");
            adjustValue("score", item.getValue());
            System.out.println(name() + "'s score is now " + value("score"));
        }
        if(loot.size() == 0){
            return visitNextTown();
        }
        return false;
    }

    boolean experienceFeature(){
        if(features.size() > 0){
            Feature item = features.remove(0);
            System.out.println("Ran into " + item + "!");
            adjustHealth(item.getAdjValue());
            System.out.println(name() + "'s health is now " + value("health"));
        }
        return (value("health") <= 0);
    }
}
