/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class getMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("doubleToRawLongBits", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("doubleToLongBits", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("longBitsToDouble", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Double.class});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("byteValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("shortValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("intValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("longValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("floatValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("doubleValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("toHexString", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("compare", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("isNaN", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("isNaN", new Class[0]);
        methodsThatShouldExist_jdk6.put("isInfinite", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("isInfinite", new Class[0]);
        methodsThatShouldExist_jdk6.put("parseDouble", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("notify", new Class[0]);
        methodsThatShouldExist_jdk6.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("doubleToRawLongBits", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("doubleToLongBits", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("longBitsToDouble", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Double.class});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("byteValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("shortValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("intValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("longValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("floatValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("doubleValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("toHexString", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("compare", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("isNaN", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("isNaN", new Class[0]);
        methodsThatShouldExist_jdk7.put("isInfinite", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("isInfinite", new Class[0]);
        methodsThatShouldExist_jdk7.put("parseDouble", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("notify", new Class[0]);
        methodsThatShouldExist_jdk7.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Double o = new Double(42.0);
        Class<?> c = o.getClass();
        for (Map.Entry methodThatShouldExists : methodsThatShouldExist.entrySet()) {
            try {
                Method method = c.getMethod((String)methodThatShouldExists.getKey(), (Class[])methodThatShouldExists.getValue());
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

