package matrix;

import tex.TexObject;
import tex.ViewPdf;

import java.util.Random;

public class Matrix implements TexObject {

    int[][] a;
    private static Random gen;

    public Matrix(int[][] a) {
        this.a = a;
    }

    public Matrix(int m, int n) {
        gen = new Random();
        a = new int[m][n];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                a[i][j] = gen.nextInt(11)-5;
    }

    public void consoleWrite() {
        for (int i=0; i<a.length;i++){
            for (int j=0; j<a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(toTexNotation());
    }

    @Override
    public String toTexNotation() {
        StringBuilder sb = new StringBuilder("A = \\left(\\begin{array}{");
        for (int i=0; i<a[0].length; i++)
            sb.append('c');
        sb.append("}\n");
        for (int i=0; i<a.length-1;i++){
            for (int j=0; j<a[i].length-1; j++) {
                if (!(a[i][j] < 0))
                    sb.append("\\phantom{-}");
                sb.append(a[i][j]).append(" & ");
            }
            if (!(a[i][a[i].length-1] < 0))
                sb.append("\\phantom{-}");
            sb.append(a[i][a[i].length-1]).append("\\\\");
        }
        for (int j=0; j<a[a.length-1].length-1; j++) {
            if (!(a[a.length-1][j] < 0))
                sb.append("\\phantom{-}");
            sb.append(a[a.length-1][j]).append(" & ");
        }
        if (!(a[a.length-1][a[a.length-1].length-1] < 0))
            sb.append("\\phantom{-}");
        sb.append(a[a.length-1][a[a.length-1].length-1]).append("\n\\end{array}\\right)");
        return sb.toString();
    }

    @Override
    public String toTexSingle() {
        return "$" + toTexNotation() + "$";
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(3,4);
        m.consoleWrite();
        ViewPdf.texToPdf("testing.tex", m.toTexNotation());
    }
}
