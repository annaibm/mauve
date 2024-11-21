/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DropTargetDropEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDropEvent;

public class Constructors
implements Testlet {
    Button b = new Button("button");
    DropTarget dt = new DropTarget(this.b, null);
    DropTargetContext dtc = this.dt.getDropTargetContext();
    Point loc = new Point();
    boolean caught;

    @Override
    public synchronized void test(TestHarness h) {
        this.testNullLoc(h);
        this.testDropAction(h);
        this.testSrcAction(h);
        this.testNormal(h);
    }

    void testNullLoc(TestHarness h) {
        this.caught = false;
        try {
            new DropTargetDropEvent(this.dtc, null, 1, 1, false);
        }
        catch (NullPointerException npe) {
            this.caught = true;
        }
        h.check(this.caught);
    }

    void testDropAction(TestHarness h) {
        this.caught = false;
        try {
            new DropTargetDropEvent(this.dtc, this.loc, 4, 1, false);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        h.check(this.caught);
    }

    void testSrcAction(TestHarness h) {
        this.caught = false;
        try {
            new DropTargetDropEvent(this.dtc, this.loc, 1, 4, false);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        h.check(this.caught);
    }

    void testNormal(TestHarness h) {
        this.caught = false;
        DropTargetDropEvent dtde = null;
        try {
            dtde = new DropTargetDropEvent(this.dtc, this.loc, 1, 1, true);
        }
        catch (Exception e) {
            this.caught = true;
        }
        h.check(!this.caught);
        h.check(dtde != null && dtde.getDropAction() == 1);
        h.check(dtde != null && dtde.getSourceActions() == 1);
        h.check(dtde != null && dtde.getLocation().equals(this.loc));
        h.check(dtde != null && dtde.isLocalTransfer());
    }
}

