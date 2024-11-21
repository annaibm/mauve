/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class addItemListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        choice.setBackground(Color.blue);
        ItemListener[] itemListeners = choice.getItemListeners();
        harness.check(itemListeners.length, 0);
        choice.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
            }

            public String toString() {
                return "myItemListener";
            }
        });
        itemListeners = choice.getItemListeners();
        harness.check(itemListeners.length, 1);
        harness.check(itemListeners[0].toString(), (Object)"myItemListener");
    }
}

