/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;

public class list
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.list();
        canvas.list(System.out);
        canvas.list(System.out, 0);
        canvas.list(System.out, 10);
    }
}

