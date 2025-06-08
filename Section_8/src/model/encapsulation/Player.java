package model.encapsulation;

public class Player {

    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        health = health -damage;
        if(health <= 0){
            System.out.println("Player dead");
        }
    }

    public int getHealth(){
        return health;
    }

    public void restoreHealth(int extraHealth){
        health += extraHealth;
        if(health > 100){
            System.out.println("Player restored all health");
            health = 100;
        }
    }
}
