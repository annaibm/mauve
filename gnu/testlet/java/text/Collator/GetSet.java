/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.Collator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.Collator;
import java.util.Locale;

public class GetSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Collator col = Collator.getInstance(Locale.US);
        harness.check(col.getStrength(), 2, "default strength");
        harness.check(col.getDecomposition(), 0, "default decomposition");
        col.setStrength(0);
        harness.check(col.getStrength(), 0, "set/get strength");
        col.setDecomposition(0);
        harness.check(col.getDecomposition(), 0, "set/get decomposition");
        try {
            col.setStrength(999);
            harness.check(false, "invalid strength value");
        }
        catch (Exception e) {
            harness.check(true, "invalid strength value");
        }
        try {
            col.setDecomposition(999);
            harness.check(false, "invalid decomposition value");
        }
        catch (Exception e) {
            harness.check(true, "invalid decomposition value");
        }
        Collator col2 = (Collator)col.clone();
        col2.setStrength(1);
        harness.check(!col.equals(col2), "equals false");
        harness.check(col.equals(col), "equals true");
    }
}

