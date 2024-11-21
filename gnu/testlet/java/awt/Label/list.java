/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Label;

public class list
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label12 = new Label();
        label12.list();
        label12.list(System.out);
        label12.list(System.out, 0);
        label12.list(System.out, 10);
        Label label2 = new Label("xyzzy");
        label2.list();
        label2.list(System.out);
        label2.list(System.out, 0);
        label2.list(System.out, 10);
        Label label3 = new Label("xyzzy", 1);
        label3.list();
        label3.list(System.out);
        label3.list(System.out, 0);
        label3.list(System.out, 10);
        Label label4 = new Label("xyzzy", 0);
        label4.list();
        label4.list(System.out);
        label4.list(System.out, 0);
        label4.list(System.out, 10);
        Label label5 = new Label("xyzzy", 2);
        label5.list();
        label5.list(System.out);
        label5.list(System.out, 0);
        label5.list(System.out, 10);
    }
}

