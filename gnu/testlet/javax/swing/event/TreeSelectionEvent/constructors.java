/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.TreeSelectionEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.checkConstructor1(harness);
        this.checkConstructor2(harness);
    }

    public void checkConstructor1(TestHarness harness) {
        harness.checkPoint("(Object, TreePath, boolean, TreePath, TreePath)");
        DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
        TreePath p1 = new TreePath("A");
        TreePath p2 = new TreePath("B");
        TreePath p3 = new TreePath("C");
        TreeSelectionEvent tse = new TreeSelectionEvent((Object)m, p1, true, p2, p3);
        harness.check(tse.getSource(), m);
        harness.check(tse.getPath(), p1);
        harness.check(tse.getPaths().length, 1);
        harness.check(tse.getPaths()[0], p1);
        harness.check(tse.isAddedPath());
        harness.check(tse.getOldLeadSelectionPath(), p2);
        harness.check(tse.getNewLeadSelectionPath(), p3);
        boolean pass = false;
        try {
            tse = new TreeSelectionEvent(null, p1, true, p2, p3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        tse = new TreeSelectionEvent((Object)m, null, true, p2, p3);
        harness.check(tse.getPath(), null);
        harness.check(tse.getPaths().length, 1);
        harness.check(tse.getPaths()[0], null);
        tse = new TreeSelectionEvent((Object)m, p1, true, null, p3);
        harness.check(tse.getOldLeadSelectionPath(), null);
        tse = new TreeSelectionEvent((Object)m, p1, true, p2, null);
        harness.check(tse.getNewLeadSelectionPath(), null);
    }

    public void checkConstructor2(TestHarness harness) {
        harness.checkPoint("(Object, TreePath[], boolean[], TreePath, TreePath)");
        DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
        TreePath p1A = new TreePath("A");
        TreePath p1B = new TreePath("AA");
        TreePath[] p1 = new TreePath[]{p1A, p1B};
        TreePath p2 = new TreePath("B");
        TreePath p3 = new TreePath("C");
        boolean[] b = new boolean[]{true, false};
        TreeSelectionEvent tse = new TreeSelectionEvent((Object)m, p1, b, p2, p3);
        harness.check(tse.getSource(), m);
        harness.check(tse.getPath(), p1A);
        harness.check(tse.getPaths().length, 2);
        harness.check(tse.getPaths()[0], p1A);
        harness.check(tse.getPaths()[1], p1B);
        harness.check(tse.isAddedPath(), true);
        harness.check(tse.isAddedPath(0), true);
        harness.check(tse.isAddedPath(1), false);
        harness.check(tse.getOldLeadSelectionPath(), p2);
        harness.check(tse.getNewLeadSelectionPath(), p3);
        boolean pass = false;
        try {
            tse = new TreeSelectionEvent(null, p1, b, p2, p3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        tse = new TreeSelectionEvent((Object)m, null, b, p2, p3);
        pass = false;
        try {
            tse.getPath();
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            tse.getPaths();
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        tse = new TreeSelectionEvent((Object)m, p1, null, p2, p3);
        pass = false;
        try {
            tse.isAddedPath();
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            tse.isAddedPath(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        tse = new TreeSelectionEvent((Object)m, p1, b, null, p3);
        harness.check(tse.getOldLeadSelectionPath(), null);
        tse = new TreeSelectionEvent((Object)m, p1, b, p2, null);
        harness.check(tse.getNewLeadSelectionPath(), null);
    }
}

