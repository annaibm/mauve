/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InterruptedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class getConstructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedConstructors = null;
        HashMap<String, String> testedConstructors_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedConstructors_jdk7 = new HashMap<String, String>();
        testedConstructors_jdk6.put("public java.lang.InterruptedException()", "java.lang.InterruptedException");
        testedConstructors_jdk6.put("public java.lang.InterruptedException(java.lang.String)", "java.lang.InterruptedException");
        testedConstructors_jdk7.put("public java.lang.InterruptedException()", "java.lang.InterruptedException");
        testedConstructors_jdk7.put("public java.lang.InterruptedException(java.lang.String)", "java.lang.InterruptedException");
        InterruptedException o = new InterruptedException("java.lang.InterruptedException");
        Class<?> c = o.getClass();
        testedConstructors = this.getJavaVersion() < 7 ? testedConstructors_jdk6 : testedConstructors_jdk7;
        Constructor<?>[] constructors2 = c.getConstructors();
        int expectedNumberOfConstructors = testedConstructors.size();
        harness.check(constructors2.length, expectedNumberOfConstructors);
        for (Constructor<?> constructor2 : constructors2) {
            String constructorName = constructor2.getName();
            String constructorString2 = constructor2.toString().replaceAll(" native ", " ");
            harness.check(testedConstructors.containsKey(constructorString2));
            harness.check(testedConstructors.get(constructorString2), (Object)constructorName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

