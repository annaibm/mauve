/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class ProxyUtils {
    static boolean compareMethodExceptedDeclaringClass(Method lhs, Method rhs) {
        if (!lhs.getName().equals(rhs.getName())) {
            return false;
        }
        if (lhs.getReturnType() != rhs.getReturnType()) {
            return false;
        }
        return Arrays.equals(lhs.getParameterTypes(), rhs.getParameterTypes());
    }

    static boolean compareMethodOnNameAndParameterTypes(Method lhs, Method rhs) {
        if (!lhs.getName().equals(rhs.getName())) {
            return false;
        }
        return Arrays.equals(lhs.getParameterTypes(), rhs.getParameterTypes());
    }

    public static Object getNeutralValue(Class returnType) throws InstantiationException, IllegalAccessException {
        if (returnType.equals(Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (returnType.equals(Integer.TYPE)) {
            return new Integer(0);
        }
        if (returnType.equals(Float.TYPE)) {
            return new Float(0.0f);
        }
        if (returnType.equals(Double.TYPE)) {
            return new Double(0.0);
        }
        if (returnType.equals(Character.TYPE)) {
            return new Character('\u0000');
        }
        if (returnType.equals(Short.TYPE)) {
            return new Short(0);
        }
        if (returnType.equals(Long.TYPE)) {
            return new Long(0L);
        }
        if (returnType.equals(Void.TYPE)) {
            return null;
        }
        return returnType.newInstance();
    }
}

