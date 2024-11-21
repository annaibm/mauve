/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DragSource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.dnd.DragSource;

public class FlavourMapTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DragSource ds = new DragSource();
        h.check(ds.getFlavorMap() instanceof SystemFlavorMap);
    }
}

