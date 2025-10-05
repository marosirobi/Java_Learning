package diceGame;

import java.util.*;

public class DiceGame {

    private static Random rand = new Random();
    private static Scanner sc = new Scanner(System.in);
    private int[] dices;

    public DiceGame() {
    }

    public void playGame(){
        dices = throwDices();

        boolean run = true;
        while(run){
            printActions(dices);
            String enteredLine = sc.nextLine();
            if(enteredLine.trim().equalsIgnoreCase("ALL")){
                dices = throwDices();
            } else if (enteredLine.isEmpty()) {
                run = false;
                System.out.println("End of challenge.");
            }else{
                int[] newDices = Arrays.copyOf(dices,5);
                boolean good =true;
                for(String s : enteredLine.split(" ")){
                    int faceValue = Integer.parseInt(s.trim());
                    if(faceValue > 0 && faceValue < 6){
                        newDices[faceValue-1] = throwSingleDice();
                    }else{
                        System.out.println("Wrong input, try again");
                        good = false;
                        break;
                    }
                }
                if(good) dices = newDices;
            }
        }


    }

    private static void printActions(int[] dices){
        System.out.println("your roll is:\n"
                + Arrays.toString(dices));

        System.out.print(
                """
                        Press Enter if you want to keep all the dice       -> [ENTER]
                        Type ALL to re throw all five dice                 -> [ALL]
                        Type the face values of dices you want to re throw -> [1-5]
                        Your choice: \s""");
    }

    private int[] throwDices(){
        return rand.ints(5,1,7)
                .toArray();
    }
    private int throwSingleDice(){
        return rand.nextInt(1,7);
    }
}
