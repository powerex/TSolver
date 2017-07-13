package number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntTest {

    @Test
    public void IntToString() {
        Int x = new Int();
        assertEquals("0", x.toString());
        assertEquals("0", x.toTexNotation());

        x = new Int(5);
        assertEquals("5", x.toString());
        assertEquals("5", x.toTexNotation());

        x = new Int(8);
        assertEquals("8", x.toString());
        assertEquals("2^{3}", x.toTexNotation());

        x = new Int(10);
        assertEquals("10", x.toString());
        assertEquals("2\\cdot5", x.toTexNotation());

        x = new Int(45);
        assertEquals("45", x.toString());
        assertEquals("3^{2}\\cdot5", x.toTexNotation());
    }

}
