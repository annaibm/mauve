/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InheritableThreadLocal.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;

public class getDeclaredMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredMethods = null;
        HashMap<String, String> testedDeclaredMethods_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredMethods_jdk7 = new HashMap<String, String>();
        testedDeclaredMethods_jdk6.put("java.lang.ThreadLocal$ThreadLocalMap java.lang.InheritableThreadLocal.getMap(java.lang.Thread)", "getMap");
        testedDeclaredMethods_jdk6.put("void java.lang.InheritableThreadLocal.createMap(java.lang.Thread,java.lang.Object)", "createMap");
        testedDeclaredMethods_jdk6.put("protected java.lang.Object java.lang.InheritableThreadLocal.childValue(java.lang.Object)", "childValue");
        testedDeclaredMethods_jdk7.put("protected java.lang.Object java.lang.InheritableThreadLocal.childValue(java.lang.Object)", "childValue");
        testedDeclaredMethods_jdk7.put("void java.lang.InheritableThreadLocal.createMap(java.lang.Thread,java.lang.Object)", "createMap");
        testedDeclaredMethods_jdk7.put("java.lang.ThreadLocal$ThreadLocalMap java.lang.InheritableThreadLocal.getMap(java.lang.Thread)", "getMap");
        InheritableThreadLocal o = new InheritableThreadLocal();
        Class<?> c = o.getClass();
        testedDeclaredMethods = this.getJavaVersion() < 7 ? testedDeclaredMethods_jdk6 : testedDeclaredMethods_jdk7;
        Method[] declaredMethods = c.getDeclaredMethods();
        int expectedNumberOfDeclaredMethods = testedDeclaredMethods.size();
        harness.check(declaredMethods.length, expectedNumberOfDeclaredMethods);
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            String methodString = declaredMethod.toString().replaceAll(" native ", " ");
            harness.check(testedDeclaredMethods.containsKey(methodString));
            harness.check(testedDeclaredMethods.get(methodString), (Object)methodName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

