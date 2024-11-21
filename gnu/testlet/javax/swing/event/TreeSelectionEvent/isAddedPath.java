/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.TreeSelectionEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

public class isAddedPath
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.checkMethod1(harness);
        this.checkMethod2(harness);
        this.checkMethod3(harness);
    }

    public void checkMethod1(TestHarness harness) {
        harness.checkPoint("()");
        DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
        TreePath p1 = new TreePath("A");
        TreeSelectionEvent tse = new TreeSelectionEvent((Object)m, p1, false, null, null);
        harness.check(tse.isAddedPath(), false);
    }

    public void checkMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
        TreePath p1A = new TreePath("A");
        TreePath p1B = new TreePath("AA");
        TreePath[] p1 = new TreePath[]{p1A, p1B};
        boolean[] b = new boolean[]{true, false};
        TreeSelectionEvent tse = new TreeSelectionEvent((Object)m, p1, b, null, null);
        harness.check(tse.isAddedPath(), true);
        harness.check(tse.isAddedPath(0), true);
        harness.check(tse.isAddedPath(1), false);
    }

    public void checkMethod3(TestHarness harness) {
        harness.checkPoint("(TreePath)");
        DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
        TreePath p1A = new TreePath("A");
        TreePath p1B = new TreePath("AA");
        TreePath[] p1 = new TreePath[]{p1A, p1B};
        boolean[] b = new boolean[]{true, false};
        TreeSelectionEvent tse = new TreeSelectionEvent((Object)m, p1, b, null, null);
        harness.check(tse.isAddedPath(p1A), true);
        harness.check(tse.isAddedPath(p1B), false);
        boolean pass = false;
        try {
            tse.isAddedPath(new TreePath("X"));
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            tse.isAddedPath(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

