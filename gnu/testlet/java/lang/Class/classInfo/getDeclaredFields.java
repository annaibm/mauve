/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getDeclaredFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredFields = null;
        HashMap<String, String> testedDeclaredFields_jdk6 = new HashMap<String, String>();
        testedDeclaredFields_jdk6.put("private static final int java.lang.Class.ANNOTATION", "ANNOTATION");
        testedDeclaredFields_jdk6.put("private static final int java.lang.Class.ENUM", "ENUM");
        testedDeclaredFields_jdk6.put("private static final int java.lang.Class.SYNTHETIC", "SYNTHETIC");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.reflect.Constructor java.lang.Class.cachedConstructor", "cachedConstructor");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.Class java.lang.Class.newInstanceCallerCache", "newInstanceCallerCache");
        testedDeclaredFields_jdk6.put("private transient java.lang.String java.lang.Class.name", "name");
        testedDeclaredFields_jdk6.put("private static java.security.ProtectionDomain java.lang.Class.allPermDomain", "allPermDomain");
        testedDeclaredFields_jdk6.put("private static boolean java.lang.Class.useCaches", "useCaches");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredFields", "declaredFields");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.publicFields", "publicFields");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredMethods", "declaredMethods");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.publicMethods", "publicMethods");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredConstructors", "declaredConstructors");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.publicConstructors", "publicConstructors");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredPublicFields", "declaredPublicFields");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredPublicMethods", "declaredPublicMethods");
        testedDeclaredFields_jdk6.put("private transient volatile int java.lang.Class.classRedefinedCount", "classRedefinedCount");
        testedDeclaredFields_jdk6.put("private transient volatile int java.lang.Class.lastRedefinedCount", "lastRedefinedCount");
        testedDeclaredFields_jdk6.put("private transient sun.reflect.generics.repository.ClassRepository java.lang.Class.genericInfo", "genericInfo");
        testedDeclaredFields_jdk6.put("private static final long java.lang.Class.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk6.put("private static final java.io.ObjectStreamField[] java.lang.Class.serialPersistentFields", "serialPersistentFields");
        testedDeclaredFields_jdk6.put("private static sun.reflect.ReflectionFactory java.lang.Class.reflectionFactory", "reflectionFactory");
        testedDeclaredFields_jdk6.put("private static boolean java.lang.Class.initted", "initted");
        testedDeclaredFields_jdk6.put("private transient volatile java.lang.Object[] java.lang.Class.enumConstants", "enumConstants");
        testedDeclaredFields_jdk6.put("private transient volatile java.util.Map java.lang.Class.enumConstantDirectory", "enumConstantDirectory");
        testedDeclaredFields_jdk6.put("private transient java.util.Map java.lang.Class.annotations", "annotations");
        testedDeclaredFields_jdk6.put("private transient java.util.Map java.lang.Class.declaredAnnotations", "declaredAnnotations");
        testedDeclaredFields_jdk6.put("private sun.reflect.annotation.AnnotationType java.lang.Class.annotationType", "annotationType");
        testedDeclaredFields_jdk6.put("private static java.lang.annotation.Annotation[] java.lang.Class.EMPTY_ANNOTATIONS_ARRAY", "EMPTY_ANNOTATIONS_ARRAY");
        HashMap<String, String> testedDeclaredFields_jdk7 = new HashMap<String, String>();
        testedDeclaredFields_jdk7.put("private static final int java.lang.Class.ANNOTATION", "ANNOTATION");
        testedDeclaredFields_jdk7.put("private static final int java.lang.Class.ENUM", "ENUM");
        testedDeclaredFields_jdk7.put("private static final int java.lang.Class.SYNTHETIC", "SYNTHETIC");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.reflect.Constructor java.lang.Class.cachedConstructor", "cachedConstructor");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.Class java.lang.Class.newInstanceCallerCache", "newInstanceCallerCache");
        testedDeclaredFields_jdk7.put("private transient java.lang.String java.lang.Class.name", "name");
        testedDeclaredFields_jdk7.put("private static java.security.ProtectionDomain java.lang.Class.allPermDomain", "allPermDomain");
        testedDeclaredFields_jdk7.put("private static boolean java.lang.Class.useCaches", "useCaches");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredFields", "declaredFields");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.publicFields", "publicFields");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredMethods", "declaredMethods");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.publicMethods", "publicMethods");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredConstructors", "declaredConstructors");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.publicConstructors", "publicConstructors");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredPublicFields", "declaredPublicFields");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.ref.SoftReference java.lang.Class.declaredPublicMethods", "declaredPublicMethods");
        testedDeclaredFields_jdk7.put("private transient volatile int java.lang.Class.classRedefinedCount", "classRedefinedCount");
        testedDeclaredFields_jdk7.put("private transient volatile int java.lang.Class.lastRedefinedCount", "lastRedefinedCount");
        testedDeclaredFields_jdk7.put("private transient sun.reflect.generics.repository.ClassRepository java.lang.Class.genericInfo", "genericInfo");
        testedDeclaredFields_jdk7.put("private static final long java.lang.Class.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk7.put("private static final java.io.ObjectStreamField[] java.lang.Class.serialPersistentFields", "serialPersistentFields");
        testedDeclaredFields_jdk7.put("private static sun.reflect.ReflectionFactory java.lang.Class.reflectionFactory", "reflectionFactory");
        testedDeclaredFields_jdk7.put("private static boolean java.lang.Class.initted", "initted");
        testedDeclaredFields_jdk7.put("private transient volatile java.lang.Object[] java.lang.Class.enumConstants", "enumConstants");
        testedDeclaredFields_jdk7.put("private transient volatile java.util.Map java.lang.Class.enumConstantDirectory", "enumConstantDirectory");
        testedDeclaredFields_jdk7.put("private transient java.util.Map java.lang.Class.annotations", "annotations");
        testedDeclaredFields_jdk7.put("private transient java.util.Map java.lang.Class.declaredAnnotations", "declaredAnnotations");
        testedDeclaredFields_jdk7.put("private sun.reflect.annotation.AnnotationType java.lang.Class.annotationType", "annotationType");
        testedDeclaredFields_jdk7.put("transient java.lang.ClassValue$ClassValueMap java.lang.Class.classValueMap", "classValueMap");
        Class<Class> c = Class.class;
        testedDeclaredFields = this.getJavaVersion() < 7 ? testedDeclaredFields_jdk6 : testedDeclaredFields_jdk7;
        Field[] declaredFields = c.getDeclaredFields();
        int expectedNumberOfDeclaredFields = testedDeclaredFields.size();
        harness.check(declaredFields.length, expectedNumberOfDeclaredFields);
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            String fieldString = declaredField.toString();
            harness.check(testedDeclaredFields.containsKey(fieldString));
            harness.check(testedDeclaredFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

