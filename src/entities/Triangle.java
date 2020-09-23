package entities;

import java.util.Objects;

public class Triangle {
    private Dot apexA;
    private Dot apexB;
    private Dot apexC;

    public Triangle(Dot apexA, Dot apexB, Dot apexC) {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
    }

    public void setApexA(Dot apexA) {
        this.apexA = apexA;
    }

    public void setApexB(Dot apexB) {
        this.apexB = apexB;
    }

    public void setApexC(Dot apexC) {
        this.apexC = apexC;
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
