/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Dialog;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;

public class size
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dialog jd = new Dialog(new Frame());
        jd.show();
        jd.add(new Label("Hello world"));
        Dimension pref = jd.getPreferredSize();
        Dimension size2 = jd.getSize();
        System.err.println("size: " + size2);
        System.err.println("pref: " + pref);
        harness.check(size2.width >= pref.width);
        harness.check(size2.height >= pref.height);
    }
}

