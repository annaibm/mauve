/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIDefaults;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIDefaults;

public class putDefaults
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UIDefaults def = new UIDefaults();
        def.putDefaults(new Object[]{"foo", "bar"});
        harness.check(def.get("foo"), "bar", "simple get");
        def.putDefaults(new Object[]{"foo", null});
        try {
            def.put("foo", (Object)null);
            Object val = def.get("foo");
            harness.check(val, null, "putDefaults null equals remove");
        }
        catch (NullPointerException e) {
            harness.fail("putDefaults with null gave NullPointerException");
        }
    }
}

