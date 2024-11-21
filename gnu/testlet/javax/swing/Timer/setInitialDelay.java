/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.Timer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class setInitialDelay
implements Testlet,
ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
    }

    @Override
    public void test(TestHarness harness) {
        Timer t = new Timer(100, this);
        t.setInitialDelay(123);
        harness.check(t.getInitialDelay(), 123);
        t.setInitialDelay(0);
        harness.check(t.getInitialDelay(), 0);
        boolean pass = false;
        try {
            t.setInitialDelay(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

