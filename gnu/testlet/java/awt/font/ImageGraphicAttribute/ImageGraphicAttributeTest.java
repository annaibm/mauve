/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.ImageGraphicAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.ImageGraphicAttribute;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageGraphicAttributeTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            BufferedImage image = ImageIO.read(new File("gnu/testlet/java/awt/font/ImageGraphicAttribute/image.bmp"));
            ImageGraphicAttribute iga = new ImageGraphicAttribute(image, 0);
            harness.check(iga.hashCode(), image.hashCode());
            harness.check(iga.getAscent(), 0.0);
            harness.check(iga.getDescent(), 64.0);
            harness.check(iga.getAdvance(), 127.0);
            harness.check(iga.getBounds(), new Rectangle2D.Float(-0.0f, -0.0f, 127.0f, 64.0f));
            ImageGraphicAttribute iga2 = new ImageGraphicAttribute(image, 0, 10.0f, -1202.0f);
            harness.check(iga2.hashCode(), image.hashCode());
            harness.check(iga2.getAscent(), 0.0);
            harness.check(iga2.getDescent(), 1266.0);
            harness.check(iga2.getAdvance(), 117.0);
            harness.check(iga2.getBounds(), new Rectangle2D.Float(-10.0f, 1202.0f, 127.0f, 64.0f));
            harness.check(iga.equals(iga2), false);
        }
        catch (Exception e) {
            harness.fail("Exception caught: " + e);
        }
    }
}

