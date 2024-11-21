/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JLabel.MyJLabel;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJLabel label = new MyJLabel();
        harness.check(label.paramString().endsWith(",defaultIcon=,disabledIcon=,horizontalAlignment=LEADING,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER"));
    }
}

