public class CodingExercise {

    public static void main(String[] args) {

        System.out.println(581760%(60*24*365)/60/24 );

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

    public static double area(double radius)
    {
        return radius < 0 ? -1 : radius * radius * 3.14159265359;
    }

    public static double area(double x, double y)
    {
        return x < 0 ? -1 : y < 0 ? -1 : x * y;
    }

    public static void printYearsAndDays(long minutes){
        System.out.println(minutes < 0 ? "Invalid Value" : minutes + " min = " + minutes/(60*24*365) + " y and " + (minutes/(60*24*365) == 0 ? minutes/(60*24) : minutes%(60*24*365)/60/24)  + " d");
    }

    public static void printEqual(int num1,int num2,int num3){
        if(num1 < 0 || num2 < 0 || num3 < 0){
            System.out.println("Invalid Value");
            return;
        }else if(num1 == num2 && num1 == num3){
            System.out.println("All numbers are equal");
            return;
        }else if(num1 != num2 && num1 != num3 && num2 != num3){
            System.out.println("All numbers are different");
            return;
        }

        System.out.println("Neither all are equal or different");
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        if(summer){
            return temperature < 25 ? false : temperature > 45 ? false : true;
        }
        return temperature < 25 ? false : temperature > 35 ? false : true;
    }
}
