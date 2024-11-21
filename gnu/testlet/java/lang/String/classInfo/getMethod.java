/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class getMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("indexOf", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("indexOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("indexOf", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("indexOf", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{new char[1].getClass()});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk6.put("length", new Class[0]);
        methodsThatShouldExist_jdk6.put("isEmpty", new Class[0]);
        methodsThatShouldExist_jdk6.put("charAt", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointAt", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointBefore", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointCount", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("offsetByCodePoints", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getChars", new Class[]{Integer.TYPE, Integer.TYPE, new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getBytes", new Class[]{Charset.class});
        methodsThatShouldExist_jdk6.put("getBytes", new Class[0]);
        methodsThatShouldExist_jdk6.put("getBytes", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getBytes", new Class[]{Integer.TYPE, Integer.TYPE, new byte[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk6.put("contentEquals", new Class[]{CharSequence.class});
        methodsThatShouldExist_jdk6.put("contentEquals", new Class[]{StringBuffer.class});
        methodsThatShouldExist_jdk6.put("equalsIgnoreCase", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("compareToIgnoreCase", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("regionMatches", new Class[]{Boolean.TYPE, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("regionMatches", new Class[]{Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("startsWith", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("startsWith", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("endsWith", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("lastIndexOf", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("lastIndexOf", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("lastIndexOf", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("lastIndexOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("substring", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("substring", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("subSequence", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("concat", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("replace", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk6.put("replace", new Class[]{CharSequence.class, CharSequence.class});
        methodsThatShouldExist_jdk6.put("matches", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("contains", new Class[]{CharSequence.class});
        methodsThatShouldExist_jdk6.put("replaceFirst", new Class[]{String.class, String.class});
        methodsThatShouldExist_jdk6.put("replaceAll", new Class[]{String.class, String.class});
        methodsThatShouldExist_jdk6.put("split", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("split", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("toLowerCase", new Class[]{Locale.class});
        methodsThatShouldExist_jdk6.put("toLowerCase", new Class[0]);
        methodsThatShouldExist_jdk6.put("toUpperCase", new Class[0]);
        methodsThatShouldExist_jdk6.put("toUpperCase", new Class[]{Locale.class});
        methodsThatShouldExist_jdk6.put("trim", new Class[0]);
        methodsThatShouldExist_jdk6.put("toCharArray", new Class[0]);
        methodsThatShouldExist_jdk6.put("format", new Class[]{Locale.class, String.class, new Object[0].getClass()});
        methodsThatShouldExist_jdk6.put("format", new Class[]{String.class, new Object[0].getClass()});
        methodsThatShouldExist_jdk6.put("copyValueOf", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("copyValueOf", new Class[]{new char[1].getClass()});
        methodsThatShouldExist_jdk6.put("intern", new Class[0]);
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("notify", new Class[0]);
        methodsThatShouldExist_jdk6.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("indexOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("indexOf", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("indexOf", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("indexOf", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Float.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Double.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{new char[1].getClass()});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("contentEquals", new Class[]{CharSequence.class});
        methodsThatShouldExist_jdk7.put("contentEquals", new Class[]{StringBuffer.class});
        methodsThatShouldExist_jdk7.put("charAt", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointAt", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointBefore", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointCount", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("compareToIgnoreCase", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("concat", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("contains", new Class[]{CharSequence.class});
        methodsThatShouldExist_jdk7.put("copyValueOf", new Class[]{new char[1].getClass()});
        methodsThatShouldExist_jdk7.put("copyValueOf", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("endsWith", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("equalsIgnoreCase", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("format", new Class[]{String.class, new Object[0].getClass()});
        methodsThatShouldExist_jdk7.put("format", new Class[]{Locale.class, String.class, new Object[0].getClass()});
        methodsThatShouldExist_jdk7.put("getBytes", new Class[0]);
        methodsThatShouldExist_jdk7.put("getBytes", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getBytes", new Class[]{Integer.TYPE, Integer.TYPE, new byte[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getBytes", new Class[]{Charset.class});
        methodsThatShouldExist_jdk7.put("getChars", new Class[]{Integer.TYPE, Integer.TYPE, new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("intern", new Class[0]);
        methodsThatShouldExist_jdk7.put("isEmpty", new Class[0]);
        methodsThatShouldExist_jdk7.put("lastIndexOf", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("lastIndexOf", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("lastIndexOf", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("lastIndexOf", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("length", new Class[0]);
        methodsThatShouldExist_jdk7.put("matches", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("offsetByCodePoints", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("regionMatches", new Class[]{Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("regionMatches", new Class[]{Boolean.TYPE, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("replace", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk7.put("replace", new Class[]{CharSequence.class, CharSequence.class});
        methodsThatShouldExist_jdk7.put("replaceAll", new Class[]{String.class, String.class});
        methodsThatShouldExist_jdk7.put("replaceFirst", new Class[]{String.class, String.class});
        methodsThatShouldExist_jdk7.put("split", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("split", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("startsWith", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("startsWith", new Class[]{String.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("subSequence", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("substring", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("substring", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toCharArray", new Class[0]);
        methodsThatShouldExist_jdk7.put("toLowerCase", new Class[0]);
        methodsThatShouldExist_jdk7.put("toLowerCase", new Class[]{Locale.class});
        methodsThatShouldExist_jdk7.put("toUpperCase", new Class[]{Locale.class});
        methodsThatShouldExist_jdk7.put("toUpperCase", new Class[0]);
        methodsThatShouldExist_jdk7.put("trim", new Class[0]);
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("notify", new Class[0]);
        methodsThatShouldExist_jdk7.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        String o = new String();
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

