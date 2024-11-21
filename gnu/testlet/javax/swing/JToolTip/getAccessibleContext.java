/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolTip;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.swing.JToolTip;

public class getAccessibleContext
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JToolTip tt = new JToolTip();
        AccessibleContext att = tt.getAccessibleContext();
        harness.check(att.getAccessibleName(), null);
        harness.check(att.getAccessibleDescription(), null);
        harness.check(att.getAccessibleComponent(), att);
        harness.check(att.getAccessibleRole(), AccessibleRole.TOOL_TIP);
        tt.setTipText("XYZ");
        harness.check(att.getAccessibleDescription(), (Object)"XYZ");
        tt.setTipText(null);
        harness.check(att.getAccessibleDescription(), null);
        att.setAccessibleDescription("ABC");
        harness.check(att.getAccessibleDescription(), (Object)"ABC");
        harness.check(tt.getTipText(), null);
        tt.setTipText("DEF");
        harness.check(att.getAccessibleDescription(), (Object)"ABC");
        att.setAccessibleName("X");
        harness.check(att.getAccessibleName(), (Object)"X");
        AccessibleContext att2 = tt.getAccessibleContext();
        harness.check(att == att2);
    }
}

