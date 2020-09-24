package entities.actions;

import entities.Dot;
import entities.Triangle;
import entities.actions.interfaces.BaseFigureActions;

import java.util.ArrayList;

public class TriangleActions implements BaseFigureActions<Triangle> {

    /**
     * @param num number;
     * @return number rounded to two decimal places.
     */
    private double round(double num) {
        return Math.round(num * 100.)/100.;
    }

    /**
     * @param dotA dot;
     * @param dotB dot;
     * @return distance between dots.
     */
    private double calculatePointsDistance(Dot dotA, Dot dotB) {
        double x1 = dotA.getX();
        double y1 = dotA.getY();
        double x2 = dotB.getX();
        double y2 = dotB.getY();
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    /**
     * @param triangle object;
     * @return height of triangle.
     */
    private double calculateHeight(Triangle triangle) {
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

    /**
     * @param triangle object;
     * @return semi-perimeter.
     */
    private double calculateSemiPerimeter(Triangle triangle) {
        return calculatePerimeter(triangle)/2;
    }

    /**
     * @param triangle object;
     * @return perimeter of a triangle.
     */
    public double calculatePerimeter(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();

        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);

        return sideAB + sideBC + sideCA;
    }

    /**
     * @param triangle object;
     * @return area of a triangle.
     */
    public double calculateArea(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        double height = calculateHeight(triangle);
        double sideAB = calculatePointsDistance(apexA, apexB);
        return 0.5 * sideAB * height;
    }

    /**
     * @param apexA triangle apex A;
     * @param apexB triangle apex B;
     * @param apexC triangle apex C;
     * @return true if dots form a triangle, else: return false.
     */
    public boolean isDotsDoTriangle(Dot apexA, Dot apexB, Dot apexC) {
        double x1 = apexA.getX();
        double y1 = apexA.getY();
        double x2 = apexB.getX();
        double y2 = apexB.getY();
        double x3 = apexC.getX();
        double y3 = apexC.getY();
        return !((x1 == x2 && x1 == x3) || (y1 == y2 && y1 == y3));
    }

    /**
     * @param triangle object;
     * @return true if triangle is right, else: return false.
     */
    public boolean isRightTriangle(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();

        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);

        double sqrSideAB = round(Math.pow(sideAB, 2));
        double sqrSideBC = round(Math.pow(sideBC, 2));
        double sqrSideCA = round(Math.pow(sideCA, 2));

        return sqrSideAB == (sqrSideBC + sqrSideCA) ||
                sqrSideBC == (sqrSideAB + sqrSideCA) ||
                sqrSideCA == (sqrSideAB + sqrSideBC);
    }

    /**
     * @param triangle object;
     * @return true if triangle is isosceles, else: return false.
     */
    public boolean isIsoscelesTriangle(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();

        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);

        return round(sideAB) == round(sideBC) ||
                round(sideAB) == round(sideCA) ||
                round(sideBC) == round(sideCA);
    }

    /**
     * @param triangle object;
     * @return true if triangle is equilateral, else: return false.
     */
    public boolean isEquilateralTriangle(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();

        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);
        return round(sideAB) == round(sideBC) && round(sideAB) == round(sideCA);
    }

    /**
     * @param triangle object;
     * @return true if triangle is acute-angled, else: return false.
     */
    public boolean isAcuteAngledTriangle(Triangle triangle) {
        Dot apexA = triangle.getApexA();
        Dot apexB = triangle.getApexB();
        Dot apexC = triangle.getApexC();

        double sideAB = calculatePointsDistance(apexA, apexB);
        double sideBC = calculatePointsDistance(apexB, apexC);
        double sideCA = calculatePointsDistance(apexC, apexA);

        double sqrSideAB = round(Math.pow(sideAB, 2));
        double sqrSideBC = round(Math.pow(sideBC, 2));
        double sqrSideCA = round(Math.pow(sideCA, 2));

        ArrayList<Double> sqrSidesArrayList = new ArrayList<>() {
            {
                add(sqrSideAB);
                add(sqrSideBC);
                add(sqrSideCA);
            }
        };
        double maxSqrSide = Math.max(sqrSideAB, Math.max(sqrSideBC, sqrSideCA));
        sqrSidesArrayList.remove(maxSqrSide);
        return maxSqrSide < (sqrSidesArrayList.get(0) + sqrSidesArrayList.get(1));
    }

    /**
     * @param triangle object;
     * @return true if triangle is obtuse, else: return false.
     */
    public boolean isObtuseTriangle(Triangle triangle) {
        return !isAcuteAngledTriangle(triangle);
    }
}
