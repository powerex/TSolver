package triangle;

import java.util.HashSet;

public class Triangle {

    private Segment side1;
    private Segment side2;
    private Segment side3;

    private double perimeter = -1;

    private HashSet<Element> elements = new HashSet<>();

    public Triangle(double side1, double side2, double side3) {
        this.side1 = new Segment(side1, new Point2D('A'), new Point2D('B'));
        this.side2 = new Segment(side2, this.side1.getDot2(), new Point2D('C'));
        this.side3 = new Segment(side3, this.side2.getDot2(), this.side1.getDot1());

        elements.add(Element.SIDE1);
        elements.add(Element.SIDE2);
        elements.add(Element.SIDE3);

    }


    public void setSide1(Segment side1) {
        this.side1 = side1;
    }

    public void setSide2(Segment side2) {
        this.side2 = side2;
    }

    public void setSide3(Segment side3) {
        this.side3 = side3;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public Segment getSide1() {
        return side1;
    }

    public Segment getSide2() {
        return side2;
    }

    public Segment getSide3() {
        return side3;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public HashSet<Element> getElements() {
        return elements;
    }

    public void setAsKnown(Element element) {
        this.elements.add(element);
    }
}
