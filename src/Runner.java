import entities.Dot;
import entities.Triangle;
import entities.actions.TriangleActions;

public class Runner {
    public static void main(String[] args) {
        Dot d1 = new Dot(-1, 4);
        Dot d2 = new Dot(-1, 2);
        Dot d3 = new Dot(-7, 3);
        Triangle triangle = new Triangle(d1, d2, d3);
        TriangleActions triangleActions = new TriangleActions();
        System.out.println(triangleActions.calculateArea(triangle));
        System.out.println(triangleActions.calculatePerimeter(triangle));
    }
}
