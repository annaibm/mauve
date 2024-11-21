/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class getDeclaredMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("toString", new Class[]{Byte.TYPE});
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Byte.class});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("byteValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("shortValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("intValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("longValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("floatValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("doubleValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Byte.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("decode", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("parseByte", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("parseByte", new Class[]{String.class});
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("toString", new Class[]{Byte.TYPE});
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Byte.class});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("byteValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("shortValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("intValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("longValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("floatValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("doubleValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Byte.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("compare", new Class[]{Byte.TYPE, Byte.TYPE});
        methodsThatShouldExist_jdk7.put("decode", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("parseByte", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("parseByte", new Class[]{String.class, Integer.TYPE});
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Byte o = new Byte(42);
        Class<?> c = o.getClass();
        for (Map.Entry methodThatShouldExists : methodsThatShouldExist.entrySet()) {
            try {
                Method method = c.getDeclaredMethod((String)methodThatShouldExists.getKey(), (Class[])methodThatShouldExists.getValue());
                harness.check(method != null);
                String methodName = method.getName();
                harness.check(methodName != null);
                harness.check(methodName, methodThatShouldExists.getKey());
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

