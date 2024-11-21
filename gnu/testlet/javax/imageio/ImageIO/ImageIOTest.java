/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.ImageIO;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageIOTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        this.testStringData(h);
        h.checkPoint("Reading and writing of images.");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-32Bit.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-24Bit.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-16Bit.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-8Bit.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-4Bit.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-1Bit.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-RLE8.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-RLE4.bmp");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-1Bit.png");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-4Bit.png");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-8Bit.png");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-24Bit.png");
        this.testReadWrite(h, "gnu/testlet/javax/imageio/ImageIO/Bitmap-32Bit.png");
    }

    private void testStringData(TestHarness h) {
        String[] stringData = ImageIO.getReaderFormatNames();
        h.check(stringData.length != 0, "empty reader format names");
        stringData = ImageIO.getReaderMIMETypes();
        h.check(stringData.length != 0, "empty reader mime types");
        stringData = ImageIO.getWriterFormatNames();
        h.check(stringData.length != 0, "empty writer format names");
        stringData = ImageIO.getWriterMIMETypes();
        h.check(stringData.length != 0, "empty writer mime types");
    }

    private void testReadWrite(TestHarness h, String picPath) {
        boolean exceptionCaught = false;
        try {
            BufferedImage image = ImageIO.read(new File(picPath));
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            int size2 = width * height;
            int[] pixels = new int[size2];
            int[] outPixels = new int[size2];
            String path = "gnu/testlet/javax/imageio/ImageIO/outputBitmap.bmp";
            if (ImageIO.write((RenderedImage)image, "bmp", new File(path))) {
                BufferedImage outImage = ImageIO.read(new File(path));
                PixelGrabber pg1 = new PixelGrabber(outImage, 0, 0, width, height, outPixels, 0, width);
                PixelGrabber pg2 = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
                pg1.grabPixels();
                pg2.grabPixels();
                h.check(this.comparePixels(pixels, outPixels, size2));
            }
        }
        catch (Exception e) {
            exceptionCaught = true;
        }
        h.check(!exceptionCaught);
    }

    private boolean comparePixels(int[] a, int[] b, int size2) {
        for (int i = 0; i < size2; ++i) {
            if (a[i] == b[i]) continue;
            return false;
        }
        return true;
    }
}

