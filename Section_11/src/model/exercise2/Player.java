package model.exercise2;

import java.util.Arrays;
import java.util.List;

public class Player implements ISaveable{
    private String name, weapon;
    private int hitPoints, strength;

    public Player(String name, int hitPoints, int strength){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";

    }

    @Override
    public List<String> write() {
        return List.of(new String[]{name, String.format("%d", hitPoints), String.format("%d", strength),weapon});
    }

    @Override
    public void read(List<String> list) {
        if(list != null && !list.isEmpty()){
            name = list.get(0);
            hitPoints = Integer.parseInt(list.get(1));
            strength = Integer.parseInt(list.get(2));;
            weapon = list.get(3);
        }
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}",name,hitPoints,strength,weapon);
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


}
