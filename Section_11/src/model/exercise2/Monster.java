package model.exercise2;

import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints,strength;

    public Monster(String name, int hitPoints, int strength){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        return List.of(new String[]{name, String.format("%d", hitPoints), String.format("%d", strength)});
    }

    @Override
    public void read(List<String> list) {
        if(!list.isEmpty() && list != null){
            name = list.get(0);
            hitPoints = Integer.parseInt(list.get(1));
            strength = Integer.parseInt(list.get(2));
        }
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', hitPoints=%d, strength=%d}",name,hitPoints,strength);
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

}
