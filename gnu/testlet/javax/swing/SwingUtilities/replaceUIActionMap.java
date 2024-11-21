/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SwingUtilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ActionMap;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;

public class replaceUIActionMap
implements Testlet {
    static int howManyMaps(JComponent t) {
        int num = 0;
        for (ActionMap curr = t.getActionMap(); curr != null; curr = curr.getParent()) {
            ++num;
        }
        return num;
    }

    @Override
    public void test(TestHarness harness) {
        JTable t = new JTable();
        harness.check(replaceUIActionMap.howManyMaps(t) == 2);
        ActionMap map1 = SwingUtilities.getUIActionMap(t);
        map1.setParent(new ActionMap());
        harness.check(replaceUIActionMap.howManyMaps(t) == 3);
        ActionMapUIResource map2 = new ActionMapUIResource();
        SwingUtilities.replaceUIActionMap(t, map2);
        harness.check(replaceUIActionMap.howManyMaps(t) == 2);
    }
}

