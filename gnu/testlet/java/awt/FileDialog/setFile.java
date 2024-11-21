/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FileDialog;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FileDialog;
import java.awt.Frame;

public class setFile
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        FileDialog fd = new FileDialog(new Frame());
        fd.setFile("String");
        harness.check(fd.getFile(), (Object)"String");
    }

    public void test2(TestHarness harness) {
        FileDialog fd = new FileDialog(new Frame());
        fd.setFile(null);
        harness.check(fd.getFile(), null);
    }

    public void test3(TestHarness harness) {
        FileDialog fd = new FileDialog(new Frame());
        fd.setFile("");
        harness.check(fd.getFile(), null);
    }
}

