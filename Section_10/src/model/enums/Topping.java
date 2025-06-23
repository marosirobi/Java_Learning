package model.enums;

public enum Topping {
    MUSTARD,
    PICKLES,
    CHEDDAR,
    TOMATO,
    BACON;

    public double getPrice(){
        return switch (this){
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.5;
        };
    }
}
