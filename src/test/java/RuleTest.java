import org.junit.Before;
import org.junit.Test;
import triangle.Rule;
import triangle.Rules;
import triangle.Triangle;

import static org.junit.Assert.assertEquals;

public class RuleTest {

    private Triangle t;
    private Rules r;

    @Before
    public void init() {
        t = new Triangle(3, 4, 5);
        r = new Rules();
    }

    @Test
    public void perimeter() {
        Rule.applyRule("PERIMETER_BY_3SIDES", t);
        assertEquals(12, t.getPerimeter());
    }

}
