package ssad.ass5;

import java.util.HashMap;

class Flyweight {
    public static void main(String args[]) {
        Circle circle = (Circle)ShapeFactory.getCircle(Color.BLACK);
        circle.draw(2, 3);
        circle.export();
    } 
}

abstract class Shape {
    Color fillColor;
    Color borderColor;
    double borderThickness;
    double coordinateX;
    double coordinateY;

    public void draw(double X, double Y) {}
    public final void export() {
        System.out.println("Exporting...");
    }
}

// This object is chosen to be a flyweight object, since here we vary the circles with 
// different colors in order to save our memory. We store objects with the same color and type
class ShapeFactory {
    private static final HashMap shapesMap = new HashMap<>();

    public static Shape getCircle(Color color) {
        Circle circle = (Circle)shapesMap.get(color);

        if (circle == null) {
            circle = new Circle(2, Color.GREEN);
            shapesMap.put(color, circle);
            System.out.println("Creating a shapeType...");
        } else {
            System.out.println("Using already existing shapeType...");
        }

        return circle;
    }
}

class Rectangle extends Shape {
    double length;
    double height;

    public Rectangle(double l, double h, Color color) {
        this.length = l;
        this.height = h;
        this.fillColor = color;
    }

    @Override
    public void draw(double X, double Y) {
        System.out.println("Drawing a rectangle...");
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double r, Color color) {
        this.radius = r;
        this.fillColor = color;
    }

    @Override
    public void draw(double X, double Y) {
        System.out.println("Drawing a circle...");
    }
}

class Triangle extends Shape {
    double side1;
    double side2;
    double side3;

    public Triangle(double s1, double s2, double s3, Color color) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
        this.fillColor = color;
    }

    @Override
    public void draw(double X, double Y) {
        System.out.println("Drawing a triangle...");
    }
}

class Line extends Shape {
    double lineLength;

    public Line(double lineLength) {
        this.lineLength = lineLength;
    }

    @Override
    public void draw(double X, double Y) {
        System.out.println("Drawing a line...");
    }
}

enum Color {
    RED, 
    BLACK, 
    WHITE,
    YELLOW,
    PINK,
    BLUE,
    GREEN,
}
