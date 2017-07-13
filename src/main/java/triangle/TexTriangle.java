package triangle;

import tex.TexObject;

public class TexTriangle implements TexObject {

    private Point2D vertex1;
    private Point2D vertex2;
    private Point2D vertex3;

    TexTriangle(Point2D vertex1, Point2D vertex2, Point2D vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    @Override
    public String toTexNotation() {
        StringBuilder builder = new StringBuilder("\\begin{tikzpicture}\n");

        builder.append(vertex1.toTexNotation() + "\n")
               .append(vertex2.toTexNotation() + "\n")
               .append(vertex3.toTexNotation() + "\n");

        builder.append("\\draw (" + vertex1.getX() +"," + vertex1.getY() + ")\n");
        builder.append("-- (" + vertex2.getX() + "," + vertex2.getY() + ") \n");
        builder.append("-- (" + vertex3.getX() + "," + vertex3.getY() + ") \n");
        builder.append("-- cycle;\n");
        builder.append("\\end{tikzpicture}\n");

        return builder.toString();
    }

    @Override
    public String toTexSingle() {
        return null;
    }
}
