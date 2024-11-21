/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalAccessException o = new IllegalAccessException("java.lang.IllegalAccessException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        if (this.getJavaVersion() == 6) {
            harness.check(superClass.getName(), (Object)"java.lang.Exception");
        } else {
            harness.check(superClass.getName(), (Object)"java.lang.ReflectiveOperationException");
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

