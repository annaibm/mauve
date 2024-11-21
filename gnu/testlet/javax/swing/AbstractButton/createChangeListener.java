/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.AbstractButton.TestButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class createChangeListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestButton b = new TestButton();
        ChangeListener l = b.createChangeListener();
        b.repaintCalled = false;
        b.revalidateCalled = false;
        l.stateChanged(new ChangeEvent(b.getModel()));
        harness.check(b.repaintCalled, true);
        harness.check(b.revalidateCalled, false);
    }
}

