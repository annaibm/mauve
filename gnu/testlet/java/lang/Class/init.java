/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class init
implements Testlet {
    static boolean initI = false;
    static boolean initC1 = false;
    static boolean initC2 = false;
    static boolean initC3 = false;
    static boolean initC4 = false;
    static boolean initC5 = false;
    static boolean invokedM = false;

    @Override
    public void test(TestHarness h) {
        try {
            Class<?> i = new I[0].getClass().getComponentType();
            Method m = i.getDeclaredMethod("m", null);
            Field f = Class.forName(this.getClass().getName() + "$C5", false, this.getClass().getClassLoader()).getField("i");
            h.check(!initC2);
            h.check(!initC3);
            if (C3.l == 123L) {
                this.hashCode();
            }
            h.check(initC2);
            h.check(initC3);
            h.check(!initC4);
            if (C4.m2()) {
                this.hashCode();
            }
            h.check(initC4);
            h.check(!initC5);
            f.set(null, new Character('\uffff'));
            h.check(C5.i == 65535);
            h.check(initC5);
            h.check(!initC1);
            C1 o = new C1();
            h.check(initC1);
            h.check(!initI);
            h.check(!invokedM);
            m.invoke((Object)o, null);
            h.check(initI);
            h.check(invokedM);
        }
        catch (NoSuchMethodException nsme) {
            h.debug(nsme);
            h.check(false);
        }
        catch (NoSuchFieldException e) {
            h.debug(e);
            h.check(false);
        }
        catch (InvocationTargetException ite) {
            h.debug(ite);
            h.check(false);
        }
        catch (IllegalAccessException iae) {
            h.debug(iae);
            h.check(false);
        }
        catch (ClassNotFoundException e) {
            h.debug(e);
            h.check(false);
        }
    }

    static long initI() {
        initI = true;
        return 5L;
    }

    static long initC1() {
        initC1 = true;
        return 5L;
    }

    static long initC2() {
        initC2 = true;
        return 5L;
    }

    static long initC3() {
        initC3 = true;
        return 5L;
    }

    static long initC4() {
        initC4 = true;
        return 5L;
    }

    static long initC5() {
        initC5 = true;
        return 5L;
    }

    static class C5
    extends C4 {
        static long l = init.initC5();
        public static int i;

        C5() {
        }
    }

    static class C4
    extends C2 {
        static long l = init.initC4();

        C4() {
        }

        static boolean m2() {
            return true;
        }
    }

    static class C3
    extends C2 {
        static long l = init.initC3();

        C3() {
        }
    }

    static class C2
    implements I {
        static long l = init.initC2();

        C2() {
        }

        @Override
        public void m() {
        }
    }

    static class C1
    implements I {
        static long l = init.initC1();

        C1() {
        }

        @Override
        public void m() {
            invokedM = true;
        }
    }

    static interface I {
        public static final long l = init.initI();

        public void m();
    }
}

