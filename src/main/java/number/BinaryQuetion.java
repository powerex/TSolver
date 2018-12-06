package number;

import tex.TexObject;

public class BinaryQuetion implements TexObject {

    private Radical a;
    private Radical b;
    private Radical c;
    private Radical d;

    private Radical x1;
    private Radical x2;

    public BinaryQuetion(int a, int b, int c) {
        this(
                new Radical(1, a),
                new Radical(1, b),
                new Radical(1, c)
        );

        d = Radical.multiple(this.b, this.b);
        Radical tmp = Radical.multiple(this.a, this.c);
        tmp.multipleNumber(-4);
        d = Radical.add(d, tmp);

    }

    public BinaryQuetion(Radical a, Radical b, Radical c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Radical getA() {
        return a;
    }

    public void setA(Radical a) {
        this.a = a;
    }

    public Radical getB() {
        return b;
    }

    public void setB(Radical b) {
        this.b = b;
    }

    public Radical getC() {
        return c;
    }

    public void setC(Radical c) {
        this.c = c;
    }

    public Radical getX1() {
        return x1;
    }

    public void setX1(Radical x1) {
        this.x1 = x1;
    }

    public Radical getX2() {
        return x2;
    }

    public void setX2(Radical x2) {
        this.x2 = x2;
    }

    public Radical getD() {
        return d;
    }

    public Radical getRAdicalD() {
        return d.sqrt(d);
    }

    public void setD(Radical d) {
        this.d = d;
    }

    @Override
    public String toTexNotation() {
        return null;
    }

    @Override
    public String toTexSingle() {
        return "$" + a.toTexNotation() + "x^2+" + b.toTexNotation() + "x+" + c.toTexNotation() + "=0$";
    }
}
