/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.standard.MediaSize;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;

public class userClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MediaSizeName name2 = MediaSize.findMedia(111.0f, 222.0f, 25400);
        harness.check(name2 == MediaSizeName.JIS_B0);
        MyMediaSize myMediaSize = new MyMediaSize(111.0f, 222.0f, 25400);
        MediaSizeName name22 = MediaSize.findMedia(111.0f, 222.0f, 25400);
        harness.check(name22 == null);
    }

    public class MyMediaSize
    extends MediaSize {
        public MyMediaSize(float x, float y, int units) {
            super(x, y, units);
        }
    }
}

