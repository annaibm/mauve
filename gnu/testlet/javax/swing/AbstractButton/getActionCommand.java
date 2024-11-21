/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import javax.swing.AbstractButton;

public class getActionCommand {
    protected void check(AbstractButton ab, TestHarness harness) {
        harness.check(ab.getActionCommand(), (Object)"bla");
        ab.setText("foo");
        harness.check(ab.getActionCommand(), (Object)"foo");
        ab.setText(null);
        harness.check(ab.getActionCommand(), null);
        ab.setActionCommand("baz");
        harness.check(ab.getActionCommand(), (Object)"baz");
        ab.setText("bla");
        harness.check(ab.getActionCommand(), (Object)"baz");
        ab.setText(null);
        harness.check(ab.getActionCommand(), (Object)"baz");
        ab.setActionCommand(null);
        ab.setText("GNU");
        harness.check(ab.getActionCommand(), (Object)"GNU");
    }
}

