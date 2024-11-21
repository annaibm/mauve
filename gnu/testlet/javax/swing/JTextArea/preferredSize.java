/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextArea;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextArea;
import javax.swing.text.View;

public class preferredSize
implements Testlet {
    public static String markup = "Questions are <font size=\"+1\" color=\"blue\">a burden</font> to others,\nanswers <font size=\"+2\" color=\"red\">a prison</font> for oneself.";
    public static JTextArea ta2 = new JTextArea(markup);

    @Override
    public void test(TestHarness harness) {
        View view = ta2.getUI().getRootView(ta2);
        try {
            harness.check(view.getPreferredSpan(0) > view.getPreferredSpan(1));
            ta2.setText("");
            harness.check(preferredSize.ta2.getPreferredSize().width == 0);
            harness.check(view.getPreferredSpan(0) == 0.0f);
            ta2.setText("\n\n\n\n\n\n\n\n\n");
            harness.check(preferredSize.ta2.getPreferredSize().width == 0);
            harness.check(view.getPreferredSpan(0) == 0.0f);
            ta2.setLineWrap(true);
            ta2.setWrapStyleWord(true);
            harness.check(preferredSize.ta2.getPreferredSize().width == 0);
            harness.check(view.getPreferredSpan(0) == 0.0f);
            ta2.setText("");
            harness.check(preferredSize.ta2.getPreferredSize().width == 0);
            harness.check(view.getPreferredSpan(0) == 0.0f);
            ta2.setText("\n\n\n\n\n\n\n\n\n");
            harness.check(preferredSize.ta2.getPreferredSize().width == 0);
            harness.check(view.getPreferredSpan(0) == 0.0f);
        }
        catch (Exception e) {
            harness.debug(e);
        }
    }
}

