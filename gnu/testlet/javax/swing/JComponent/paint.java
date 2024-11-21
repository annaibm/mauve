/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class paint
implements Testlet {
    StringBuffer callOrder = new StringBuffer();

    @Override
    public void test(TestHarness harness) {
        JFrame f = new JFrame();
        TestComponent c = new TestComponent();
        f.setContentPane(c);
        f.setSize(100, 100);
        f.setVisible(true);
        this.callOrder.delete(0, this.callOrder.length());
        Graphics g = c.getGraphics();
        c.paint(g);
        harness.check(this.callOrder.toString().startsWith("123"));
        f.dispose();
    }

    class TestComponent
    extends JComponent {
        TestComponent() {
        }

        @Override
        protected void paintComponent(Graphics g) {
            paint.this.callOrder.append('1');
        }

        @Override
        protected void paintBorder(Graphics g) {
            paint.this.callOrder.append('2');
        }

        @Override
        protected void paintChildren(Graphics g) {
            paint.this.callOrder.append('3');
        }
    }
}

