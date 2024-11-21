/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.List;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class addItemListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        List list2 = new List(10);
        list2.setBackground(Color.blue);
        ItemListener[] itemListeners = list2.getItemListeners();
        harness.check(itemListeners.length, 0);
        list2.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
            }

            public String toString() {
                return "myItemListener";
            }
        });
        itemListeners = list2.getItemListeners();
        harness.check(itemListeners.length, 1);
        harness.check(itemListeners[0].toString(), (Object)"myItemListener");
    }
}

