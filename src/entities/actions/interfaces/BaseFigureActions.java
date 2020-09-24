package entities.actions.interfaces;

import entities.AbstractFigure;

public interface BaseFigureActions<T extends AbstractFigure> {
    public double calculatePerimeter(T figure);
    public double calculateArea(T figure);
}
