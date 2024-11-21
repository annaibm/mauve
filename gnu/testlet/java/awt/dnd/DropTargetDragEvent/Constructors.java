/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DropTargetDragEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;

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
            new DropTargetDragEvent(this.dtc, null, 1, 1);
        }
        catch (NullPointerException npe) {
            this.caught = true;
        }
        h.check(this.caught);
    }

    void testDropAction(TestHarness h) {
        this.caught = false;
        try {
            new DropTargetDragEvent(this.dtc, this.loc, 4, 1);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        h.check(this.caught);
    }

    void testSrcAction(TestHarness h) {
        this.caught = false;
        try {
            new DropTargetDragEvent(this.dtc, this.loc, 1, 4);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        h.check(this.caught);
    }

    void testNormal(TestHarness h) {
        this.caught = false;
        DropTargetDragEvent dtde = null;
        try {
            dtde = new DropTargetDragEvent(this.dtc, this.loc, 1, 1);
        }
        catch (Exception e) {
            this.caught = true;
        }
        h.check(!this.caught);
        h.check(dtde != null && dtde.getDropAction() == 1);
        h.check(dtde != null && dtde.getSourceActions() == 1);
        h.check(dtde != null && dtde.getLocation().equals(this.loc));
    }
}

