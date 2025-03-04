abstract class Shape {
    abstract double rectangleArea(double length, double breadth);
    abstract double squareArea(double side);
    abstract double circleArea(double radius);
}

class Area extends Shape {
    @Override
    double rectangleArea(double length, double breadth) {
        return length * breadth;
    }

    @Override
    double squareArea(double side) {
        return side * side;
    }

    @Override
    double circleArea(double radius) {
        return Math.PI * radius * radius;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Area areaCalculator = new Area();
        
        double rectangleArea = areaCalculator.rectangleArea(5, 10);
        double squareArea = areaCalculator.squareArea(4);
        double circleArea = areaCalculator.circleArea(7);
        
        System.out.println("Area of Rectangle: " + rectangleArea);
        System.out.println("Area of Square: " + squareArea);
        System.out.println("Area of Circle: " + circleArea);
    }
}
