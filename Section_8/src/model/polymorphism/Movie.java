package model.polymorphism;

public class Movie {
    private String title;

    public Movie(String title){
        this.title = title;
    }

    public void watchMovie(){
        String instanceMovie = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceMovie + " film");
    }

    public static Movie getMovie(String type, String title){
        return switch (type.toUpperCase().charAt(0)){
            case 'A' -> new Adventure(title);
            case 'S' -> new Scifi(title);
            case 'C' -> new Comedy(title);
            default -> new Movie(title);
        };
    }

}
