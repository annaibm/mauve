/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;

public class PR35482 {
    public void test(TestHarness harness) {
        harness.check("mbeanDescriptor".toLowerCase(), (Object)"mbeandescriptor");
    }
}

