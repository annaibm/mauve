/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Runtime.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class getConstructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap testedConstructors = null;
        HashMap testedConstructors_jdk6 = new HashMap();
        HashMap testedConstructors_jdk7 = new HashMap();
        Runtime o = Runtime.getRuntime();
        Class<?> c = o.getClass();
        testedConstructors = this.getJavaVersion() < 7 ? testedConstructors_jdk6 : testedConstructors_jdk7;
        Constructor<?>[] constructors2 = c.getConstructors();
        int expectedNumberOfConstructors = testedConstructors.size();
        harness.check(constructors2.length, expectedNumberOfConstructors);
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}
