/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;

public class getMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedMethods = null;
        HashMap<String, String> testedMethods_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedMethods_jdk7 = new HashMap<String, String>();
        testedMethods_jdk6.put("public static java.lang.Class java.lang.Class.forName(java.lang.String,boolean,java.lang.ClassLoader) throws java.lang.ClassNotFoundException", "forName");
        testedMethods_jdk6.put("public static java.lang.Class java.lang.Class.forName(java.lang.String) throws java.lang.ClassNotFoundException", "forName");
        testedMethods_jdk6.put("public java.lang.String java.lang.Class.toString()", "toString");
        testedMethods_jdk6.put("public boolean java.lang.Class.isAssignableFrom(java.lang.Class)", "isAssignableFrom");
        testedMethods_jdk6.put("public boolean java.lang.Class.isInstance(java.lang.Object)", "isInstance");
        testedMethods_jdk6.put("public int java.lang.Class.getModifiers()", "getModifiers");
        testedMethods_jdk6.put("public boolean java.lang.Class.isInterface()", "isInterface");
        testedMethods_jdk6.put("public boolean java.lang.Class.isArray()", "isArray");
        testedMethods_jdk6.put("public boolean java.lang.Class.isPrimitive()", "isPrimitive");
        testedMethods_jdk6.put("public java.lang.Class java.lang.Class.getSuperclass()", "getSuperclass");
        testedMethods_jdk6.put("public java.lang.Class java.lang.Class.getComponentType()", "getComponentType");
        testedMethods_jdk6.put("public java.lang.String java.lang.Class.getName()", "getName");
        testedMethods_jdk6.put("public java.lang.Object java.lang.Class.newInstance() throws java.lang.InstantiationException,java.lang.IllegalAccessException", "newInstance");
        testedMethods_jdk6.put("public boolean java.lang.Class.isAnnotation()", "isAnnotation");
        testedMethods_jdk6.put("public boolean java.lang.Class.isSynthetic()", "isSynthetic");
        testedMethods_jdk6.put("public java.lang.ClassLoader java.lang.Class.getClassLoader()", "getClassLoader");
        testedMethods_jdk6.put("public java.lang.reflect.TypeVariable[] java.lang.Class.getTypeParameters()", "getTypeParameters");
        testedMethods_jdk6.put("public java.lang.reflect.Type java.lang.Class.getGenericSuperclass()", "getGenericSuperclass");
        testedMethods_jdk6.put("public java.lang.Package java.lang.Class.getPackage()", "getPackage");
        testedMethods_jdk6.put("public java.lang.Class[] java.lang.Class.getInterfaces()", "getInterfaces");
        testedMethods_jdk6.put("public java.lang.reflect.Type[] java.lang.Class.getGenericInterfaces()", "getGenericInterfaces");
        testedMethods_jdk6.put("public java.lang.Object[] java.lang.Class.getSigners()", "getSigners");
        testedMethods_jdk6.put("public java.lang.reflect.Method java.lang.Class.getEnclosingMethod()", "getEnclosingMethod");
        testedMethods_jdk6.put("public java.lang.reflect.Constructor java.lang.Class.getEnclosingConstructor()", "getEnclosingConstructor");
        testedMethods_jdk6.put("public java.lang.Class java.lang.Class.getDeclaringClass()", "getDeclaringClass");
        testedMethods_jdk6.put("public java.lang.Class java.lang.Class.getEnclosingClass()", "getEnclosingClass");
        testedMethods_jdk6.put("public java.lang.String java.lang.Class.getSimpleName()", "getSimpleName");
        testedMethods_jdk6.put("public java.lang.String java.lang.Class.getCanonicalName()", "getCanonicalName");
        testedMethods_jdk6.put("public boolean java.lang.Class.isAnonymousClass()", "isAnonymousClass");
        testedMethods_jdk6.put("public boolean java.lang.Class.isLocalClass()", "isLocalClass");
        testedMethods_jdk6.put("public boolean java.lang.Class.isMemberClass()", "isMemberClass");
        testedMethods_jdk6.put("public java.lang.Class[] java.lang.Class.getClasses()", "getClasses");
        testedMethods_jdk6.put("public java.lang.reflect.Field[] java.lang.Class.getFields() throws java.lang.SecurityException", "getFields");
        testedMethods_jdk6.put("public java.lang.reflect.Method[] java.lang.Class.getMethods() throws java.lang.SecurityException", "getMethods");
        testedMethods_jdk6.put("public java.lang.reflect.Constructor[] java.lang.Class.getConstructors() throws java.lang.SecurityException", "getConstructors");
        testedMethods_jdk6.put("public java.lang.reflect.Field java.lang.Class.getField(java.lang.String) throws java.lang.NoSuchFieldException,java.lang.SecurityException", "getField");
        testedMethods_jdk6.put("public java.lang.reflect.Method java.lang.Class.getMethod(java.lang.String,java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getMethod");
        testedMethods_jdk6.put("public java.lang.reflect.Constructor java.lang.Class.getConstructor(java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getConstructor");
        testedMethods_jdk6.put("public java.lang.Class[] java.lang.Class.getDeclaredClasses() throws java.lang.SecurityException", "getDeclaredClasses");
        testedMethods_jdk6.put("public java.lang.reflect.Field[] java.lang.Class.getDeclaredFields() throws java.lang.SecurityException", "getDeclaredFields");
        testedMethods_jdk6.put("public java.lang.reflect.Method[] java.lang.Class.getDeclaredMethods() throws java.lang.SecurityException", "getDeclaredMethods");
        testedMethods_jdk6.put("public java.lang.reflect.Constructor[] java.lang.Class.getDeclaredConstructors() throws java.lang.SecurityException", "getDeclaredConstructors");
        testedMethods_jdk6.put("public java.lang.reflect.Field java.lang.Class.getDeclaredField(java.lang.String) throws java.lang.NoSuchFieldException,java.lang.SecurityException", "getDeclaredField");
        testedMethods_jdk6.put("public java.lang.reflect.Method java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getDeclaredMethod");
        testedMethods_jdk6.put("public java.lang.reflect.Constructor java.lang.Class.getDeclaredConstructor(java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getDeclaredConstructor");
        testedMethods_jdk6.put("public java.io.InputStream java.lang.Class.getResourceAsStream(java.lang.String)", "getResourceAsStream");
        testedMethods_jdk6.put("public java.net.URL java.lang.Class.getResource(java.lang.String)", "getResource");
        testedMethods_jdk6.put("public java.security.ProtectionDomain java.lang.Class.getProtectionDomain()", "getProtectionDomain");
        testedMethods_jdk6.put("public boolean java.lang.Class.desiredAssertionStatus()", "desiredAssertionStatus");
        testedMethods_jdk6.put("public boolean java.lang.Class.isEnum()", "isEnum");
        testedMethods_jdk6.put("public java.lang.Object[] java.lang.Class.getEnumConstants()", "getEnumConstants");
        testedMethods_jdk6.put("public java.lang.Object java.lang.Class.cast(java.lang.Object)", "cast");
        testedMethods_jdk6.put("public java.lang.Class java.lang.Class.asSubclass(java.lang.Class)", "asSubclass");
        testedMethods_jdk6.put("public java.lang.annotation.Annotation java.lang.Class.getAnnotation(java.lang.Class)", "getAnnotation");
        testedMethods_jdk6.put("public boolean java.lang.Class.isAnnotationPresent(java.lang.Class)", "isAnnotationPresent");
        testedMethods_jdk6.put("public java.lang.annotation.Annotation[] java.lang.Class.getAnnotations()", "getAnnotations");
        testedMethods_jdk6.put("public java.lang.annotation.Annotation[] java.lang.Class.getDeclaredAnnotations()", "getDeclaredAnnotations");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public int java.lang.Object.hashCode()", "hashCode");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public static java.lang.Class java.lang.Class.forName(java.lang.String,boolean,java.lang.ClassLoader) throws java.lang.ClassNotFoundException", "forName");
        testedMethods_jdk7.put("public static java.lang.Class java.lang.Class.forName(java.lang.String) throws java.lang.ClassNotFoundException", "forName");
        testedMethods_jdk7.put("public java.lang.String java.lang.Class.toString()", "toString");
        testedMethods_jdk7.put("public boolean java.lang.Class.isAssignableFrom(java.lang.Class)", "isAssignableFrom");
        testedMethods_jdk7.put("public boolean java.lang.Class.isInstance(java.lang.Object)", "isInstance");
        testedMethods_jdk7.put("public int java.lang.Class.getModifiers()", "getModifiers");
        testedMethods_jdk7.put("public boolean java.lang.Class.isInterface()", "isInterface");
        testedMethods_jdk7.put("public boolean java.lang.Class.isArray()", "isArray");
        testedMethods_jdk7.put("public boolean java.lang.Class.isPrimitive()", "isPrimitive");
        testedMethods_jdk7.put("public java.lang.Class java.lang.Class.getSuperclass()", "getSuperclass");
        testedMethods_jdk7.put("public java.lang.Class java.lang.Class.getComponentType()", "getComponentType");
        testedMethods_jdk7.put("public java.lang.String java.lang.Class.getName()", "getName");
        testedMethods_jdk7.put("public java.lang.Class java.lang.Class.asSubclass(java.lang.Class)", "asSubclass");
        testedMethods_jdk7.put("public java.lang.Object java.lang.Class.cast(java.lang.Object)", "cast");
        testedMethods_jdk7.put("public boolean java.lang.Class.desiredAssertionStatus()", "desiredAssertionStatus");
        testedMethods_jdk7.put("public java.lang.annotation.Annotation java.lang.Class.getAnnotation(java.lang.Class)", "getAnnotation");
        testedMethods_jdk7.put("public java.lang.annotation.Annotation[] java.lang.Class.getAnnotations()", "getAnnotations");
        testedMethods_jdk7.put("public java.lang.String java.lang.Class.getCanonicalName()", "getCanonicalName");
        testedMethods_jdk7.put("public java.lang.ClassLoader java.lang.Class.getClassLoader()", "getClassLoader");
        testedMethods_jdk7.put("public java.lang.Class[] java.lang.Class.getClasses()", "getClasses");
        testedMethods_jdk7.put("public java.lang.reflect.Constructor java.lang.Class.getConstructor(java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getConstructor");
        testedMethods_jdk7.put("public java.lang.reflect.Constructor[] java.lang.Class.getConstructors() throws java.lang.SecurityException", "getConstructors");
        testedMethods_jdk7.put("public java.lang.annotation.Annotation[] java.lang.Class.getDeclaredAnnotations()", "getDeclaredAnnotations");
        testedMethods_jdk7.put("public java.lang.Class[] java.lang.Class.getDeclaredClasses() throws java.lang.SecurityException", "getDeclaredClasses");
        testedMethods_jdk7.put("public java.lang.reflect.Constructor java.lang.Class.getDeclaredConstructor(java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getDeclaredConstructor");
        testedMethods_jdk7.put("public java.lang.reflect.Constructor[] java.lang.Class.getDeclaredConstructors() throws java.lang.SecurityException", "getDeclaredConstructors");
        testedMethods_jdk7.put("public java.lang.reflect.Field java.lang.Class.getDeclaredField(java.lang.String) throws java.lang.NoSuchFieldException,java.lang.SecurityException", "getDeclaredField");
        testedMethods_jdk7.put("public java.lang.reflect.Field[] java.lang.Class.getDeclaredFields() throws java.lang.SecurityException", "getDeclaredFields");
        testedMethods_jdk7.put("public java.lang.reflect.Method java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getDeclaredMethod");
        testedMethods_jdk7.put("public java.lang.reflect.Method[] java.lang.Class.getDeclaredMethods() throws java.lang.SecurityException", "getDeclaredMethods");
        testedMethods_jdk7.put("public java.lang.Class java.lang.Class.getDeclaringClass()", "getDeclaringClass");
        testedMethods_jdk7.put("public java.lang.Class java.lang.Class.getEnclosingClass()", "getEnclosingClass");
        testedMethods_jdk7.put("public java.lang.reflect.Constructor java.lang.Class.getEnclosingConstructor()", "getEnclosingConstructor");
        testedMethods_jdk7.put("public java.lang.reflect.Method java.lang.Class.getEnclosingMethod()", "getEnclosingMethod");
        testedMethods_jdk7.put("public java.lang.Object[] java.lang.Class.getEnumConstants()", "getEnumConstants");
        testedMethods_jdk7.put("public java.lang.reflect.Field java.lang.Class.getField(java.lang.String) throws java.lang.NoSuchFieldException,java.lang.SecurityException", "getField");
        testedMethods_jdk7.put("public java.lang.reflect.Field[] java.lang.Class.getFields() throws java.lang.SecurityException", "getFields");
        testedMethods_jdk7.put("public java.lang.reflect.Type[] java.lang.Class.getGenericInterfaces()", "getGenericInterfaces");
        testedMethods_jdk7.put("public java.lang.reflect.Type java.lang.Class.getGenericSuperclass()", "getGenericSuperclass");
        testedMethods_jdk7.put("public java.lang.Class[] java.lang.Class.getInterfaces()", "getInterfaces");
        testedMethods_jdk7.put("public java.lang.reflect.Method java.lang.Class.getMethod(java.lang.String,java.lang.Class[]) throws java.lang.NoSuchMethodException,java.lang.SecurityException", "getMethod");
        testedMethods_jdk7.put("public java.lang.reflect.Method[] java.lang.Class.getMethods() throws java.lang.SecurityException", "getMethods");
        testedMethods_jdk7.put("public java.lang.Package java.lang.Class.getPackage()", "getPackage");
        testedMethods_jdk7.put("public java.security.ProtectionDomain java.lang.Class.getProtectionDomain()", "getProtectionDomain");
        testedMethods_jdk7.put("public java.net.URL java.lang.Class.getResource(java.lang.String)", "getResource");
        testedMethods_jdk7.put("public java.io.InputStream java.lang.Class.getResourceAsStream(java.lang.String)", "getResourceAsStream");
        testedMethods_jdk7.put("public java.lang.Object[] java.lang.Class.getSigners()", "getSigners");
        testedMethods_jdk7.put("public java.lang.String java.lang.Class.getSimpleName()", "getSimpleName");
        testedMethods_jdk7.put("public java.lang.reflect.TypeVariable[] java.lang.Class.getTypeParameters()", "getTypeParameters");
        testedMethods_jdk7.put("public boolean java.lang.Class.isAnnotation()", "isAnnotation");
        testedMethods_jdk7.put("public boolean java.lang.Class.isAnnotationPresent(java.lang.Class)", "isAnnotationPresent");
        testedMethods_jdk7.put("public boolean java.lang.Class.isAnonymousClass()", "isAnonymousClass");
        testedMethods_jdk7.put("public boolean java.lang.Class.isEnum()", "isEnum");
        testedMethods_jdk7.put("public boolean java.lang.Class.isLocalClass()", "isLocalClass");
        testedMethods_jdk7.put("public boolean java.lang.Class.isMemberClass()", "isMemberClass");
        testedMethods_jdk7.put("public boolean java.lang.Class.isSynthetic()", "isSynthetic");
        testedMethods_jdk7.put("public java.lang.Object java.lang.Class.newInstance() throws java.lang.InstantiationException,java.lang.IllegalAccessException", "newInstance");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public int java.lang.Object.hashCode()", "hashCode");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Class<Class> c = Class.class;
        testedMethods = this.getJavaVersion() < 7 ? testedMethods_jdk6 : testedMethods_jdk7;
        Method[] methods = c.getMethods();
        int expectedNumberOfMethods = testedMethods.size();
        harness.check(methods.length, expectedNumberOfMethods);
        for (Method method : methods) {
            String methodName = method.getName();
            String methodString = method.toString().replaceAll(" native ", " ");
            harness.check(testedMethods.containsKey(methodString));
            harness.check(testedMethods.get(methodString), (Object)methodName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

