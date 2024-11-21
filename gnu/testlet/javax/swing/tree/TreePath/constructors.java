/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.tree.TreePath;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("TreePath()");
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("TreePath(Object)");
        TreePath p = new TreePath("XYZ");
        harness.check(p.getPathCount(), 1);
        harness.check(p.getLastPathComponent(), (Object)"XYZ");
        harness.check(p.getParentPath(), null);
        harness.check(Arrays.equals(p.getPath(), new String[]{"XYZ"}));
        boolean pass = false;
        try {
            new TreePath(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("TreePath(Object[])");
        boolean pass = false;
        try {
            new TreePath(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("TreePath(Object[], int)");
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("TreePath(TreePath, Object)");
    }
}

