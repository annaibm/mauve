/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Logger;

public class global
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(Logger.global != null);
        h.check(Logger.global.getName(), (Object)"global");
    }
}

