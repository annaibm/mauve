/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.PixelGrabber;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ImageProducer;
import java.awt.image.PixelGrabber;

public class testNullProducer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean exCaught = false;
        try {
            new PixelGrabber((ImageProducer)null, 0, 0, 0, 0, new int[5], 0, 0);
        }
        catch (NullPointerException npe) {
            exCaught = true;
        }
        harness.check(!exCaught);
    }
}

