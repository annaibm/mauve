/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Logger;

public class getParent
implements Testlet {
    @Override
    public void test(TestHarness h) {
        Logger abcde = Logger.getLogger("a.b.c.d.e");
        Logger abc = Logger.getLogger("a.b.c");
        Logger ab = Logger.getLogger("a.b");
        Logger a = Logger.getLogger("a");
        Logger ax = Logger.getLogger("a.x");
        Logger axy = Logger.getLogger("a.x.y");
        Logger axyzw = Logger.getLogger("a.x.y.z.w");
        h.check(abcde.getParent(), abc);
        h.check(abc.getParent(), ab);
        h.check(ab.getParent(), a);
        h.check(ax.getParent(), a);
        h.check(axy.getParent(), ax);
        h.check(axyzw.getParent(), axy);
        Logger root = Logger.getLogger("");
        Logger anon = Logger.getAnonymousLogger();
        h.check(a.getParent(), root);
        h.check(anon.getParent(), root);
    }
}

