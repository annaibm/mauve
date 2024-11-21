/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SwingUtilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;

public class isRectangleContainingRectangle
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle r0 = new Rectangle(0, 0, 0, 0);
        Rectangle r1 = new Rectangle(0, 0, 1, 1);
        Rectangle r2 = new Rectangle(1, 1, 1, 1);
        Rectangle r3 = new Rectangle(-1, -1, 2, 2);
        harness.check(SwingUtilities.isRectangleContainingRectangle(r0, r0));
        harness.check(!SwingUtilities.isRectangleContainingRectangle(r0, r1));
        harness.check(SwingUtilities.isRectangleContainingRectangle(r1, r0));
        harness.check(SwingUtilities.isRectangleContainingRectangle(r1, r1));
        harness.check(!SwingUtilities.isRectangleContainingRectangle(r1, r2));
        harness.check(!SwingUtilities.isRectangleContainingRectangle(r2, r0));
        harness.check(!SwingUtilities.isRectangleContainingRectangle(r2, r1));
        harness.check(SwingUtilities.isRectangleContainingRectangle(r2, r2));
        harness.check(SwingUtilities.isRectangleContainingRectangle(r3, r0));
        harness.check(SwingUtilities.isRectangleContainingRectangle(r3, r1));
        harness.check(!SwingUtilities.isRectangleContainingRectangle(r3, r2));
        harness.checkPoint("Null arguments");
        try {
            SwingUtilities.isRectangleContainingRectangle(null, new Rectangle());
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            SwingUtilities.isRectangleContainingRectangle(new Rectangle(), null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

