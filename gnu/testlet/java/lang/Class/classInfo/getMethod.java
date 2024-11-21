/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

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
        methodsThatShouldExist_jdk6.put("forName", new Class[]{String.class, Boolean.TYPE, ClassLoader.class});
        methodsThatShouldExist_jdk6.put("forName", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("isAssignableFrom", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("isInstance", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("getModifiers", new Class[0]);
        methodsThatShouldExist_jdk6.put("isInterface", new Class[0]);
        methodsThatShouldExist_jdk6.put("isArray", new Class[0]);
        methodsThatShouldExist_jdk6.put("isPrimitive", new Class[0]);
        methodsThatShouldExist_jdk6.put("getSuperclass", new Class[0]);
        methodsThatShouldExist_jdk6.put("getComponentType", new Class[0]);
        methodsThatShouldExist_jdk6.put("getName", new Class[0]);
        methodsThatShouldExist_jdk6.put("newInstance", new Class[0]);
        methodsThatShouldExist_jdk6.put("isAnnotation", new Class[0]);
        methodsThatShouldExist_jdk6.put("isSynthetic", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClassLoader", new Class[0]);
        methodsThatShouldExist_jdk6.put("getTypeParameters", new Class[0]);
        methodsThatShouldExist_jdk6.put("getGenericSuperclass", new Class[0]);
        methodsThatShouldExist_jdk6.put("getPackage", new Class[0]);
        methodsThatShouldExist_jdk6.put("getInterfaces", new Class[0]);
        methodsThatShouldExist_jdk6.put("getGenericInterfaces", new Class[0]);
        methodsThatShouldExist_jdk6.put("getSigners", new Class[0]);
        methodsThatShouldExist_jdk6.put("getEnclosingMethod", new Class[0]);
        methodsThatShouldExist_jdk6.put("getEnclosingConstructor", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaringClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("getEnclosingClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("getSimpleName", new Class[0]);
        methodsThatShouldExist_jdk6.put("getCanonicalName", new Class[0]);
        methodsThatShouldExist_jdk6.put("isAnonymousClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("isLocalClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("isMemberClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClasses", new Class[0]);
        methodsThatShouldExist_jdk6.put("getFields", new Class[0]);
        methodsThatShouldExist_jdk6.put("getMethods", new Class[0]);
        methodsThatShouldExist_jdk6.put("getConstructors", new Class[0]);
        methodsThatShouldExist_jdk6.put("getField", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getMethod", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk6.put("getConstructor", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk6.put("getDeclaredClasses", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaredFields", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaredMethods", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaredConstructors", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaredField", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk6.put("getDeclaredConstructor", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk6.put("getResourceAsStream", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getResource", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getProtectionDomain", new Class[0]);
        methodsThatShouldExist_jdk6.put("desiredAssertionStatus", new Class[0]);
        methodsThatShouldExist_jdk6.put("isEnum", new Class[0]);
        methodsThatShouldExist_jdk6.put("getEnumConstants", new Class[0]);
        methodsThatShouldExist_jdk6.put("cast", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("asSubclass", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("getAnnotation", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("isAnnotationPresent", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("getAnnotations", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaredAnnotations", new Class[0]);
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[0]);
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("notify", new Class[0]);
        methodsThatShouldExist_jdk6.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("forName", new Class[]{String.class, Boolean.TYPE, ClassLoader.class});
        methodsThatShouldExist_jdk7.put("forName", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAssignableFrom", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("isInstance", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("getModifiers", new Class[0]);
        methodsThatShouldExist_jdk7.put("isInterface", new Class[0]);
        methodsThatShouldExist_jdk7.put("isArray", new Class[0]);
        methodsThatShouldExist_jdk7.put("isPrimitive", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSuperclass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getComponentType", new Class[0]);
        methodsThatShouldExist_jdk7.put("getName", new Class[0]);
        methodsThatShouldExist_jdk7.put("asSubclass", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("cast", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("desiredAssertionStatus", new Class[0]);
        methodsThatShouldExist_jdk7.put("getAnnotation", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("getAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getCanonicalName", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClassLoader", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClasses", new Class[0]);
        methodsThatShouldExist_jdk7.put("getConstructor", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getConstructors", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredClasses", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredConstructor", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getDeclaredConstructors", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredField", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getDeclaredFields", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getDeclaredMethods", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaringClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingConstructor", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingMethod", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnumConstants", new Class[0]);
        methodsThatShouldExist_jdk7.put("getField", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getFields", new Class[0]);
        methodsThatShouldExist_jdk7.put("getGenericInterfaces", new Class[0]);
        methodsThatShouldExist_jdk7.put("getGenericSuperclass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getInterfaces", new Class[0]);
        methodsThatShouldExist_jdk7.put("getMethod", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getMethods", new Class[0]);
        methodsThatShouldExist_jdk7.put("getPackage", new Class[0]);
        methodsThatShouldExist_jdk7.put("getProtectionDomain", new Class[0]);
        methodsThatShouldExist_jdk7.put("getResource", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getResourceAsStream", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getSigners", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSimpleName", new Class[0]);
        methodsThatShouldExist_jdk7.put("getTypeParameters", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAnnotation", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAnnotationPresent", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("isAnonymousClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isEnum", new Class[0]);
        methodsThatShouldExist_jdk7.put("isLocalClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isMemberClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isSynthetic", new Class[0]);
        methodsThatShouldExist_jdk7.put("newInstance", new Class[0]);
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[0]);
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("notify", new Class[0]);
        methodsThatShouldExist_jdk7.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Class<Class> c = Class.class;
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

