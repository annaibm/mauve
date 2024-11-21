/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolTip;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JToolTip;

public class getUIClassID
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JToolTip tt = new JToolTip();
        harness.check(tt.getUIClassID(), (Object)"ToolTipUI");
    }
}

