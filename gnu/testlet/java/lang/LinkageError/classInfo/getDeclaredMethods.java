/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.LinkageError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;

public class getDeclaredMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap testedDeclaredMethods = null;
        HashMap testedDeclaredMethods_jdk6 = new HashMap();
        HashMap testedDeclaredMethods_jdk7 = new HashMap();
        LinkageError o = new LinkageError("LinkageError");
        Class<?> c = o.getClass();
        testedDeclaredMethods = this.getJavaVersion() < 7 ? testedDeclaredMethods_jdk6 : testedDeclaredMethods_jdk7;
        Method[] declaredMethods = c.getDeclaredMethods();
        int expectedNumberOfDeclaredMethods = testedDeclaredMethods.size();
        harness.check(declaredMethods.length, expectedNumberOfDeclaredMethods);
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

