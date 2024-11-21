/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.SimpleBeanInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.SimpleBeanInfo.MySimpleBeanInfo;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.image.ImageObserver;

public class loadImage
implements Testlet,
ImageObserver {
    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
    }

    @Override
    public void test(TestHarness harness) {
        MySimpleBeanInfo i = new MySimpleBeanInfo();
        Image image = i.loadImage("testImage1.gif");
        MediaTracker mt = new MediaTracker(new Panel());
        mt.addImage(image, 0);
        try {
            mt.waitForAll();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        harness.check(!mt.isErrorAny());
        harness.check(image.getWidth(null), 2);
        harness.check(image.getHeight(null), 2);
        harness.check(i.loadImage("someImageThatDoesNotExist.png"), null);
        harness.check(i.loadImage(null), null);
    }
}

