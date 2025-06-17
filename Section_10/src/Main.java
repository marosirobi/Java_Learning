import java.lang.reflect.Array;
import java.util.ArrayList;

record GroceryItem(String name, String type, int count){

    public GroceryItem(String name){
        this(name, "DIARY",1);
    }
    @Override
    public String toString(){
        return String.format("%d %s in %s",count, name.toUpperCase(),type);
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(0,new GroceryItem("Yogurt"));
        groceryList.remove(1);
        System.out.println(groceryList.toString());


    }
}