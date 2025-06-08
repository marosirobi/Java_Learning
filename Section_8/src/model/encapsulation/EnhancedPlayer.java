package model.encapsulation;

public class EnhancedPlayer {

    private String fullName;
    private int health;
    private String weapon;

    public EnhancedPlayer(String fullName) {
        this(fullName, 100, "Sword");
    }

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;
        if(health <= 0){
            this.health = 1;
        }else if(health > 100){
            this.health = 100;
        }else{
            this.health = health;
        }
        this.weapon = weapon;
    }

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
