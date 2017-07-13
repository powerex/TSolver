package triangle;

import tex.TexObject;

public class Point2D implements TexObject {

    private double x;
    private double y;
    private char letter;
    private int index = -1;
    private Hat hat = null;

    public Point2D(double x, double y,  char letter, int index, Hat hat) {
        this.x = x;
        this.y = y;
        this.letter = Character.toUpperCase(letter);
        this.index = index;
        this.hat = hat;
    }

    public Point2D(double x, double y, char letter, int index) {
        this(x, y, letter, index, null);
    }

    public Point2D(double x, double y, char letter, Hat hat) {
        this(x, y, letter, -1, hat);
    }

    public Point2D(double x, double y, char letter) {
        this(x, y, letter, -1);
    }

    public Point2D(double x, double y) {
        this(x, y, 'A');
    }

    public Point2D(char letter) {
        this(0, 0, letter);
    }

    public Hat getHat() {
        return hat;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = Character.toUpperCase(letter);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toTexNotation() {
        StringBuilder builder = new StringBuilder("\\fill (" + x + "," + y + ") circle (1pt)");
        builder.append(" node[anchor=north]{$").append(getLetter());
        if (this.hat != null) {
            switch (this.hat) {
                case PRIME: builder.append("^{\\prime}"); break;
                case DBLPRIME: builder.append("^{\\prime\\prime}"); break;
            }
        }
        if (this.index != -1) {
            builder.append("_{" + this.index + "}");
        }
        builder.append("$};");
        return builder.toString();
    }

    @Override
    public String toTexSingle() {
        return null;
    }
}
