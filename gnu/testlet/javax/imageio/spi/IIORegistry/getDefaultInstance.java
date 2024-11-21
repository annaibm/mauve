/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.IIORegistry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.imageio.spi.IIORegistry;

public class getDefaultInstance
implements Testlet {
    @Override
    public void test(TestHarness h) {
        IIORegistry registry = IIORegistry.getDefaultInstance();
        h.check(registry != null);
    }
}

