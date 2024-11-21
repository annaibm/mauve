/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTree;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

public class isRowSelected
implements Testlet {
    boolean getPathForRowCalled;
    boolean isPathSelectedCalled;
    boolean modelIsRowSelectedCalled;

    @Override
    public void test(TestHarness harness) {
        this.testCallGetPathForRow(harness);
        this.testCallIsPathSelected(harness);
        this.testCallModelIsRowSelected(harness);
    }

    private void testCallGetPathForRow(TestHarness h) {
        h.checkPoint("testCallGetPathForRow");
        Object[] data = new Object[]{"Hello", "World"};
        TestTree t = new TestTree(data);
        this.getPathForRowCalled = false;
        t.isRowSelected(0);
        h.check(this.getPathForRowCalled, false);
    }

    private void testCallIsPathSelected(TestHarness h) {
        h.checkPoint("testCallIsPathSelected");
        Object[] data = new Object[]{"Hello", "World"};
        TestTree t = new TestTree(data);
        this.isPathSelectedCalled = false;
        t.isRowSelected(0);
        h.check(this.isPathSelectedCalled, false);
    }

    private void testCallModelIsRowSelected(TestHarness h) {
        h.checkPoint("testCallGetRowForPath");
        Object[] data = new Object[]{"Hello", "World"};
        TestTree t = new TestTree(data);
        t.setSelectionModel(new TestTreeSelectionModel());
        this.modelIsRowSelectedCalled = false;
        t.isRowSelected(0);
        h.check(this.modelIsRowSelectedCalled, true);
    }

    private class TestTreeSelectionModel
    extends DefaultTreeSelectionModel {
        private TestTreeSelectionModel() {
        }

        @Override
        public boolean isRowSelected(int r) {
            isRowSelected.this.modelIsRowSelectedCalled = true;
            return super.isRowSelected(r);
        }
    }

    private class TestTree
    extends JTree {
        public TestTree(Object[] data) {
            super(data);
        }

        @Override
        public TreePath getPathForRow(int r) {
            isRowSelected.this.getPathForRowCalled = true;
            return super.getPathForRow(r);
        }

        @Override
        public boolean isPathSelected(TreePath p) {
            isRowSelected.this.isPathSelectedCalled = true;
            return super.isPathSelected(p);
        }
    }
}

