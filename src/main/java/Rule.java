public class Rule {

    public static void applyRule(RuleDescription rule, Triangle triangle) {
        switch (rule.getName()) {
            case "PERIMETER_BY_3SIDES": {
                triangle.setPerimeter(
                        triangle.getSide1().getLength() +
                        triangle.getSide2().getLength() +
                        triangle.getSide3().getLength()
                );
                triangle.setAsKnown(Element.PERIMETER);
            } break;
        }
    }

}
