/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class nullValue
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("SimpleAttributeSet");
        SimpleAttributeSet sas = new SimpleAttributeSet();
        try {
            sas.addAttribute("key", null);
            h.fail("SimpleAttributeSet must not accept null value");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }
}

