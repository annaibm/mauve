/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long.classInfo;

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
        methodsThatShouldExist_jdk6.put("numberOfLeadingZeros", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("numberOfTrailingZeros", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("bitCount", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("toString", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("reverseBytes", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Long.class});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("getLong", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getLong", new Class[]{String.class, Long.class});
        methodsThatShouldExist_jdk6.put("getLong", new Class[]{String.class, Long.TYPE});
        methodsThatShouldExist_jdk6.put("byteValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("shortValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("intValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("longValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("floatValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("doubleValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toHexString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("decode", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("reverse", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("toOctalString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("toBinaryString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("highestOneBit", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("lowestOneBit", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("rotateLeft", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("rotateRight", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("signum", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("parseLong", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("parseLong", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("notify", new Class[0]);
        methodsThatShouldExist_jdk6.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("numberOfLeadingZeros", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("numberOfTrailingZeros", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("bitCount", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("toString", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("reverseBytes", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Long.class});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("getLong", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getLong", new Class[]{String.class, Long.class});
        methodsThatShouldExist_jdk7.put("getLong", new Class[]{String.class, Long.TYPE});
        methodsThatShouldExist_jdk7.put("byteValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("shortValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("intValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("longValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("floatValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("doubleValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("toHexString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("compare", new Class[]{Long.TYPE, Long.TYPE});
        methodsThatShouldExist_jdk7.put("decode", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("reverse", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("highestOneBit", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("lowestOneBit", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("rotateLeft", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("rotateRight", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("signum", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("toBinaryString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("toOctalString", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("parseLong", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("parseLong", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("notify", new Class[0]);
        methodsThatShouldExist_jdk7.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Long o = new Long(42L);
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

