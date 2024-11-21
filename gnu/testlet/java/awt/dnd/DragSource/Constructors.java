/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DragSource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.HeadlessException;
import java.awt.dnd.DragSource;

public class Constructors
implements Testlet {
    @Override
    public void test(TestHarness h) {
        boolean caught = false;
        try {
            DragSource ds = new DragSource();
            h.check(!ds.equals(DragSource.getDefaultDragSource()));
        }
        catch (HeadlessException he) {
            caught = true;
        }
        h.check(!caught);
    }
}

