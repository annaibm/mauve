/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class SetSize
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        JFrame f = new JFrame();
        f.setSize(new Dimension(170, 300));
        f.setVisible(true);
        try {
            Thread.sleep(200L);
        }
        catch (InterruptedException e) {
            return;
        }
        Insets i = f.getInsets();
        int w = f.getContentPane().getWidth();
        int h = f.getContentPane().getHeight();
        int x = f.getContentPane().getX();
        int y = f.getContentPane().getY();
        f.setVisible(false);
        f.dispose();
        harness.check(w + i.left + i.right == 170);
        harness.check(h + i.top + i.bottom == 300);
        harness.check(x == 0);
        harness.check(y == 0);
        f = new JFrame();
        f.setSize(new Dimension(170, 300));
        final Vector vars = new Vector(1);
        JComponent child = new JComponent(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void paint(Graphics g) {
                if (g.getClip() != null) {
                    vars.add(g.getClip());
                    Vector vector = vars;
                    synchronized (vector) {
                        vars.notifyAll();
                    }
                }
            }
        };
        f.getContentPane().add(child);
        f.setVisible(true);
        Vector vector = vars;
        synchronized (vector) {
            try {
                vars.wait(1000L);
            }
            catch (InterruptedException interruptedException) {
            }
            finally {
                w = f.getContentPane().getWidth();
                h = f.getContentPane().getHeight();
                f.setVisible(false);
                f.dispose();
            }
        }
        Rectangle r = (Rectangle)vars.get(0);
        harness.check(r != null);
        harness.check((double)w == r.getWidth());
        harness.check((double)h == r.getHeight());
    }
}

