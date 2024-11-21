/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SwingUtilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;

public class computeIntersection
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Rectangle dest = new Rectangle(1, 1, 3, 3);
        harness.checkPoint("No intersection");
        SwingUtilities.computeIntersection(0, 4, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(2, 4, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(4, 4, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(0, 0, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(2, 0, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(4, 0, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(0, 2, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(4, 2, 1, 1, dest);
        harness.check(dest.isEmpty());
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(2, 2, 0, 0, dest);
        harness.check(dest.isEmpty());
        harness.checkPoint("Intersection");
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(0, 3, 2, 2, dest);
        harness.check(dest, new Rectangle(1, 3, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(2, 3, 1, 2, dest);
        harness.check(dest, new Rectangle(2, 3, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(3, 3, 2, 2, dest);
        harness.check(dest, new Rectangle(3, 3, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(0, 0, 2, 2, dest);
        harness.check(dest, new Rectangle(1, 1, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(2, 0, 1, 2, dest);
        harness.check(dest, new Rectangle(2, 1, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(3, 0, 2, 2, dest);
        harness.check(dest, new Rectangle(3, 1, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(0, 2, 2, 1, dest);
        harness.check(dest, new Rectangle(1, 2, 1, 1));
        dest = new Rectangle(1, 1, 3, 3);
        SwingUtilities.computeIntersection(3, 2, 2, 1, dest);
        harness.check(dest, new Rectangle(3, 2, 1, 1));
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

