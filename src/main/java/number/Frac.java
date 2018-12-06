package number;

import org.jetbrains.annotations.Nullable;
import tex.TexObject;

public class Frac implements TexObject {

    private int f;
    private int n;
    private int d;
    private int k;

    private int gcd(int a, int b) {
        if (b==0) {return a;}
        else {
            return gcd(b, a%b);
        }
    }

    public Frac() {
        this(0, 0, 1, 1);
    }

    public Frac(int f) {
        this(f, 0, 1, 1);
    }

    public Frac(int n, int d) {
        this(0, n, d, 1);
    }

    public Frac(int f, int n, int d) {
        this(f, n, d, 1);
    }

    public Frac(int f, int n, int d, int k) {
        this.f = f;
        this.n = n;
        this.d = d;
        this.k = k;
    }

    public int getF() {
        return f;
    }

    public int getN() {
        return n;
    }

    public int getD() {
        return d;
    }

    public int getK() {
        return k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frac frac = (Frac) o;

        if (f != frac.f) return false;
        if (n != frac.n) return false;
        if (d != frac.d) return false;
        return k == frac.k;
    }

    @Override
    public int hashCode() {
        int result = f;
        result = 31 * result + n;
        result = 31 * result + d;
        result = 31 * result + k;
        return result;
    }

    @Nullable
    public static Frac plus(Frac d1, Frac d2) {
        return null;
    }

    @Nullable
    public static Frac plus(Frac d1, int d2) {
        int _f = d1.getF()*d1.getK()*d1.getK();
        int _n = d1.getK()*d1.getN() + d2*d1.getD();
        Frac t = new Frac(_f,_n,d1.getD(),1);
        t.simplify();
        return t;
    }

    @Nullable
    public static Frac minus(Frac d1, Frac d2) {
        return null;
    }

    @Nullable
    public static Frac minus(Frac d1, int d2) {
        return null;
    }

    public int getInteger() {
        return 0;
    }

    public void simplify() {

    }

    @Nullable
    public Frac converse() {
        return null;
    }

    @Override
    public String toTexNotation() {
        return null;
    }

    @Override
    public String toTexSingle() {
        return null;
    }
}
