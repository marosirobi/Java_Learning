public class Main {
    public static void main(String[] args) {
        //1.
        //ternary operators
        String makeOfCar = "Volkswagen";
        boolean isDomestic = makeOfCar == "Volkswagen" ? true : false;
        String s = isDomestic ? "This car is domestic" : "This car is not domestic";
        if(isDomestic)
           System.out.println(s);

        //2.
        double a = 20.0d;
        double b = 80.0d;
        double sum = (a + b) * 100.0d;
        System.out.println(sum);
        double remain = sum % 40.0d;
        System.out.println(remain);
        boolean isNoRemain = (remain == 0) ? true : false;
        System.out.println(isNoRemain);
        if(!isNoRemain)
            System.out.println("got some remainder");
    }
}