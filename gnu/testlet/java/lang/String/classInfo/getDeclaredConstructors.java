/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class getDeclaredConstructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredConstructors = null;
        HashMap<String, String> testedDeclaredConstructors_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredConstructors_jdk7 = new HashMap<String, String>();
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],java.nio.charset.Charset)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],java.lang.String) throws java.io.UnsupportedEncodingException", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],int,int,java.nio.charset.Charset)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],int,int,java.lang.String) throws java.io.UnsupportedEncodingException", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("java.lang.String(int,int,char[])", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(java.lang.StringBuilder)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(java.lang.StringBuffer)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[])", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(int[],int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String()", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(char[])", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(java.lang.String)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(char[],int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],int)", "java.lang.String");
        testedDeclaredConstructors_jdk6.put("public java.lang.String(byte[],int,int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[])", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],java.nio.charset.Charset)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],java.lang.String) throws java.io.UnsupportedEncodingException", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],int,int,java.nio.charset.Charset)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("java.lang.String(int,int,char[])", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("java.lang.String(char[],boolean)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(java.lang.StringBuilder)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(java.lang.StringBuffer)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(int[],int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(char[],int,int)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(char[])", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(java.lang.String)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String()", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],int,int,java.lang.String) throws java.io.UnsupportedEncodingException", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],int)", "java.lang.String");
        testedDeclaredConstructors_jdk7.put("public java.lang.String(byte[],int,int,int)", "java.lang.String");
        String o = new String();
        Class<?> c = o.getClass();
        testedDeclaredConstructors = this.getJavaVersion() < 7 ? testedDeclaredConstructors_jdk6 : testedDeclaredConstructors_jdk7;
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        int expectedNumberOfConstructors = testedDeclaredConstructors.size();
        harness.check(declaredConstructors.length, expectedNumberOfConstructors);
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            String constructorName = declaredConstructor.getName();
            String constructorString2 = declaredConstructor.toString().replaceAll(" native ", " ");
            harness.check(testedDeclaredConstructors.containsKey(constructorString2));
            harness.check(testedDeclaredConstructors.get(constructorString2), (Object)constructorName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

