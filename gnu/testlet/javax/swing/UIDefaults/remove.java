/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIDefaults;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIDefaults;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UIDefaults def = new UIDefaults();
        def.put("foo", "bar");
        def.put("foo2", "bar2");
        harness.check(def.get("foo"), "bar", "simple get");
        harness.check(def.get("foo2"), (Object)"bar2");
        try {
            def.put("foo", (Object)null);
            harness.check(def.get("foo"), null, "put null equals remove");
        }
        catch (NullPointerException e) {
            harness.fail("put with null gave NullPointerException");
        }
        harness.checkPoint("rest intact?");
        harness.check(def.get("foo2"), (Object)"bar2");
    }
}

