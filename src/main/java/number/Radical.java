package number;

import org.jetbrains.annotations.NotNull;
import tex.TexObject;

public class Radical implements TexObject {

    private int radical_init;
    private int multiplier_init;
    private int radical;
    private int multiplier;

    public Radical() {
        this(0);
    }

    public Radical(int radical) {
        this(radical, 1);
    }

    public Radical(int radical, int multiplier) {
        this.radical_init = radical;
        this.multiplier_init = multiplier;

        this.multiplier = multiplier_init;
        this.radical = radical_init;

        int p = 2;
        while (p < this.radical) {
            int k = 0;
            while ( this.radical % p == 0 ) {
                this.radical /= 2;
                k++;
                if (k == 2) {
                    k = 0;
                    this.multiplier *= p;
                }
            }
            if (k > 0) this.radical *= p;
            p++;
        }
        if (this.radical == 0) {
            this.multiplier = 0;
        }
        if (this.multiplier == 0) {
            this.radical = 0;
        }
    }

    public void multipleNumber(int number) {
        this.multiplier *= number;
        this.multiplier_init *= number;
    }

    public Radical sqrt(Radical radical) throws IllegalArgumentException {
        if (radical.getRadical() == 0 || radical.getRadical() == 1) {
            return new Radical(this.multiplier, 1);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @NotNull
    public static Radical multiple(Radical left, Radical right) {
        int radical = left.getRadical() * right.getRadical();
        int multiplier = left.getMultiplier() * right.getMultiplier();
        return new Radical(radical, multiplier);
    }

    @NotNull
    public static Radical divide(Radical numerator, Radical denomionator) {
        int radical = numerator.getRadical() / denomionator.getRadical();
        int multiplier = numerator.getMultiplier() / denomionator.getMultiplier();
        return new Radical(radical, multiplier);
    }

    @NotNull
    public static Radical add(Radical left, Radical right) throws NoEqualsRadical {
        if (left.getRadical() != right.getRadical())
            throw new NoEqualsRadical();
        else {
            int radical = left.getRadical();
            int multiplier = left.getMultiplier() + right.getMultiplier();
            return new Radical(radical, multiplier);
        }
    }

    public double getValue() {
        return multiplier * Math.sqrt(radical);
    }

    public boolean isNegative() {
        return multiplier < 0;
    }

    public boolean equalZero() {
        return multiplier == 0 || radical == 0;
    }

    public boolean equalOne() {
        return multiplier == 1 && radical == 1;
    }

    @Override
    public String toTexSingle() {
        return "$" + toTexNotation() + "$";
    }

    @Override
    public String toTexNotation() {
        if (radical == 0 || multiplier == 0) {
            return "0";
        }
        if (radical == 1) {
            return ""+multiplier;
        }
        if (multiplier == 1) {
            return "\\sqrt{" + radical + "}";
        }
        return multiplier + "\\sqrt{" + radical + "}";
    }

    public int getRadical() {
        return radical;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public void setRadical(int radical) {
        this.radical = radical;
    }

    public static void main(String[] args) {
        Radical r = new Radical(20, 5);
        System.out.println(r.getMultiplier());
        System.out.println(r.getRadical());
    }
}
