/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DragSource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.dnd.DragSource;

public class getDragThresholdTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(DragSource.getDragThreshold() == 8);
    }
}

