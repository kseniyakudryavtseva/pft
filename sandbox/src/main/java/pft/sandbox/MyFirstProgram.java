package pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args){
        Point p1 = new Point(0,3);
        Point p2 = new Point(2,6);
        System.out.println("Расстояние между двумя точками равно " + p1.distance(p2));
    }
}