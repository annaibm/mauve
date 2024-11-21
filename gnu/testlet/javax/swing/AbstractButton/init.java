/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.AbstractButton;
import javax.swing.Icon;

public class init
implements Testlet {
    @Override
    public void test(TestHarness h) {
        MyButton b = new MyButton();
        b.init(null, null);
        h.check(b.getText(), "", "AbstractButton.text is \"\" per default");
    }

    class MyButton
    extends AbstractButton {
        MyButton() {
        }

        @Override
        public void init(String s, Icon i) {
            super.init(s, i);
        }
    }
}

