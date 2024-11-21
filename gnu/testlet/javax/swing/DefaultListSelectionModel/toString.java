/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        harness.check(m.toString().endsWith(" ={}"));
        m.addSelectionInterval(3, 5);
        harness.check(m.toString().endsWith(" ={3, 4, 5}"));
        m.addSelectionInterval(7, 7);
        harness.check(m.toString().endsWith(" ={3, 4, 5, 7}"));
    }
}

