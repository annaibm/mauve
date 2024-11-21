/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;

public class list
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button1 = new Button();
        button1.list();
        button1.list(System.out);
        button1.list(System.out, 0);
        button1.list(System.out, 10);
        Button button2 = new Button("xyzzy");
        button2.list();
        button2.list(System.out);
        button2.list(System.out, 0);
        button2.list(System.out, 10);
    }
}

