package bigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class BGMain {

    public static void main(String[] args) {
        double policyAmount = 100_000_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentage = 1.0 / beneficiaries;
        System.out.printf("%,.2f%n",policyAmount * percentageFloat);
        System.out.printf("%,.2f%n",policyAmount * percentage);

        double totalUsingFloat = policyAmount -
                ((policyAmount * percentageFloat) * beneficiaries);
        System.out.printf("totalUsingFloat: %,.2f%n",totalUsingFloat);

        double total = policyAmount -
                ((policyAmount * percentage) * beneficiaries);
        System.out.printf("total: %,.2f%n",total);

        String[] tests = {"15.456","8","10000.000001",".123"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i-> new BigDecimal(tests[i]));

        System.out.printf("%-14s %-15s %-8s %s%n","Value","Unscaled Value","Scale","Precision");

        for(var bd : bds){
            System.out.printf("%-15s %-15d %-8d %d %n", bd ,bd.unscaledValue(), bd.scale(), bd.precision());
        }

        double[] doubles = {15.456,8,10000.000001,.125};
        Arrays.setAll(bds, i-> BigDecimal.valueOf(doubles[i]));
        System.out.println("-------------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n","Value","Unscaled Value","Scale","Precision");

        for(var bd : bds){
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd ,bd.unscaledValue(), bd.scale(), bd.precision());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd ,bd.unscaledValue(), bd.scale(), bd.precision());
        }

        BigDecimal policyPayout = new BigDecimal("100000000.00");
        System.out.printf("%-15s %-15d %-8d %d %n",
                policyPayout ,policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision());

        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries),
                new MathContext(60,RoundingMode.UP));
        System.out.println(percent);

        BigDecimal checkAmount = policyPayout.multiply(percent);
        checkAmount = checkAmount.setScale(2, RoundingMode.HALF_UP);
        System.out.printf("%-15s %-15d %-8d %d %n",
                checkAmount ,checkAmount.unscaledValue(), checkAmount.scale(), checkAmount.precision());

        BigDecimal totalCheckAmount = checkAmount.multiply(
                BigDecimal.valueOf(beneficiaries));
        System.out.printf("Combined: %.2f%n", totalCheckAmount);
        System.out.println("Remaining = " + policyPayout.subtract(totalCheckAmount));

        System.out.printf("%-15s %-15d %-8d %d %n",
                totalCheckAmount ,totalCheckAmount.unscaledValue(), totalCheckAmount.scale(), totalCheckAmount.precision());
//        BigDecimal test1 = new BigDecimal("1.1111111122233333344445555");
//        BigDecimal test2 = BigDecimal.valueOf(1.1111111122233333344445555);
//        System.out.printf("%-30s %-30s %-8s %s%n","Value","Unscaled Value","Scale","Precision");
//        System.out.printf("%-30s %-30s %-8d %d %n", test1 ,test1.unscaledValue(), test1.scale(), test1.precision());
//
//        System.out.printf("%-30s %-30s %-8s %s%n","Value","Unscaled Value","Scale","Precision");
//        System.out.printf("%-30s %-30s %-8d %d %n", test2 ,test2.unscaledValue(), test2.scale(), test2.precision());




    }


}
