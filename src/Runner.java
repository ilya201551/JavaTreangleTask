import entities.Dot;
import entities.Triangle;
import entities.actions.TriangleActions;
import entities.exceptions.TriangleLogicException;

public class Runner {
    public static void main(String[] args) {
        Dot d1 = new Dot(-1, 0);
        Dot d2 = new Dot(0, 2);
        Dot d3 = new Dot(5, 0);
        try {
            Triangle triangle = new Triangle(d1, d2, d3);
            TriangleActions triangleActions = new TriangleActions();
            System.out.println(triangleActions.calculateArea(triangle));
            System.out.println(triangleActions.calculatePerimeter(triangle));
            System.out.println(triangleActions.isEquilateralTriangle(triangle));
            System.out.println(triangleActions.isDotsDoTriangle(d1, d2, d3));
            System.out.println(triangleActions.isIsoscelesTriangle(triangle));
            System.out.println(triangleActions.isRightTriangle(triangle));
            System.out.println(triangleActions.isAcuteAngledTriangle(triangle));
            System.out.println(triangleActions.isObtuseTriangle(triangle));
        } catch (TriangleLogicException e) {
            System.out.println(e.toString());
        }
    }
}
