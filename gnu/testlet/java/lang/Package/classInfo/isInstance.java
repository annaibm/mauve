/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Package o = Package.getPackage("java.lang");
        Class<?> c = o.getClass();
        harness.check(c.isInstance(Package.getPackage("java.lang")));
    }
}

