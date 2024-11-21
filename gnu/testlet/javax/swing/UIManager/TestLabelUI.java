/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.LabelUI;

public class TestLabelUI
extends LabelUI {
    static boolean installUICalled = false;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        installUICalled = true;
    }

    public static ComponentUI createUI(JComponent c) {
        return new TestLabelUI();
    }
}

