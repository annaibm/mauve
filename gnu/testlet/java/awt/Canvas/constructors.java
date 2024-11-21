/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas1 = new Canvas();
        harness.check(canvas1 != null);
    }
}

