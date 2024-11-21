/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTabbedPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.UIResource;

public class remove
implements Testlet {
    boolean touched_removeTabAt;
    boolean touched_remove;

    @Override
    public void test(TestHarness harness) {
        MyTabbedPane tp = new MyTabbedPane();
        harness.checkPoint("remove");
        this.touched_remove = false;
        this.touched_removeTabAt = false;
        JPanel p = new MyPanel();
        tp.add(p);
        tp.remove(p);
        harness.check(this.touched_remove, false);
        harness.check(this.touched_removeTabAt, false);
        this.touched_remove = false;
        this.touched_removeTabAt = false;
        p = new MyPanel();
        tp.addTab("foo", p);
        tp.remove(p);
        harness.check(this.touched_remove, false);
        harness.check(this.touched_removeTabAt, true);
        this.touched_remove = false;
        this.touched_removeTabAt = false;
        p = new JPanel();
        tp.add(p);
        tp.remove(p);
        harness.check(this.touched_remove, false);
        harness.check(this.touched_removeTabAt, true);
    }

    class MyTabbedPane
    extends JTabbedPane {
        MyTabbedPane() {
        }

        @Override
        public void remove(int i) {
            remove.this.touched_remove = true;
            super.remove(i);
        }

        @Override
        public void removeTabAt(int i) {
            remove.this.touched_removeTabAt = true;
            super.removeTabAt(i);
        }
    }

    static class MyPanel
    extends JPanel
    implements UIResource {
        MyPanel() {
        }
    }
}

