package entities;

import entities.exceptions.TriangleLogicException;

import java.util.Objects;

public class Triangle extends AbstractFigure{
    final private Dot apexA;
    final private Dot apexB;
    final private Dot apexC;

    public Triangle(Dot apexA, Dot apexB, Dot apexC) throws TriangleLogicException {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;

        double x1 = apexA.getX();
        double y1 = apexA.getY();
        double x2 = apexB.getX();
        double y2 = apexB.getY();
        double x3 = apexC.getX();
        double y3 = apexC.getY();

        if ((x1 == x2 && x1 == x3) || (y1 == y2 && y1 == y3)) {
            throw new TriangleLogicException("given dots do not form a triangle");
        }
    }

    public Dot getApexA() {
        return apexA;
    }

    public Dot getApexB() {
        return apexB;
    }

    public Dot getApexC() {
        return apexC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(apexA, triangle.apexA) &&
                Objects.equals(apexB, triangle.apexB) &&
                Objects.equals(apexC, triangle.apexC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apexA, apexB, apexC);
    }
}
