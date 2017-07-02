public class Segment {

    private double length;
    private Point2D dot1;
    private Point2D dot2;

    public Segment(double length, Point2D dot1, Point2D dot2) {
        this.length = length;
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    public Segment(double length, char dot1, char dot2) {
        this(length, new Point2D(dot1), new Point2D(length, 0, dot2));
    }

    public Segment(Point2D dot1, Point2D dot2) {
        this.length = Math.sqrt(Math.pow((dot1.getX() - dot2.getX()),2) +
                                Math.pow((dot1.getY() - dot2.getY()),2));
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Point2D getDot1() {
        return dot1;
    }

    public void setDot1(Point2D dot1) {
        this.dot1 = dot1;
    }

    public Point2D getDot2() {
        return dot2;
    }

    public void setDot2(Point2D dot2) {
        this.dot2 = dot2;
    }
}
