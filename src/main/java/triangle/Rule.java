package triangle;

public class Rule {

    public static void applyRule(String rule, Triangle triangle) {
        Rules rules = new Rules();
        RuleDescription r = rules.getRuleByName(rule);

        switch (rule) {
            case "PERIMETER_BY_3SIDES": {
                if (triangle.getElements().contains(r.getNeedToKnow())) {
                    triangle.setPerimeter(
                            triangle.getSide1().getLength() +
                            triangle.getSide2().getLength() +
                            triangle.getSide3().getLength()
                    );
                    triangle.setAsKnown(Element.PERIMETER);
                } else {
                    System.out.println("Not enought params");
                }
            } break;
        }
    }

}
