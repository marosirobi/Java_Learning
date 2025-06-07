public class StringMethods {
    public static void main(String[] args) {

        String birthDate = "26/11/1982";
        int startIndex = birthDate.indexOf("1982");
        System.out.println("startingIndex = " + startIndex);
        System.out.println("Birth year = " + birthDate.substring(startIndex));

        System.out.println("Month = " + birthDate.substring(3,5));

        String newDate = String.join("/","25","11","1972");
        System.out.println(newDate);

        System.out.println("ABC\n".repeat(3));

        System.out.println("ABC\n".repeat(3).indent(4));

        System.out.println("  ABC\n".repeat(3).indent(-2));

        //stringBuilder
        String helloWorld = "Hello" + "World";
        helloWorld.concat(" and goodbye");
        helloWorld = helloWorld.concat(" and goodbye");

        StringBuilder helloWorldBuilder =new StringBuilder("Hello" + "World");
        helloWorldBuilder.append(" and goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        StringBuilder builder =new StringBuilder();
        builder.append("a".repeat(35));

        StringBuilder builder32 =new StringBuilder(32);
        builder32.append("a".repeat(35));

        printInformation(builder);
        printInformation(builder32);


        StringBuilder builderPlus =new StringBuilder("Hello " + "World");
        builderPlus.append(" and Goodbye");
        builderPlus.deleteCharAt(16).insert(16,'g');

        builderPlus.replace(16,17,"G");

        builderPlus.reverse().setLength(7);

        printInformation(builderPlus);

    }

    public static void printInformation(String string){
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
        System.out.println();
    }

    public static void printInformation(StringBuilder builder){
        System.out.println("StringBuilder = " + builder);
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
        System.out.println();

    }
}
