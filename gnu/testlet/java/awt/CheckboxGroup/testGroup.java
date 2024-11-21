/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CheckboxGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Robot;

public class testGroup
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Robot r = harness.createRobot();
        Frame frame = new Frame();
        Checkbox checkbox = new Checkbox("Checkbox");
        frame.add(checkbox);
        frame.setBounds(0, 0, 100, 100);
        harness.check(checkbox.getCheckboxGroup(), null);
        CheckboxGroup group = new CheckboxGroup();
        checkbox.setCheckboxGroup(group);
        harness.check(group, checkbox.getCheckboxGroup());
        frame.setVisible(true);
        r.waitForIdle();
        r.delay(1000);
        checkbox.setCheckboxGroup(null);
        r.delay(1000);
        harness.check(checkbox.getCheckboxGroup(), null);
    }
}

