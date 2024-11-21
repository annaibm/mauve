/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InstantiationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InstantiationException o = new InstantiationException("java.lang.InstantiationException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        if (this.getJavaVersion() >= 7) {
            harness.check(superClass.getName(), (Object)"java.lang.ReflectiveOperationException");
        } else {
            harness.check(superClass.getName(), (Object)"java.lang.Exception");
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

