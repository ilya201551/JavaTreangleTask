package entities.actions;

import entities.Dot;
import entities.Triangle;

public class TriangleActions implements BaseTriangleActions{

    public double calculatePointsDistance(Dot dotA, Dot dotB) {
        double x1 = dotA.getX();
        double y1 = dotA.getY();
        double x2 = dotB.getX();
        double y2 = dotB.getY();
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    public double calculateHeight(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();

        double semiPerimeter = calculateSemiPerimeter(triangle);

        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);

        return 2 * Math.sqrt(semiPerimeter
                * (semiPerimeter - sideAB)
                * (semiPerimeter - sideBC)
                * (semiPerimeter - sideCA))
                /sideAB;
    }

    public double calculateSemiPerimeter(Triangle triangle) {
        return calculatePerimeter(triangle)/2;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();
        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);
        return sideAB + sideBC + sideCA;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        double height = calculateHeight(triangle);
        double sideAB = calculatePointsDistance(apexA, apexB);
        return 0.5 * sideAB * height;
    }
}
