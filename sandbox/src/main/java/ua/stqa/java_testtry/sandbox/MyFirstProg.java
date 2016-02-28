package ua.stqa.java_testtry.sandbox;

/**
 * Created by sikretSSD on 29.02.2016.
 */
public class MyFirstProg {
    public static void main(String[] args){
        hello("world");
        hello("user");
        hello("Anton");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со сторой " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4,6);

        System.out.println("Площадь прямоугольника со сторонам " + r.a + " и " + r.b + " = " + r.area());


        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);

        System.out.println("Расстояние между точками (" + p1.a + ", " + p1.b + ") и (" + p2.a + ", " + p2.b + ") = " + distance(p1,p2));

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.a - p2.a), 2) + Math.pow((p1.b - p2.b), 2));

    }
    public static void hello(String somebody) {
        System.out.println("hello, " + somebody + "!");

    }
}
