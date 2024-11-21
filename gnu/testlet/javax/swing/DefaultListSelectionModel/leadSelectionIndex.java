/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class leadSelectionIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultListModel<String> v = new DefaultListModel<String>();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        JList a = new JList(v);
        a.setSelectionMode(0);
        a.setSelectedIndex(1);
        a.getSelectionModel().setLeadSelectionIndex(3);
        if (a.getSelectedIndices().length != 1 || a.getSelectedIndices()[0] != 3) {
            harness.fail("setLeadSelectionIndex should check the selection mode");
        }
    }
}

