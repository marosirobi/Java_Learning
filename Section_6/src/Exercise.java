public class Exercise {
    public static void main(String[] args) {

        System.out.println();

    }

    public static void printNumberInWord(int number){
        String num = switch (number){
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };
        System.out.println(num);
    }

    public static boolean isLeapYear(int year){
        boolean result = false;

        if( year > 9999 || year < 1)
            return result;

        return  result = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getDaysInMonth(int month, int year){
        if( year > 9999 || year < 1)
            return -1;

        return switch (month){
            case 1,3,5,7,8,10,12 -> 31;
            case 2 -> {
                if(isLeapYear(year))
                    yield 29;
                yield 28;
            }
            case 4,6,9,11 -> 30;
            default -> -1;
        };
    }

    public static boolean isOdd(int number){
        boolean result = false;
        if(number < 0)
            return result;
        return result = number % 2 != 0;
    }

    public static int sumOdd(int start, int end){
        if(start < 0 || end < 0)
            return -1;
        else if(start > end)
            return -1;

        int sum = 0;
        for(int i = start; i <= end; i++)
            if(isOdd(i))
                sum += i;
        return sum;
    }

    
}
