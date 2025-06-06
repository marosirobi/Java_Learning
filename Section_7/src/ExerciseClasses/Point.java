package ExerciseClasses;

public class Point {

    private int x,y;

    public Point(){

    }
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(){
        Point zero = new Point(0,0);
        return Math.sqrt( (zero.getX() - x) * (zero.getX() - x) + (zero.getY() - y) * (zero.getY() - y));
    }

    public double distance(Point point){
        return Math.sqrt( (point.getX() - x) * (point.getX() - x) + (point.getY() - y) * (point.getY() - y));
    }

    public double distance(int x,int y){
        return Math.sqrt( (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
    }
}
