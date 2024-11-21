/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DropTarget;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.datatransfer.FlavorMap;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.dnd.DropTarget;
import java.util.TooManyListenersException;

public class Constructors
implements Testlet {
    TestHarness h;
    boolean caught = false;
    DropTarget dt;
    DropTarget oldDt;
    FlavorMap fm;
    Button b = new Button();

    @Override
    public void test(TestHarness harness) {
        this.h = harness;
        this.testNoParam();
        this.testTwoParams();
        this.testThreeParams();
        this.testFourParams();
        this.testFiveParams();
    }

    public void testNoParam() {
        this.oldDt = this.dt = new DropTarget();
        this.h.check(this.dt.getComponent() == null);
        this.h.check(this.dt.getDefaultActions() == 3);
        try {
            this.dt.addDropTargetListener(null);
        }
        catch (TooManyListenersException tmle) {
            this.caught = true;
        }
        this.h.check(!this.caught);
        this.h.check(this.dt.isActive());
        this.fm = this.dt.getFlavorMap();
        this.h.check(this.fm != null);
        this.h.check(this.fm instanceof SystemFlavorMap);
        this.caught = false;
    }

    public void testTwoParams() {
        this.dt = new DropTarget(this.b, this.oldDt);
        this.h.check(this.dt.getComponent().equals(this.b));
        this.h.check(this.dt.getDefaultActions() == 3);
        try {
            this.dt.addDropTargetListener(this.dt);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        catch (TooManyListenersException tmle) {
            this.caught = false;
        }
        this.h.check(this.caught);
        this.caught = false;
        try {
            this.dt.addDropTargetListener(this.oldDt);
        }
        catch (TooManyListenersException tmle) {
            this.caught = true;
        }
        this.h.check(this.caught);
        this.caught = false;
        this.h.check(this.dt.isActive());
        this.fm = this.dt.getFlavorMap();
        this.h.check(this.fm != null);
        this.h.check(this.fm instanceof SystemFlavorMap);
    }

    public void testThreeParams() {
        this.dt = new DropTarget(this.b, 3, this.oldDt);
        this.h.check(this.dt.getComponent().equals(this.b));
        this.h.check(this.dt.getDefaultActions() == 3);
        try {
            this.dt.addDropTargetListener(this.dt);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        catch (TooManyListenersException tmle) {
            this.caught = false;
        }
        this.h.check(this.caught);
        this.caught = false;
        try {
            this.dt.addDropTargetListener(this.oldDt);
        }
        catch (TooManyListenersException tmle) {
            this.caught = true;
        }
        this.h.check(this.caught);
        this.caught = false;
        this.h.check(this.dt.isActive());
        this.fm = this.dt.getFlavorMap();
        this.h.check(this.fm != null);
        this.h.check(this.fm instanceof SystemFlavorMap);
    }

    public void testFourParams() {
        this.dt = new DropTarget(this.b, 3, this.oldDt, false);
        this.h.check(this.dt.getComponent().equals(this.b));
        this.h.check(this.dt.getDefaultActions() == 3);
        try {
            this.dt.addDropTargetListener(this.dt);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        catch (TooManyListenersException tmle) {
            this.caught = false;
        }
        this.h.check(this.caught);
        this.caught = false;
        try {
            this.dt.addDropTargetListener(this.oldDt);
        }
        catch (TooManyListenersException tmle) {
            this.caught = true;
        }
        this.h.check(this.caught);
        this.caught = false;
        this.h.check(!this.dt.isActive());
        this.fm = this.dt.getFlavorMap();
        this.h.check(this.fm != null);
        this.h.check(this.fm instanceof SystemFlavorMap);
    }

    public void testFiveParams() {
        this.fm = SystemFlavorMap.getDefaultFlavorMap();
        this.dt = new DropTarget(this.b, 3, this.oldDt, false, this.fm);
        this.h.check(this.dt.getComponent().equals(this.b));
        this.h.check(this.dt.getDefaultActions() == 3);
        try {
            this.dt.addDropTargetListener(this.dt);
        }
        catch (IllegalArgumentException iae) {
            this.caught = true;
        }
        catch (TooManyListenersException tmle) {
            this.caught = false;
        }
        this.h.check(this.caught);
        this.caught = false;
        try {
            this.dt.addDropTargetListener(this.oldDt);
        }
        catch (TooManyListenersException tmle) {
            this.caught = true;
        }
        this.h.check(this.caught);
        this.caught = false;
        this.h.check(!this.dt.isActive());
        this.h.check(this.dt.getFlavorMap().equals(this.fm));
    }
}

