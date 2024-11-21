/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ProcessBuilder.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("start", new Class[0]);
        methodsThatShouldExist_jdk6.put("command", new Class[]{List.class});
        methodsThatShouldExist_jdk6.put("command", new Class[]{new String[0].getClass()});
        methodsThatShouldExist_jdk6.put("command", new Class[0]);
        methodsThatShouldExist_jdk6.put("environment", new Class[0]);
        methodsThatShouldExist_jdk6.put("directory", new Class[]{File.class});
        methodsThatShouldExist_jdk6.put("directory", new Class[0]);
        methodsThatShouldExist_jdk6.put("redirectErrorStream", new Class[0]);
        methodsThatShouldExist_jdk6.put("redirectErrorStream", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[0]);
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("notify", new Class[0]);
        methodsThatShouldExist_jdk6.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("start", new Class[0]);
        methodsThatShouldExist_jdk7.put("directory", new Class[0]);
        methodsThatShouldExist_jdk7.put("directory", new Class[]{File.class});
        methodsThatShouldExist_jdk7.put("environment", new Class[0]);
        methodsThatShouldExist_jdk7.put("command", new Class[]{List.class});
        methodsThatShouldExist_jdk7.put("command", new Class[0]);
        methodsThatShouldExist_jdk7.put("command", new Class[]{new String[0].getClass()});
        methodsThatShouldExist_jdk7.put("inheritIO", new Class[0]);
        methodsThatShouldExist_jdk7.put("redirectError", new Class[]{File.class});
        methodsThatShouldExist_jdk7.put("redirectError", new Class[0]);
        methodsThatShouldExist_jdk7.put("redirectErrorStream", new Class[0]);
        methodsThatShouldExist_jdk7.put("redirectErrorStream", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("redirectInput", new Class[]{File.class});
        methodsThatShouldExist_jdk7.put("redirectInput", new Class[0]);
        methodsThatShouldExist_jdk7.put("redirectOutput", new Class[]{File.class});
        methodsThatShouldExist_jdk7.put("redirectOutput", new Class[0]);
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[0]);
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("notify", new Class[0]);
        methodsThatShouldExist_jdk7.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        ProcessBuilder o = new ProcessBuilder("");
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

