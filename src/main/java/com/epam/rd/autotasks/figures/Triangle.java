package com.epam.rd.autotasks.figures;

public class Triangle extends Figure {
    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c){
        if((a == null || b == null || c == null) || ((a.getX() == b.getX()  && a.getX() == c.getX()) || (a.getY() == b.getY() && a.getY() == c.getY())) || ((a.getX() == b.getX() && a.getY() == b.getY()) || (a.getX() == c.getX() && a.getY() == c.getY()) || (b.getX() == c.getX() && b.getY() == c.getY())))throw new IllegalArgumentException();
        this.a = a;
        this.a = b;
        this.a = c;
        if(area() == 0) throw new IllegalArgumentException();
    }

    public double area() {
        return (Math.abs((a.getX() - c.getX()) * (b.getY() - a.getY()) - (a.getX() - b.getX()) * (c.getY() - a.getY()))) / 2;
    }

    public Point centroid(){
        return new Point((a.getX() + b.getX() + c.getX())/3, (a.getY() + b.getY() + c.getY())/3);
    }

    public boolean isTheSame(Figure figure){
        if(figure instanceof Triangle){
            return ((delta(a.getX(), ((Triangle) figure).a.getX()) && delta(a.getY(), ((Triangle) figure).a.getY())) || (delta(a.getX(), ((Triangle) figure).b.getX()) && delta(a.getY(), ((Triangle) figure).b.getY())) || (delta(a.getX(), ((Triangle) figure).c.getX()) && delta(a.getY(), ((Triangle) figure).c.getY()))) && ((delta(b.getX(), ((Triangle) figure).a.getX()) && delta(b.getY(), ((Triangle) figure).a.getY())) || (delta(b.getX(), ((Triangle) figure).b.getX()) && delta(b.getY(), ((Triangle) figure).b.getY())) || (delta(b.getX(), ((Triangle) figure).c.getX()) && delta(b.getY(), ((Triangle) figure).c.getY()))) && ((delta(c.getX(), ((Triangle) figure).a.getX()) && delta(c.getY(), ((Triangle) figure).a.getY())) || (delta(c.getX(), ((Triangle) figure).b.getX()) && delta(c.getY(), ((Triangle) figure).b.getY())) || (delta(c.getX(), ((Triangle) figure).c.getX()) && delta(c.getY(), ((Triangle) figure).c.getY())));
        }
        return  false;
    }

    public static boolean delta(double value_1, double value_2){
        return Math.abs(value_1 - value_2) <= (Math.abs(value_1 - value_2) / Math.max(Math.abs(value_1), Math.abs(value_2)));
    }
}

//((a.getX() == ((Triangle) figure).a.getX() && a.getY() == ((Triangle) figure).a.getY()) || (a.getX() == ((Triangle) figure).b.getX() && a.getY() == ((Triangle) figure).b.getY()) || (a.getX() == ((Triangle) figure).c.getX() && a.getY() == ((Triangle) figure).c.getY())) && ((b.getX() == ((Triangle) figure).a.getX() && b.getY() == ((Triangle) figure).a.getY()) || (b.getX() == ((Triangle) figure).b.getX() && b.getY() == ((Triangle) figure).b.getY()) || (b.getX() == ((Triangle) figure).c.getX() && b.getY() == ((Triangle) figure).c.getY())) && ((c.getX() == ((Triangle) figure).a.getX() && c.getY() == ((Triangle) figure).a.getY()) || (c.getX() == ((Triangle) figure).b.getX() && c.getY() == ((Triangle) figure).b.getY()) || (c.getX() == ((Triangle) figure).c.getX() && c.getY() == ((Triangle) figure).c.getY()))
