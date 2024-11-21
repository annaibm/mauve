/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DropTargetContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;

public class DropTargetContextTest
implements Testlet {
    Button b = new Button("button");
    DropTarget dt = new DropTarget(this.b, null);

    @Override
    public void test(TestHarness h) {
        DropTargetContext dtc = this.dt.getDropTargetContext();
        h.check(this.dt, dtc.getDropTarget());
        h.check(this.b, dtc.getComponent());
    }
}

