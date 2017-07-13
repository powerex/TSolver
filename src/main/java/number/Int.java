package number;

import tex.TexObject;
import tex.ViewPdf;

import javax.swing.text.View;
import java.util.LinkedList;

public class Int implements TexObject {

    private int n;
    private LinkedList<Divider> factorization;

    public Int(int n) {
        this.n = n;
        factor();
    }

    public Int() {
        this(0);
    }

    public int getN() {
        return n;
    }

    private void factor() {
        factorization = new LinkedList<>();
        int t = this.n;
        int p = 2;
        while (t > 1) {
            int k = 0;
            while (t % p == 0) {
                t /= p;
                k++;
            }
            if (k > 0) {
                factorization.add(new Divider(p, k));
            }
            p++;
        }
    }

    public LinkedList<Divider> getFactorization() {
        return factorization;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }

    @Override
    public String toTexNotation() {
        StringBuilder sb = new StringBuilder();
        // if number equal to 0
        if (factorization.size() == 0)
            sb.append("0");
        else {
            int i = 0;
            for (;i<factorization.size()-1;i++) {
                sb.append(factorization.get(i).base);
                if (factorization.get(i).power > 1)
                    sb.append("^{").append(factorization.get(i).power).append("}");
                sb.append("\\cdot");
            }
            sb.append(factorization.get(i).base);
            if (factorization.get(i).power > 1)
                sb.append("^{").append(factorization.get(i).power).append("}");
        }
        return sb.toString();
    }

    public boolean isFullSquare() {
        boolean yes = true; // init like full square
        int i = 0;
        while (yes && i < factorization.size()) {
            yes &= factorization.get(i).power % 2 == 0;
            i++;
        }
        return yes;
    }

    public boolean hasSquare() {
        boolean yes = false; // init like full square
        int i = 0;
        while (!yes && i < factorization.size()) {
            yes |= factorization.get(i).power > 1;
            i++;
        }
        return yes;
    }

    public String separateSquare() {
        if (hasSquare()) {
            LinkedList<Divider> lost = new LinkedList<>();
            StringBuilder sb = new StringBuilder("(");
            boolean cdot = false;
            for (int i=0; i<factorization.size(); i++) {
                int t = factorization.get(i).power / 2;
                if (t > 0) {
                    if (cdot) sb.append("\\cdot");
                    sb.append(factorization.get(i).base);
                    if (t > 1)
                        sb.append("^{").append(t).append("}");
                    cdot = true;
                }
                t = factorization.get(i).power % 2;
                if (t > 0) {
                    lost.add(new Divider(factorization.get(i).base, t));
                }
            }
            sb.append(")^{2}");
            for (int i=0; i<lost.size(); i++) {
                sb.append("\\cdot").append(lost.get(i).base);
            }
            return sb.toString();
        }
        return toTexNotation();
    }

    @Override
    public String toTexSingle() {
        return null;
    }


    private class Divider {
        int base;
        int power;

        public Divider(int base, int power) {
            this.base = base;
            this.power = power;
        }
    }


    public static void main(String[] args) {
        Int x = new Int(6);

        String s = x.toString() + "=" + x.toTexNotation() + "=" + x.separateSquare();
        ViewPdf.texToPdf("testing.tex", s);

    }
}
