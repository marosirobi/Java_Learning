package model.polymorphism;

public class Scifi extends Movie{
    public Scifi(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Something Alien",
                "More Alien",
                "Preadtors and aliens");

    }

    public void watchScifi(){
        System.out.println("Watching an Scifi!");
    }
}
