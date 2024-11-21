/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.BoxView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.plaf.TextUI;
import javax.swing.text.View;

public class spans
implements Testlet {
    public static String markup = "Questions are <font size=\"+1\" color=\"blue\">a burden</font> to others,\nanswers <font size=\"+2\" color=\"red\">a prison</font> for oneself.";
    public static JTextArea ta3 = new JTextArea(markup);

    @Override
    public void test(TestHarness harness) {
        ta3.setLineWrap(true);
        TextUI ui = ta3.getUI();
        View rootView = ui.getRootView(ta3);
        View view = rootView.getView(0);
        Dimension min2 = ta3.getMinimumSize();
        harness.check((double)min2.width, view.getMinimumSpan(0));
        harness.check((double)min2.height, view.getMinimumSpan(1));
        Dimension pref = ta3.getPreferredSize();
        harness.check((double)pref.width, view.getPreferredSpan(0));
        harness.check((double)pref.height, view.getPreferredSpan(1));
        harness.check(!min2.equals(pref));
        Dimension min3 = ta3.getMinimumSize();
        harness.check(!min3.equals(min2));
        harness.check(min3, pref);
        int width = pref.width;
        harness.check(width > 0);
        ta3.setText("");
        harness.check(width, spans.ta3.getPreferredSize().width);
        ta3.setText("\n\n\n\n\n\n\n");
        harness.check(width, spans.ta3.getPreferredSize().width);
    }
}

