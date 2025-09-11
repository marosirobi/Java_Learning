package model.GameChallenge;

import java.util.Scanner;

public class GameConsole<T extends Game<? extends Player>> {

    private static final Scanner sc = new Scanner(System.in);
    private final T game;

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer(){
        System.out.println("Enter your playing name: ");
        String name = sc.nextLine();
        System.out.printf("Welcome to %s, %s!%n".formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex){

        boolean done = false;
        while (!done){
            var gameActions = game.getGameActions(playerIndex);
            System.out.println("Select from one of the following Actions: ");
            for(Character c : gameActions.keySet()){
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }
            System.out.print("Enter next Action: ");

            char nextMove = sc.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);

            if(gameAction != null){
                System.out.println("------------------------------------------------------");
                done = game.executeGameAction(playerIndex,gameAction);
                if(!done){
                    System.out.println("------------------------------------------------------");
                }
            }
        }
    }
}
