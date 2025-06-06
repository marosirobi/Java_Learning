public class Dog  extends Animal{

    private String earShape;
    private String tailShape;

    public Dog(){
        super("Big","Mutt",50);
    }

    public Dog(String type, int weight){
        this(type,weight, "Perky", "curled");
    }


    public Dog( String type, int weight, String earShape, String tailShape) {
        super(weight < 15 ? "small" : weight > 35 ? "large" : "medium", type, weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "tailShape='" + tailShape + '\'' +
                ", earShape='" + earShape + '\'' +
                "} " + super.toString();
    }


    public void makeNoise() {
        if(type == "Wolf"){
            System.out.println("Ow Woooo!");
        }else
            bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
//        System.out.println("Dogs walk, run and wag their tail.");
        if(speed == "slow"){
            walk();
            wagTail();
        }else{
            run();
            bark();
        }
        System.out.println();
    }

    private void bark(){
        System.out.print("Woof! ");
    }
    private void run(){
        System.out.print("Dog running ");
    }
    private void walk(){
        System.out.print("Dog walking ");
    }
    private void wagTail(){
        System.out.print("Tail wagging ");
    }
}
