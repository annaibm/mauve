/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;

public class list
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox1 = new Checkbox();
        checkbox1.list();
        checkbox1.list(System.out);
        checkbox1.list(System.out, 0);
        checkbox1.list(System.out, 10);
        Checkbox checkbox2 = new Checkbox("xyzzy");
        checkbox2.list();
        checkbox2.list(System.out);
        checkbox2.list(System.out, 0);
        checkbox2.list(System.out, 10);
    }
}

