/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;

public class list
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        choice.list();
        choice.list(System.out);
        choice.list(System.out, 0);
        choice.list(System.out, 10);
    }
}

