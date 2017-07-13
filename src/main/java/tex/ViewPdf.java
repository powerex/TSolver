package tex;

import java.io.*;

public class ViewPdf {

    public static void texToPdf(String fileName, String textNotation) {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
            writer.write("\\documentclass{article}\n");
            writer.write("\\usepackage{tikz}\n");
            writer.write("\\begin{document}\n");

            writer.write("$");
            writer.write(textNotation);
            writer.write("$");

            writer.write("\n\\end{document}\n");
            writer.close();

            String command = "pdflatex " + fileName;
            RunCommand.run(command);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
