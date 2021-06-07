package com.epam.rd.autotasks.figures;

public class Circle extends Figure {
    Point centre;
    double radius;

    public Circle (Point centre, double radius){
        if(centre == null || radius == 0 || radius < 0) throw new IllegalArgumentException();
        this.centre = centre;
        this.radius = radius;
        if(area() == 0) throw new IllegalArgumentException();
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public Point centroid(){
        return new Point(centre.getX(), centre.getY());
    }

    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle) {
            if (delta(centre.getX(), ((Circle) figure).centre.getX()) && delta(centre.getY(), ((Circle) figure).centre.getY()) && delta(radius, ((Circle) figure).radius)){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }

    public static boolean delta(double value_1, double value_2){
        if(Math.abs(value_1 - value_2) <= (Math.abs(value_1 - value_2)/Math.max(Math.abs(value_1), Math.abs(value_2)))){
            return true;
        }
        return false;
    }
}

//(centre.getX() == ((Circle) figure).centre.getX() && centre.getY() == ((Circle) figure).centre.getY()) && (radius == ((Circle) figure).radius)
