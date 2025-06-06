package ExerciseClasses;

public class Floor {

    private double width, length;

    public Floor(double width, double length) {
        if(width < 0)
            this.width = 0;
        else
            this.width = width;
        if(length < 0)
            this.length = 0;
        else
            this.length = length;
    }

//    public double getWidth() {
//        return width;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public void setWidth(double width) {
//        this.width = width;
//    }
//
//    public void setHeight(double height) {
//        this.height = height;
//    }

    public double getArea(){
        return width * length;
    }
}
