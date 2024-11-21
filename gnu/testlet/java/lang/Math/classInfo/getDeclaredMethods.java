/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

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
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.abs(double)", "abs");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.abs(float)", "abs");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Math.abs(long)", "abs");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Math.abs(int)", "abs");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.sin(double)", "sin");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.cos(double)", "cos");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.tan(double)", "tan");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.atan2(double,double)", "atan2");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.sqrt(double)", "sqrt");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.log(double)", "log");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.log10(double)", "log10");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.pow(double,double)", "pow");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.exp(double)", "exp");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.min(double,double)", "min");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.min(float,float)", "min");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Math.min(long,long)", "min");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Math.min(int,int)", "min");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Math.max(long,long)", "max");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Math.max(int,int)", "max");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.max(double,double)", "max");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.max(float,float)", "max");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.scalb(double,int)", "scalb");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.scalb(float,int)", "scalb");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Math.getExponent(double)", "getExponent");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Math.getExponent(float)", "getExponent");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.signum(double)", "signum");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.signum(float)", "signum");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.asin(double)", "asin");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.acos(double)", "acos");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.atan(double)", "atan");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.toRadians(double)", "toRadians");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.toDegrees(double)", "toDegrees");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.cbrt(double)", "cbrt");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.IEEEremainder(double,double)", "IEEEremainder");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.ceil(double)", "ceil");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.floor(double)", "floor");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.rint(double)", "rint");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Math.round(double)", "round");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Math.round(float)", "round");
        testedDeclaredMethods_jdk6.put("private static synchronized void java.lang.Math.initRNG()", "initRNG");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.random()", "random");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.ulp(float)", "ulp");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.ulp(double)", "ulp");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.sinh(double)", "sinh");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.cosh(double)", "cosh");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.tanh(double)", "tanh");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.hypot(double,double)", "hypot");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.expm1(double)", "expm1");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.log1p(double)", "log1p");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.copySign(double,double)", "copySign");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.copySign(float,float)", "copySign");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.nextAfter(float,double)", "nextAfter");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.nextAfter(double,double)", "nextAfter");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Math.nextUp(float)", "nextUp");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Math.nextUp(double)", "nextUp");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.abs(double)", "abs");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.abs(float)", "abs");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Math.abs(long)", "abs");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Math.abs(int)", "abs");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.sin(double)", "sin");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.cos(double)", "cos");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.tan(double)", "tan");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.atan2(double,double)", "atan2");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.sqrt(double)", "sqrt");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.log(double)", "log");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.log10(double)", "log10");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.pow(double,double)", "pow");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.exp(double)", "exp");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.min(double,double)", "min");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.min(float,float)", "min");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Math.min(long,long)", "min");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Math.min(int,int)", "min");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Math.max(long,long)", "max");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Math.max(int,int)", "max");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.max(double,double)", "max");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.max(float,float)", "max");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.scalb(double,int)", "scalb");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.scalb(float,int)", "scalb");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Math.getExponent(double)", "getExponent");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Math.getExponent(float)", "getExponent");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.signum(float)", "signum");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.signum(double)", "signum");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.IEEEremainder(double,double)", "IEEEremainder");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.acos(double)", "acos");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.asin(double)", "asin");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.atan(double)", "atan");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.cbrt(double)", "cbrt");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.ceil(double)", "ceil");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.copySign(float,float)", "copySign");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.copySign(double,double)", "copySign");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.cosh(double)", "cosh");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.expm1(double)", "expm1");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.floor(double)", "floor");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.hypot(double,double)", "hypot");
        testedDeclaredMethods_jdk7.put("private static synchronized java.util.Random java.lang.Math.initRNG()", "initRNG");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.log1p(double)", "log1p");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.nextAfter(float,double)", "nextAfter");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.nextAfter(double,double)", "nextAfter");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.nextUp(double)", "nextUp");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.nextUp(float)", "nextUp");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.random()", "random");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.rint(double)", "rint");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Math.round(float)", "round");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Math.round(double)", "round");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.sinh(double)", "sinh");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.tanh(double)", "tanh");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.toDegrees(double)", "toDegrees");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.toRadians(double)", "toRadians");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Math.ulp(double)", "ulp");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Math.ulp(float)", "ulp");
        Class<Math> c = Math.class;
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

