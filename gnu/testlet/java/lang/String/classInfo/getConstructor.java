/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class getConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> constructorsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), Charset.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), String.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE, Charset.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE, String.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{StringBuilder.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{StringBuffer.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass()});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new int[1].getClass(), Integer.TYPE, Integer.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[0]);
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new char[1].getClass()});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{String.class});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE});
        constructorsThatShouldExist_jdk6.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE, Integer.TYPE});
        HashMap<String, Class[]> constructorsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass()});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), Charset.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), String.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE, Charset.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{StringBuilder.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{StringBuffer.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new int[1].getClass(), Integer.TYPE, Integer.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new char[1].getClass()});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{String.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[0]);
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE, String.class});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE});
        constructorsThatShouldExist_jdk7.put("java.lang.String", new Class[]{new byte[1].getClass(), Integer.TYPE, Integer.TYPE, Integer.TYPE});
        HashMap<String, Class[]> constructorsThatShouldExist = this.getJavaVersion() < 7 ? constructorsThatShouldExist_jdk6 : constructorsThatShouldExist_jdk7;
        String o = new String();
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

