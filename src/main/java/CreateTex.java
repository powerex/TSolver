import number.BinaryQuetion;
import number.Radical;
import tex.RunCommand;
import triangle.Hat;
import triangle.Point2D;
import triangle.TexTriangle;

import java.io.*;

public class CreateTex {

    private Writer writer = null;

    public CreateTex(String name) throws FileNotFoundException, UnsupportedEncodingException {
        this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf-8"));
        try {
            writer.write("\\documentclass{article}\n");
            writer.write("\\usepackage{tikz}\n");
            writer.write("\\begin{document}\n");

/*            writer.write("\\begin{tikzpicture}\n");
            writer.write("\\draw (0,0) node[anchor=north]{$A$}\n");
            writer.write("-- (3,0) node[anchor=north]{$C$}\n");
            writer.write("-- (3,3) node[anchor=south]{$B$}\n");
            writer.write("-- cycle;\n");
            writer.write("\\end{tikzpicture}\n");*/

            /*TexTriangle t = new TexTriangle(
                    new Point2D(0,0, 'A'),
                    new Point2D(3,0, 'B', Hat.PRIME),
                    new Point2D(3,3, 'C', 2)
            );

            writer.write(t.toTexNotation());

            writer.write("\\newline\n");*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(String row) {
        if (writer != null) {
            try {
                writer.write(row + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new NullPointerException();
    }

    public void finishWrite() {
        if (writer != null) {
            try {
                writer.write("\\end{document}\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createPdf() {
        RunCommand.run("pdflatex text.tex");
    }

    public static void main(String[] args) {

        CreateTex ct = null;
        try {
            ct = new CreateTex("text.tex");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Radical r = new Radical(20, 5);
        BinaryQuetion bq = new BinaryQuetion(2,3,-4);

        ct.append(r.toTexSingle());
        ct.append("\\newline");
        ct.append(bq.toTexSingle());
        ct.append("\\newline");
        ct.append("D="+bq.getD().toTexSingle());
        ct.append("\\newline");

        ct.append("$\\sqrt{D}="+bq.getRAdicalD().toTexNotation()+"$");
        ct.finishWrite();
        ct.createPdf();


    }

}
