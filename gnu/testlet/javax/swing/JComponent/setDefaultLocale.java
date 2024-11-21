/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.swing.JComponent;

public class setDefaultLocale
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale saved = JComponent.getDefaultLocale();
        JComponent.setDefaultLocale(Locale.CHINA);
        harness.check(JComponent.getDefaultLocale(), Locale.CHINA);
        JComponent.setDefaultLocale(null);
        harness.check(JComponent.getDefaultLocale(), Locale.getDefault());
        JComponent.setDefaultLocale(saved);
    }
}

