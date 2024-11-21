/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultFormatter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.DefaultFormatter;

public class getValueClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefaultValue(harness);
    }

    private void testDefaultValue(TestHarness h) {
        h.checkPoint("defaultValue");
        DefaultFormatter f = new DefaultFormatter();
        h.check(f.getValueClass(), null);
    }
}

