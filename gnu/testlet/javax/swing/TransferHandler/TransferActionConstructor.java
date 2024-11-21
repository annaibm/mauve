/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.TransferHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.TransferHandler;

public class TransferActionConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Action a = TransferHandler.getCopyAction();
        harness.check(a.getValue("Name").equals("copy"));
    }
}

