/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.TreeSelectionEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

public class cloneWithSource
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTreeSelectionModel m1 = new DefaultTreeSelectionModel();
        DefaultTreeSelectionModel m2 = new DefaultTreeSelectionModel();
        TreePath p1 = new TreePath("A");
        TreePath p2 = new TreePath("B");
        TreePath p3 = new TreePath("C");
        TreeSelectionEvent tse1 = new TreeSelectionEvent((Object)m1, p1, true, p2, p3);
        TreeSelectionEvent tse2 = (TreeSelectionEvent)tse1.cloneWithSource(m2);
        harness.check(tse2.getSource(), m2);
        harness.check(tse2.getPath(), p1);
        harness.check(tse2.getPaths().length, 1);
        harness.check(tse2.getPaths()[0], p1);
        harness.check(tse2.isAddedPath());
        harness.check(tse2.getOldLeadSelectionPath(), p2);
        harness.check(tse2.getNewLeadSelectionPath(), p3);
        boolean pass = false;
        try {
            tse1.cloneWithSource(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

