/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Desktop;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Desktop;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PR34580
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            Method m = Desktop.class.getMethod("isDesktopSupported", new Class[0]);
            m.invoke(null, new Object[0]);
            h.check(true, "isDesktopSupported() accessed successfully.");
        }
        catch (IllegalAccessException e) {
            h.debug(e);
            h.fail("isDesktopSupported() could not be accessed.");
        }
        catch (NoSuchMethodException e) {
            h.debug(e);
            h.fail("isDesktopSupported() is not implemented.");
        }
        catch (InvocationTargetException e) {
            h.debug(e);
            h.fail("isDesktopSupported() threw an exception: " + e);
        }
    }
}

