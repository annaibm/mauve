/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import sun.reflect.annotation.AnnotationType;

public class getDeclaredMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap methodsThatShouldExist_jdk6 = new HashMap();
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("newInstance0", new Class[0]);
        methodsThatShouldExist_jdk7.put("forName", new Class[]{String.class, Boolean.TYPE, ClassLoader.class});
        methodsThatShouldExist_jdk7.put("forName", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("forName0", new Class[]{String.class, Boolean.TYPE, ClassLoader.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAssignableFrom", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("isInstance", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("getModifiers", new Class[0]);
        methodsThatShouldExist_jdk7.put("isInterface", new Class[0]);
        methodsThatShouldExist_jdk7.put("isArray", new Class[0]);
        methodsThatShouldExist_jdk7.put("isPrimitive", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSuperclass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getComponentType", new Class[0]);
        methodsThatShouldExist_jdk7.put("registerNatives", new Class[0]);
        methodsThatShouldExist_jdk7.put("getName", new Class[0]);
        methodsThatShouldExist_jdk7.put("access$100", new Class[]{new Object[0].getClass(), new Object[0].getClass()});
        methodsThatShouldExist_jdk7.put("access$202", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("access$302", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("addAll", new Class[]{Collection.class, new Field[0].getClass()});
        methodsThatShouldExist_jdk7.put("argumentTypesToString", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("arrayContentsEq", new Class[]{new Object[0].getClass(), new Object[0].getClass()});
        methodsThatShouldExist_jdk7.put("asSubclass", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("cannotCastMsg", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("cast", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("checkInitted", new Class[0]);
        methodsThatShouldExist_jdk7.put("checkMemberAccess", new Class[]{Integer.TYPE, ClassLoader.class});
        methodsThatShouldExist_jdk7.put("clearCachesOnClassRedefinition", new Class[0]);
        methodsThatShouldExist_jdk7.put("copyConstructors", new Class[]{new Constructor[0].getClass()});
        methodsThatShouldExist_jdk7.put("copyFields", new Class[]{new Field[0].getClass()});
        methodsThatShouldExist_jdk7.put("copyMethods", new Class[]{new Method[0].getClass()});
        methodsThatShouldExist_jdk7.put("desiredAssertionStatus", new Class[0]);
        methodsThatShouldExist_jdk7.put("desiredAssertionStatus0", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("enumConstantDirectory", new Class[0]);
        methodsThatShouldExist_jdk7.put("getAnnotation", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("getAnnotationType", new Class[0]);
        methodsThatShouldExist_jdk7.put("getAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getCanonicalName", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClassLoader", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClassLoader0", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClasses", new Class[0]);
        methodsThatShouldExist_jdk7.put("getConstantPool", new Class[0]);
        methodsThatShouldExist_jdk7.put("getConstructor", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getConstructor0", new Class[]{new Class[0].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getConstructors", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredClasses", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredClasses0", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredConstructor", new Class[]{new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getDeclaredConstructors", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredConstructors0", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("getDeclaredField", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getDeclaredFields", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredFields0", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getDeclaredMethods", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredMethods0", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("getDeclaringClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingConstructor", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingMethod", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingMethod0", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnclosingMethodInfo", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnumConstants", new Class[0]);
        methodsThatShouldExist_jdk7.put("getEnumConstantsShared", new Class[0]);
        methodsThatShouldExist_jdk7.put("getFactory", new Class[0]);
        methodsThatShouldExist_jdk7.put("getField", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getField0", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getFields", new Class[0]);
        methodsThatShouldExist_jdk7.put("getGenericInfo", new Class[0]);
        methodsThatShouldExist_jdk7.put("getGenericInterfaces", new Class[0]);
        methodsThatShouldExist_jdk7.put("getGenericSignature", new Class[0]);
        methodsThatShouldExist_jdk7.put("getGenericSuperclass", new Class[0]);
        methodsThatShouldExist_jdk7.put("getInterfaces", new Class[0]);
        methodsThatShouldExist_jdk7.put("getMethod", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getMethod0", new Class[]{String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("getMethods", new Class[0]);
        methodsThatShouldExist_jdk7.put("getName0", new Class[0]);
        methodsThatShouldExist_jdk7.put("getPackage", new Class[0]);
        methodsThatShouldExist_jdk7.put("getPrimitiveClass", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getProtectionDomain", new Class[0]);
        methodsThatShouldExist_jdk7.put("getProtectionDomain0", new Class[0]);
        methodsThatShouldExist_jdk7.put("getRawAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getReflectionFactory", new Class[0]);
        methodsThatShouldExist_jdk7.put("getResource", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getResourceAsStream", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getSigners", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSimpleBinaryName", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSimpleName", new Class[0]);
        methodsThatShouldExist_jdk7.put("getTypeParameters", new Class[0]);
        methodsThatShouldExist_jdk7.put("initAnnotationsIfNecessary", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAnnotation", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAnnotationPresent", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("isAnonymousClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isAsciiDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isEnum", new Class[0]);
        methodsThatShouldExist_jdk7.put("isLocalClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isLocalOrAnonymousClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isMemberClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("isSynthetic", new Class[0]);
        methodsThatShouldExist_jdk7.put("newInstance", new Class[0]);
        methodsThatShouldExist_jdk7.put("privateGetDeclaredConstructors", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("privateGetDeclaredFields", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("privateGetDeclaredMethods", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("privateGetPublicFields", new Class[]{Set.class});
        methodsThatShouldExist_jdk7.put("privateGetPublicMethods", new Class[0]);
        methodsThatShouldExist_jdk7.put("resolveName", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("searchFields", new Class[]{new Field[0].getClass(), String.class});
        methodsThatShouldExist_jdk7.put("searchMethods", new Class[]{new Method[0].getClass(), String.class, new Class[0].getClass()});
        methodsThatShouldExist_jdk7.put("setAnnotationType", new Class[]{AnnotationType.class});
        methodsThatShouldExist_jdk7.put("setProtectionDomain0", new Class[]{ProtectionDomain.class});
        methodsThatShouldExist_jdk7.put("setSigners", new Class[]{new Object[0].getClass()});
        methodsThatShouldExist_jdk7.put("toClass", new Class[]{Type.class});
        HashMap methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Class<Class> c = Class.class;
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

