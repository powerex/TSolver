package triangle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Rules {

    private HashMap<String, RuleDescription> rules = new HashMap<>();

    public Rules() {

        rules.put("PERIMETER_BY_3SIDES",
                new RuleDescription(
                    new HashSet<>(Arrays.asList(Element.SIDE1, Element.SIDE2, Element.SIDE3)),
                    Element.PERIMETER
                )
        );

    }

    public RuleDescription getRuleByName(String ruleDescription) {
        return rules.get(ruleDescription);
    }

}
