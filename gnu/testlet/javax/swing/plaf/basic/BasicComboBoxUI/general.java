/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import javax.swing.JComboBox;
import javax.swing.JList;

public class general
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox cb = new JComboBox();
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        cb.setUI(ui);
        JList list1 = ui.getListBoxField();
        JList<Object> list2 = ui.getComboPopupField().getList();
        harness.check(list1 == list2);
    }
}

