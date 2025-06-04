public class Main {
    public static void main(String[] args) {
        // 1.
//        int value = 2;
//        switch (value){
//            case 1:
//                System.out.println("value is 1");
//                break;
//            case 2:
//                System.out.println("value is 2");
//                break;
//            case 3: case 4: case 5:
//                System.out.println("value can be 3, 4 or 5");
//                System.out.println("value is actually " + value);
//                break;
//            default:
//                System.out.println("value is not 1, 2, 3, 4 or 5");
//                break;
//        }
        //2.
        int value = 2;
        switch (value) {
            case 1 -> System.out.println("value is 1");
            case 2 -> System.out.println("value is 2");
            case 3, 4, 5 -> {
                System.out.println("value can be 3, 4 or 5");
                System.out.println("value is actually " + value);
            }
            default -> System.out.println("value is not 1, 2, 3, 4 or 5");
        }
        // 3.
        String month = "JANUARY";
        System.out.println(getQuarter(month));

        // 4.
        //static and instance methods
        //Integer.parseInt("123"); vs "hello".toUpperCase();

        // 5.


    }

    public static String getQuarter(String month){
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" ->
                 "1st";

            case "APRIL", "MAY", "JUNE" ->
                 "2st";

            case "JULY", "AUGUST", "SEPTEMBER" ->
                 "3st";

            case "OCTOBER", "NOVEMBER", "DECEMBER" ->
                 "4st";
            default -> {
                String badResponse = month + " is bad";
                yield badResponse;
            }
        };
    }



}