/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JMenu;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean fail = false;
        try {
            menu.remove(-1);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
    }

    public void test2(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean pass = false;
        try {
            menu.remove(0);
            pass = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(pass);
    }

    public void test3(TestHarness harness) {
        JMenu menu = new JMenu();
        boolean fail = false;
        try {
            menu.remove(1);
        }
        catch (Exception e) {
            fail = true;
        }
        harness.check(fail);
    }
}

