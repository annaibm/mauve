/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class getPathComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath(new Object[]{"X", "Y", "Z"});
        harness.check(p1.getPathComponent(0), (Object)"X");
        harness.check(p1.getPathComponent(1), (Object)"Y");
        harness.check(p1.getPathComponent(2), (Object)"Z");
        boolean pass = false;
        try {
            p1.getPathComponent(3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            p1.getPathComponent(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

