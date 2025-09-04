package model.generic;

import model.finalMethods.ChildClass;

public class FinalMain {

    public static void main(String[] args) {
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("---------------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("---------------------------");
        child.recommendedMethod();

        System.out.println("------------------------------------------------------");

        parent.recommendedStatic();
        System.out.println("---------------------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("---------------------------");
        child.recommendedStatic();

        System.out.println("---------------------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        String xArgument = "This is all I got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument,16,zArgument);
        System.out.println("After method, xArgument: " + xArgument);
        System.out.println("After method, zArgument: " + zArgument);
    }

    private static void doXYZ(String x, int y, final StringBuilder z){
        final String c = x + y;
        System.out.println(c);
        x = c;
        z.append(y);
//        z = new StringBuilder("This is a nw reference");
    }
}
