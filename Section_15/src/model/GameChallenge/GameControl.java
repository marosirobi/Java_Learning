package model.GameChallenge;

import java.util.Scanner;

public class GameControl {

    private Location startLocation;

    public GameControl() {
        this.startLocation = new Location("road");
    }

    public void startGame(){
        boolean run = true;
        while(run){
            System.out.println("You are " + startLocation.getDesc());
            System.out.println("From here you can go to:");
            startLocation.getNextPlaces().forEach((k,v) ->
                    System.out.printf("A %s to the %s (%s)%n",
                            v,
                            switch (k){
                                case "N" -> "North";
                                case "E" -> "East";
                                case "W" -> "West";
                                case "S" -> "South";
                                default -> throw new IllegalStateException("Unexpected value: " + k);
                            }, k)
            );
            System.out.println("Select your compass Direction (Q to quit)");
            Scanner sc = new Scanner(System.in);
            String direction = sc.nextLine();
            if(!direction.equals("Q"))
                startLocation = new Location(startLocation.getNextPlaces().get(direction));
            else{
                run = false;
            }
        }



    }
}
