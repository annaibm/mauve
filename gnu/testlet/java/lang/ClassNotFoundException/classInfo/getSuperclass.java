/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassNotFoundException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassNotFoundException o = new ClassNotFoundException("java.lang.ClassNotFoundException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        int version = this.getJavaVersion();
        if (version == 6) {
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

