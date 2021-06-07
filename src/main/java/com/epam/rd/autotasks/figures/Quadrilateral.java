package com.epam.rd.autotasks.figures;

public class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if ((a == null || b == null || c == null || d == null)  || ((a.getX() == b.getX()  && a.getX() == c.getX()) || (a.getY() == b.getY() && a.getY() == c.getY())) || ((a.getX() == b.getX() && a.getY() == b.getY()) || (a.getX() == c.getX() && a.getY() == c.getY()) || (a.getX() == d.getX() && a.getY() == d.getY()) || (b.getX() == c.getX() && b.getY() == c.getY()) || (b.getX() == d.getX() && b.getY() == d.getY()) || (c.getX() == d.getX() && c.getY() == d.getY()))) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (area() == 0) {
            throw new IllegalArgumentException();
        } else if (!isConvex()) {
            throw new IllegalArgumentException();
        } else if ((((Math.abs((a.getX() - c.getX()) * (b.getY() - a.getY()) - (a.getX() - b.getX()) * (c.getY() - a.getY()))) / 2) == 0) || (((Math.abs((a.getX() - c.getX()) * (d.getY() - a.getY()) - (a.getX() - d.getX()) * (c.getY() - a.getY()))) / 2) == 0) || (((Math.abs((d.getX() - b.getX()) * (c.getY() - d.getY()) - (d.getX() - c.getX()) * (b.getY() - d.getY()))) / 2) == 0) || (((Math.abs((d.getX() - b.getX()) * (a.getY() - d.getY()) - (d.getX() - a.getX()) * (b.getY() - d.getY()))) / 2) == 0)){
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return ((Math.abs((a.getX() - c.getX()) * (b.getY() - a.getY()) - (a.getX() - b.getX()) * (c.getY() - a.getY()))) / 2) + ((Math.abs((a.getX() - c.getX()) * (d.getY() - a.getY()) - (a.getX() - d.getX()) * (c.getY() - a.getY()))) / 2);
    }

    public boolean isConvex() {
//      ac_diagonal
//      bd_diagonal
        double A1 = (a.getY() - c.getY()) / (a.getX() - c.getX());
        double A2 = (b.getY() - d.getY()) / (b.getX() - d.getX());
        double b1 = a.getY() - A1 * a.getX();
        double b2 = b.getY() - A2 * b.getX();
        double delta = (a.getX() - c.getX()) * (b.getY() - d.getY()) - (a.getY() - c.getY()) * (b.getX() - d.getX());

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);
        double Ya = A1 * Xa + b1;

        return delta != 0 && (Xa <= Math.max(a.getX(), c.getX())) && (Xa >= Math.min(a.getX(), c.getX())) && (Xa <= Math.max(b.getX(), d.getX())) && (Xa >= Math.min(b.getX(), d.getX()));
    }

    public Point centroid() {
        //      ac_diagonal
//      bd_diagonal
        double A1 = (a.getY() - c.getY()) / (a.getX() - c.getX());
        double A2 = (b.getY() - d.getY()) / (b.getX() - d.getX());
        double b1 = a.getY() - A1 * a.getX();
        double b2 = b.getY() - A2 * b.getX();
        double delta = (a.getX() - c.getX()) * (b.getY() - d.getY()) - (a.getY() - c.getY()) * (b.getX() - d.getX());

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);
        double Ya = A1 * Xa + b1;

        if (delta != 0 && (Xa <= Math.max(a.getX(), c.getX())) && (Xa >= Math.min(a.getX(), c.getX())) && (Xa <= Math.max(b.getX(), d.getX())) && (Xa >= Math.min(b.getX(), d.getX()))) {
            return new Point(Xa, Ya);
        } else {
            return null;
        }
    }

    public boolean isTheSame(Figure figure) {
        if (figure instanceof Quadrilateral) {
            return ((delta(a.getX(), ((Quadrilateral) figure).a.getX()) && delta(a.getY(), ((Quadrilateral) figure).a.getY())) || (delta(a.getX(), ((Quadrilateral) figure).b.getX()) && delta(a.getY(), ((Quadrilateral) figure).b.getY())) || (delta(a.getX(), ((Quadrilateral) figure).c.getX()) && delta(a.getY(), ((Quadrilateral) figure).c.getY())) || (delta(a.getX(), ((Quadrilateral) figure).d.getX()) && delta(a.getY(), ((Quadrilateral) figure).d.getY()))) && ((delta(b.getX(), ((Quadrilateral) figure).a.getX()) && delta(b.getY(), ((Quadrilateral) figure).a.getY())) || (delta(b.getX(), ((Quadrilateral) figure).b.getX()) && delta(b.getY(), ((Quadrilateral) figure).b.getY())) || (delta(b.getX(), ((Quadrilateral) figure).c.getX()) && delta(b.getY(), ((Quadrilateral) figure).c.getY())) || (delta(b.getX(), ((Quadrilateral) figure).d.getX()) && delta(b.getY(), ((Quadrilateral) figure).d.getY()))) && ((delta(c.getX(), ((Quadrilateral) figure).a.getX()) && delta(c.getY(), ((Quadrilateral) figure).a.getY())) || (delta(c.getX(), ((Quadrilateral) figure).b.getX()) && delta(c.getY(), ((Quadrilateral) figure).b.getY())) || (delta(c.getX(), ((Quadrilateral) figure).c.getX()) && delta(c.getY(), ((Quadrilateral) figure).c.getY())) || (delta(c.getX(), ((Quadrilateral) figure).d.getX()) && delta(c.getY(), ((Quadrilateral) figure).d.getY()))) && ((delta(d.getX(), ((Quadrilateral) figure).a.getX()) && delta(d.getY(), ((Quadrilateral) figure).a.getY())) || (delta(d.getX(), ((Quadrilateral) figure).b.getX()) && delta(d.getY(), ((Quadrilateral) figure).b.getY())) || (delta(d.getX(), ((Quadrilateral) figure).c.getX()) && delta(d.getY(), ((Quadrilateral) figure).c.getY())) || (delta(d.getX(), ((Quadrilateral) figure).d.getX()) && delta(d.getY(), ((Quadrilateral) figure).d.getY())));
        }
        return false;
    }

    public static boolean delta(double value_1, double value_2){
        if(value_1 ==0 && value_2 == 0 ){
            return true;
        }
        return Math.abs(value_1 - value_2) <= 0.0000000000000005;
    }
}

//(a == ((Quadrilateral) figure).a || a == ((Quadrilateral) figure).b || a == ((Quadrilateral) figure).c || a == ((Quadrilateral) figure).d)
