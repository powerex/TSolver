import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadicalTest {

    private Radical r;
    private Radical r2;

    @Before
    public void init() {
        r = new Radical(32);
        r2 = new Radical(20, 5);
    }

    @Test
    public void getRadical() throws Exception {
        assertEquals(2, r.getRadical());
        assertEquals(5, r2.getRadical());
    }

    @Test
    public void getMultiplier() throws Exception {
        assertEquals(4, r.getMultiplier());
        assertEquals(10, r2.getMultiplier());
    }

/*    @Test
    public void isNegative() {
        assertEquals(false, r.isNegative());
        assertEquals(false, r2.isNegative());
        assertEquals(true, new Radical(4, -2).isNegative());
    }*/

    @Test
    public void toTex() throws Exception {
        assertEquals("$4\\sqrt{2}$", r.toTexSingle());
        assertEquals("$10\\sqrt{5}$", r2.toTexSingle());
        assertEquals("$0$", new Radical(0, 1).toTexSingle());
        assertEquals("$0$", new Radical(0, 0).toTexSingle());
        assertEquals("$0$", new Radical(1, 0).toTexSingle());
        assertEquals("$1$", new Radical(1, 1).toTexSingle());
        assertEquals("$\\sqrt{5}$", new Radical(5, 1).toTexSingle());
    }
}