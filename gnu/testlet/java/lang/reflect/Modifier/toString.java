/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Modifier;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Modifier;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Modifier.toString(1), (Object)"public");
        harness.check(Modifier.toString(2), (Object)"private");
        harness.check(Modifier.toString(4), (Object)"protected");
        harness.check(Modifier.toString(8), (Object)"static");
        harness.check(Modifier.toString(16), (Object)"final");
        harness.check(Modifier.toString(32), (Object)"synchronized");
        harness.check(Modifier.toString(64), (Object)"volatile");
        harness.check(Modifier.toString(128), (Object)"transient");
        harness.check(Modifier.toString(256), (Object)"native");
        harness.check(Modifier.toString(512), (Object)"interface");
        harness.check(Modifier.toString(1024), (Object)"abstract");
        harness.check(Modifier.toString(514), (Object)"private interface");
        harness.check(Modifier.toString(1280), (Object)"abstract native");
    }
}

