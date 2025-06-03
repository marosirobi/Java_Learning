public class Exercise {
    public static void main(String[] args) {

        printSquareStar(5);
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

    public static boolean isPalindrome(int number){
        if(number <= 9)
            return true;

        int num = number;
        String reverse = "";

        while(number > 1){
            reverse += number % 10;
            number = number / 10;
        }
        return num == Integer.parseInt(reverse);
    }

    public static int sumFirstAndLastDigit(int number){
        if(number < 0)
            return -1;
        int sum = number % 10;
        while(number > 9)
            number /= 10;
        return sum + number;
    }

    public static int getEvenDigitSum(int number){
        if(number < 0)
            return -1;

        int sum = 0;
        while(number > 9){
            sum += (number % 10) % 2 == 0 ? (number % 10) : 0;
            number /= 10;
        }
        return sum += (number % 10) % 2 == 0 ? (number % 10) : 0;
    }

    public static boolean hasSharedDigit(int num1, int num2){
        if(num1 > 99 || num1 < 10 || num2 > 99 || num2 < 10)
            return false;

        while(num1 > 9){
            int digit1 = num1 % 10;
            num1 /= 10;
            while(num2 > 9){
                int digit2 = num2 % 10;
                num2 /= 10;
                if(digit2 == digit1 || digit2 == num1 || num2 == num1 || num2 == digit1)
                    return true;
            }
        }
        return false;

    }

    public static boolean hasSameLastDigit(int num1,int num2,int num3){
        if(isValid(num1) && isValid(num2) && isValid(num3)){
            num1 %= 10;
            num2 %= 10;
            num3 %= 10;
            return num1 == num2 || num1 == num3 || num3 == num2;
        }
        return false;

    }

    public static boolean isValid(int number){
        return number <= 1000 && number >= 10;
    }

    public static void printFactors(int number){
        if(number < 1){
            System.out.println("Invalid Value");
            return;
        }
        for(int i = 1; i <= number/2; i++){
            if(number % i == 0)
                System.out.print(i + " ");
        }
        System.out.print(number);
    }

    public static int getGreatestCommonDivisor(int first, int second){
        if(first < 10 || second < 10)
            return -1;
        int max = first > second ? first : second;
        int i = max/2;
        while(i >= 2){
            if(first % i == 0 && second % i == 0)
                break;
            i--;
        }
        return i;
    }

    public static boolean isPerfectNumber(int number){
        if(number < 1)
            return false;
        int sum = 0;
        for (int i = 1; i <= number/2; i++) {
            if(number % i == 0)
                sum += i;
        }
        return sum == number;
    }

    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid Value");
            return;
        }
        int count = getDigitCount(number);
        number = reverse(number);
        int countReversed = getDigitCount(number);
        String numberToWords = "";
        int digit = 0;
        while(number > 9){
            digit = number % 10;
            number /= 10;
            switch (digit){
                case 1 -> numberToWords += "One ";
                case 2 -> numberToWords += "Two ";
                case 3 -> numberToWords += "Three ";
                case 4 -> numberToWords += "Four ";
                case 5 -> numberToWords += "Five ";
                case 6 -> numberToWords += "Six ";
                case 7 -> numberToWords += "Seven ";
                case 8 -> numberToWords += "Eight ";
                case 9 -> numberToWords += "Nine ";
                default -> numberToWords += "Zero ";
            }
        }
        switch (number){
            case 1 -> numberToWords += "One ";
            case 2 -> numberToWords += "Two ";
            case 3 -> numberToWords += "Three ";
            case 4 -> numberToWords += "Four ";
            case 5 -> numberToWords += "Five ";
            case 6 -> numberToWords += "Six ";
            case 7 -> numberToWords += "Seven ";
            case 8 -> numberToWords += "Eight ";
            case 9 -> numberToWords += "Nine ";
            default -> numberToWords += "Zero ";
        }
        if(count > countReversed)
            for (int i = 1; i <= count - countReversed; i++) {
                numberToWords += "Zero ";
            }
        System.out.println(numberToWords);
    }

    public static int reverse(int number){
        String reversed = "";
        if(number > 0){
            while(number > 9) {
                reversed += number % 10;
                number /= 10;
            }
            reversed += number;
            return Integer.parseInt(reversed);
        }

        number *= -1;
        while(number > 9) {
            reversed += number % 10;
            number /= 10;
        }
        reversed += number;
        return Integer.parseInt(reversed) * -1;
    }

    public static int getDigitCount(int number){
        if(number < 0)
            return -1;
        int sum = 0;
        while(number > 9){
            number /= 10;
            sum++;
        }
        sum++;
        return sum;
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){
        if(bigCount < 0 || smallCount < 0 || goal < 0)
            return false;

        int BIG = 5;
        int big_port = goal / BIG;

        if(bigCount > big_port)
            return (smallCount + big_port * BIG) >= goal;

        return (smallCount + bigCount * BIG) >= goal;
    }

    public static int getLargestPrime(int number){
        if(number < 0)
            return -1;

        int prime = -1;
        int isPrime = 0;
        for(int i = 2; i <= number; i++){
            for(int j = 2; j <= i; j++){
                if(i == j)
                    isPrime = j;
                if(i % j == 0)
                    break;
            }
            prime = number % isPrime == 0 ? isPrime : prime;
        }

        return prime;
    }

    public static void printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
            return;
        }

        for(int i = 1; i <= number; i++){
            if(i == 1 || i == number) {
                for (int j = 1; j <= number; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }else{
                for (int j = 1; j <= number; j++) {
                    if(j == 1 || j == number)
                        System.out.print("*");
                    else if(i == j)
                        System.out.print("*");
                    else if(j == (number - i)+1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }

        }
    }
}
