import java.util.HashSet;

public class RuleDescription {

    private String name;
    private HashSet<Element> needToKnow;
    private Element canCalculate;

    public RuleDescription(String name, HashSet<Element> needToKnow, Element canCalculate) {
        this.name = name;
        this.needToKnow = needToKnow;
        this.canCalculate = canCalculate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Element> getNeedToKnow() {
        return needToKnow;
    }

    public void setNeedToKnow(HashSet<Element> needToKnow) {
        this.needToKnow = needToKnow;
    }

    public Element getCanCalculate() {
        return canCalculate;
    }

    public void setCanCalculate(Element canCalculate) {
        this.canCalculate = canCalculate;
    }
}
