/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.AssertionError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class getDeclaredConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> constructorsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[0]);
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{String.class});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Object.class});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Boolean.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Character.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Integer.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Long.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Float.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.AssertionError", new Class[]{Double.TYPE});
        HashMap<String, Class[]> constructorsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Integer.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Long.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Float.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Double.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{String.class, Throwable.class});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[0]);
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{String.class});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Object.class});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Boolean.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.AssertionError", new Class[]{Character.TYPE});
        HashMap<String, Class[]> constructorsThatShouldExist = this.getJavaVersion() < 7 ? constructorsThatShouldExist_jdk6 : constructorsThatShouldExist_jdk7;
        AssertionError o = new AssertionError();
        Class<?> c = o.getClass();
        for (Map.Entry constructorThatShouldExists : constructorsThatShouldExist.entrySet()) {
            try {
                Constructor<?> constructor2 = c.getDeclaredConstructor((Class[])constructorThatShouldExists.getValue());
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

