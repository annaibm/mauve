/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleContext;

public class isEqual
extends StyleContext
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        SimpleAttributeSet set1 = new SimpleAttributeSet();
        StyleContext.SmallAttributeSet set2 = this.createSmallAttributeSet(set1);
        try {
            set1.isEqual(null);
        }
        catch (NullPointerException npe) {
            caught = true;
        }
        harness.check(caught);
        caught = false;
        try {
            set2.isEqual(null);
        }
        catch (NullPointerException npe) {
            caught = true;
        }
        harness.check(caught);
        harness.check(set2.isEqual(set1));
        harness.check(set1.isEqual(set2));
    }
}

