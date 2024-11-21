/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchMethodException o = new NoSuchMethodException("java.lang.NoSuchMethodException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        int javaVersion = this.getJavaVersion();
        if (javaVersion == 6) {
            harness.check(superClass.getName(), (Object)"java.lang.Exception");
        }
        if (javaVersion == 7) {
            harness.check(superClass.getName(), (Object)"java.lang.ReflectiveOperationException");
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

