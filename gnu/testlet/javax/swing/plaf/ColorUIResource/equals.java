/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.ColorUIResource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.plaf.ColorUIResource;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ColorUIResource c1 = new ColorUIResource(Color.blue);
        ColorUIResource c2 = new ColorUIResource(Color.blue);
        harness.check(c1.equals(c2));
        harness.check(c2.equals(c1));
        harness.check(c1.equals(Color.blue));
    }
}

