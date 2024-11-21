/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;

public abstract class Base
implements Testlet {
    protected TestHarness myHarness = null;
    protected final boolean doCleanUP = false;
    protected String fileName = null;
    protected File aktFile;
    protected boolean isEnabled = true;
    protected boolean forceAll = true;

    @Override
    public void test(TestHarness harness) {
        if (!this.isEnabled && !this.forceAll) {
            System.out.println("\t\tTest Disabled...");
            return;
        }
        this.myHarness = harness;
        if (this.fileName != null) {
            this.aktFile = new File(this.myHarness.getTempDirectory() + this.myHarness.getSeparator() + this.fileName);
            this.myHarness.debug("Using file: " + this.aktFile.toString());
            this.getClass();
        }
        try {
            this.doTest();
        }
        catch (Throwable e) {
            e.printStackTrace();
            this.myHarness.fail(e.toString());
        }
    }

    protected void setDefaultFilename() {
        this.fileName = this.getClass().getName() + ".txt";
    }

    protected abstract void doTest();
}

