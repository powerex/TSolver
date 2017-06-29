import java.io.*;

public class CreateTex {

    Writer writer = null;

    public CreateTex(String name) throws FileNotFoundException, UnsupportedEncodingException {
        this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf-8"));
        try {
            writer.write("\\documentclass{article}\n");
            writer.write("\\begin{document}\n");
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
