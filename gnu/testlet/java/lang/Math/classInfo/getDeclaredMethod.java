/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

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
        methodsThatShouldExist_jdk6.put("abs", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("abs", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("abs", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("abs", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("sin", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("cos", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("tan", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("atan2", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("sqrt", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("log", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("log10", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("pow", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("exp", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("min", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("min", new Class[]{Float.TYPE, Float.TYPE});
        methodsThatShouldExist_jdk6.put("min", new Class[]{Long.TYPE, Long.TYPE});
        methodsThatShouldExist_jdk6.put("min", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("max", new Class[]{Long.TYPE, Long.TYPE});
        methodsThatShouldExist_jdk6.put("max", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("max", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("max", new Class[]{Float.TYPE, Float.TYPE});
        methodsThatShouldExist_jdk6.put("scalb", new Class[]{Double.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("scalb", new Class[]{Float.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getExponent", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("getExponent", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("signum", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("signum", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("asin", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("acos", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("atan", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("toRadians", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("toDegrees", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("cbrt", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("IEEEremainder", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("ceil", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("floor", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("rint", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("round", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("round", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("initRNG", new Class[0]);
        methodsThatShouldExist_jdk6.put("random", new Class[0]);
        methodsThatShouldExist_jdk6.put("ulp", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("ulp", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("sinh", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("cosh", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("tanh", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("hypot", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("expm1", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("log1p", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("copySign", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("copySign", new Class[]{Float.TYPE, Float.TYPE});
        methodsThatShouldExist_jdk6.put("nextAfter", new Class[]{Float.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("nextAfter", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk6.put("nextUp", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("nextUp", new Class[]{Double.TYPE});
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("abs", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("abs", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk7.put("abs", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("abs", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("sin", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("cos", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("tan", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("atan2", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("sqrt", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("log", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("log10", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("pow", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("exp", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("min", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("min", new Class[]{Float.TYPE, Float.TYPE});
        methodsThatShouldExist_jdk7.put("min", new Class[]{Long.TYPE, Long.TYPE});
        methodsThatShouldExist_jdk7.put("min", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("max", new Class[]{Long.TYPE, Long.TYPE});
        methodsThatShouldExist_jdk7.put("max", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("max", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("max", new Class[]{Float.TYPE, Float.TYPE});
        methodsThatShouldExist_jdk7.put("scalb", new Class[]{Double.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("scalb", new Class[]{Float.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getExponent", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("getExponent", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk7.put("signum", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk7.put("signum", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("IEEEremainder", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("acos", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("asin", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("atan", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("cbrt", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("ceil", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("copySign", new Class[]{Float.TYPE, Float.TYPE});
        methodsThatShouldExist_jdk7.put("copySign", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("cosh", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("expm1", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("floor", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("hypot", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("initRNG", new Class[0]);
        methodsThatShouldExist_jdk7.put("log1p", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("nextAfter", new Class[]{Float.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("nextAfter", new Class[]{Double.TYPE, Double.TYPE});
        methodsThatShouldExist_jdk7.put("nextUp", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("nextUp", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk7.put("random", new Class[0]);
        methodsThatShouldExist_jdk7.put("rint", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("round", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk7.put("round", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("sinh", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("tanh", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("toDegrees", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("toRadians", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("ulp", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("ulp", new Class[]{Float.TYPE});
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Class<Math> c = Math.class;
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

