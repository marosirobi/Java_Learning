package model.GameChallenge.pirate;

import model.GameChallenge.Player;

import java.util.*;

public sealed abstract class Combatant implements Player permits Islander, Pirate, Soldier {

    private final String name;
    private final Map<String, Integer> gameData;
    private Weapon currentWeapon;

    public Combatant(String name) {
        this.name = name;
    }

    public Combatant(String name, Map<String, Integer> gameData) {
        this.name = name;
        if(gameData != null) {
            this.gameData.putAll(gameData);
        }
    }

    //-------------------
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0
        ));
    }

    @Override
    public String name() {
        return "";
    }

    public Weapon getCurrentWeapon(){
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    int value(String name){
        return gameData.get(name);
    }

    protected void setValue(String name, int value){
        gameData.put(name,value);
    }

    protected void adjustValue(String name, int adj){
        gameData.compute(name, (k,v) -> v += adj);
    }

    protected void adjustHealth(int adj){
        int health = value("health");
        health += adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
    }

    boolean useWeapon(Combatant opponent){
        System.out.println(name + " used the " + currentWeapon);
        if(new Random().nextBoolean()){
            System.out.println("***HIT");
            opponent.adjustHealth(-currentWeapon.getHitPoints());
            System.out.printf("%s's health =%d %s's health =%d%n",name,value("health"),
                    opponent.name(),opponent.value("health"));
            adjustValue("score", 50);
        }else{
            System.out.println("***MISS");
        }
        return opponent.value("health") < 0;
    }

    @Override
    public String toString() {
        return name;
    }

    public String information(){
        return name + " " + gameData;
    }
}
