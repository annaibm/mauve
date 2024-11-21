/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class getConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> constructorsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        constructorsThatShouldExist_jdk6.put("java.lang.IllegalAccessError", new Class[0]);
        constructorsThatShouldExist_jdk6.put("java.lang.IllegalAccessError", new Class[]{String.class});
        HashMap<String, Class[]> constructorsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        constructorsThatShouldExist_jdk7.put("java.lang.IllegalAccessError", new Class[0]);
        constructorsThatShouldExist_jdk7.put("java.lang.IllegalAccessError", new Class[]{String.class});
        HashMap<String, Class[]> constructorsThatShouldExist = this.getJavaVersion() < 7 ? constructorsThatShouldExist_jdk6 : constructorsThatShouldExist_jdk7;
        IllegalAccessError o = new IllegalAccessError("IllegalAccessError");
        Class<?> c = o.getClass();
        for (Map.Entry constructorThatShouldExists : constructorsThatShouldExist.entrySet()) {
            try {
                Constructor<?> constructor2 = c.getConstructor((Class[])constructorThatShouldExists.getValue());
                harness.check(constructor2 != null);
                String constructorName = constructor2.getName();
                harness.check(constructorName != null);
                harness.check(constructorName, constructorThatShouldExists.getKey());
            }
            catch (Exception e) {
                harness.check(false);
            }
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

