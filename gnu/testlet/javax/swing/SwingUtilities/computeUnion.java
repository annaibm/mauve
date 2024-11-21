/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SwingUtilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;

public class computeUnion
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle dest = new Rectangle(1, 1, 3, 3);
        harness.checkPoint("No intersection");
        SwingUtilities.computeUnion(0, 4, 1, 1, dest);
        harness.check(dest, new Rectangle(0, 1, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(2, 4, 1, 1, dest);
        harness.check(dest, new Rectangle(1, 1, 3, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(4, 4, 1, 1, dest);
        harness.check(dest, new Rectangle(1, 1, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 0, 1, 1, dest);
        harness.check(dest, new Rectangle(0, 0, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(2, 0, 1, 1, dest);
        harness.check(dest, new Rectangle(1, 0, 3, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(4, 0, 1, 1, dest);
        harness.check(dest, new Rectangle(1, 0, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 2, 1, 1, dest);
        harness.check(dest, new Rectangle(0, 1, 4, 3));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(4, 2, 1, 1, dest);
        harness.check(dest, new Rectangle(1, 1, 4, 3));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(2, 2, 0, 0, dest);
        harness.check(dest, new Rectangle(1, 1, 3, 3));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 0, 0, 0, dest);
        harness.check(dest, new Rectangle(0, 0, 4, 4));
        harness.checkPoint("Intersection");
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 3, 2, 2, dest);
        harness.check(dest, new Rectangle(0, 1, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(2, 3, 1, 2, dest);
        harness.check(dest, new Rectangle(1, 1, 3, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(3, 3, 2, 2, dest);
        harness.check(dest, new Rectangle(1, 1, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 0, 2, 2, dest);
        harness.check(dest, new Rectangle(0, 0, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(2, 0, 1, 2, dest);
        harness.check(dest, new Rectangle(1, 0, 3, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(3, 0, 2, 2, dest);
        harness.check(dest, new Rectangle(1, 0, 4, 4));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 2, 2, 1, dest);
        harness.check(dest, new Rectangle(0, 1, 4, 3));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(3, 2, 2, 1, dest);
        harness.check(dest, new Rectangle(1, 1, 4, 3));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeUnion(0, 0, 4, 4, dest);
        harness.check(dest, new Rectangle(0, 0, 4, 4));
        harness.checkPoint("Null arguments");
        try {
            SwingUtilities.computeIntersection(1, 2, 3, 4, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

