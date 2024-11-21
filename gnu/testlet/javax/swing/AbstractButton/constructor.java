/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness h) {
        MyButton b = new MyButton();
        ButtonModel m = b.getModel();
        h.check(m, null);
        h.check(b.getText(), (Object)"");
    }

    class MyButton
    extends AbstractButton {
        MyButton() {
        }
    }
}

