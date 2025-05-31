public class CodingExercise {

    public static void main(String[] args) {

        System.out.println();

    }

    public static void checkNumber(int number){
        System.out.println(number > 0 ? "positive" : number < 0 ? "negative" : "zero" );
    }

    public static long toMilesPerHour(double kilometersPerHour){
        return kilometersPerHour < 0.0d ? -1 : Math.round(kilometersPerHour / 1.609d);
    }

    public static void printConversion(double kilometersPerHour){
        System.out.println(toMilesPerHour(kilometersPerHour) == -1 ? "Invalid Value" : kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        System.out.println(kiloBytes < 0 ? "Invalid Value" : kiloBytes + " KB = " + kiloBytes/1024 + " MB and " + kiloBytes % 1024 + " KB");
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay){
        return hourOfDay < 0 || hourOfDay > 23 ? false : barking == true && (hourOfDay > 22 || hourOfDay < 8) ? true : false;
    }

    public static boolean isLeapYear(int year){
        return year < 1 || year > 9999 ? false : year % 4 != 0 ? false : year % 100 != 0 ? true : year % 400 != 0 ? false : true;
    }

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2){
        return ((int)(num1 * 1000)) == ((int)(num2 * 1000)) ? true : false;
    }

    public static boolean hasEqualSum(int num1, int num2, int num3){
        return (num1 + num2) == num3 ? true : false;
    }

    public static boolean hasTeen(int num1, int num2, int num3){
        return isTeen(num1) ? true : isTeen(num2) ? true : isTeen(num3) ? true : false;
    }

    public static boolean isTeen(int num){
        return num <= 19 && num >= 13 ? true : false;
    }
}
