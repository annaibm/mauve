/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class addItemListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        ItemListener[] itemListeners = checkbox.getItemListeners();
        harness.check(itemListeners.length, 0);
        checkbox.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
            }

            public String toString() {
                return "myItemListener";
            }
        });
        itemListeners = checkbox.getItemListeners();
        harness.check(itemListeners.length, 1);
        harness.check(itemListeners[0].toString(), (Object)"myItemListener");
    }
}

