public class Main {
    public static void main(String[] args){
        // 1.
        int a = calculateScore(800,5,100,true);
        System.out.println("your final score was " + a);
        int b =calculateScore(10000,8,200 ,true);
        System.out.println("your final score was " + b);

        // procedure is a method that doesn't return a value. Void can be called a procedure.
        //void can return too


    }

    public static int calculateScore(int score, int levelCompleted, int bonus,boolean gameOver){

        int finalScore = score;

        if(gameOver){
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore;
        }

        return -1;
    }

}
