/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JMenuItem;

public class getActionCommand
extends gnu.testlet.javax.swing.AbstractButton.getActionCommand
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.check(new JMenuItem("bla"), harness);
    }
}

