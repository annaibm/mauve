/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String name2 = "gnu.testlet.java.lang.Package";
        Package p = Package.getPackage(name2);
        if (p != null) {
            harness.check(name2, (Object)p.getName());
        } else {
            harness.debug("getPackage() returned null");
        }
        p = Package.getPackage("java.lang");
        harness.check(p != null, "checking package for 'java.lang'");
    }
}

