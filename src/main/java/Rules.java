import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Rules {

    private LinkedList<RuleDescription> rules = new LinkedList<>();

    public Rules() {

        rules.add(
                new RuleDescription(
                   "PERIMETER_BY_3SIDES",
                    new HashSet<Element>(Arrays.asList(Element.SIDE1, Element.SIDE2, Element.SIDE3)),
                    Element.PERIMETER
                )
        );

    }
}
