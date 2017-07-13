package triangle;

import java.util.HashSet;

public class RuleDescription {

    private HashSet<Element> needToKnow;
    private Element canCalculate;

    public RuleDescription(HashSet<Element> needToKnow, Element canCalculate) {
        this.needToKnow = needToKnow;
        this.canCalculate = canCalculate;
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
