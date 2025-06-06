package ExerciseClasses;

public class SimpleCalculator {

    private double firstNumber, secondNumber;

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber(){
        return secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult(){
        return firstNumber + secondNumber;
    }
    public double getSubtractionResult(){
        return secondNumber - firstNumber;
    }
    public double getMultiplicationResult(){
        return secondNumber * firstNumber;
    }
    public double getDivisionResult(){
        if(secondNumber == 0) return 0;
        return firstNumber / secondNumber;
    }
}
