/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.DebugGraphics;

public class update
implements Testlet {
    StringBuffer test = new StringBuffer();

    @Override
    public void test(TestHarness harness) {
        TopLevel t = new TopLevel();
        t.setLayout(new GridLayout());
        HeavyWeight h = new HeavyWeight();
        t.add(h);
        LightWeight l = new LightWeight();
        t.add(l);
        LightContainer c = new LightContainer();
        t.add(c);
        HeavyContainer c2 = new HeavyContainer();
        t.add(c2);
        t.setSize(200, 200);
        t.setVisible(true);
        TestGraphics g = new TestGraphics(t.getGraphics());
        try {
            Thread.sleep(3000L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.test = new StringBuffer();
        t.update(g);
        harness.check(this.test.toString(), "19284", this.test.toString());
        t.setVisible(false);
        t.dispose();
    }

    class TestGraphics
    extends DebugGraphics {
        TestGraphics(Graphics g) {
            super(g);
        }

        @Override
        public void clearRect(int x, int y, int w, int h) {
            update.this.test.append('9');
        }
    }

    class HeavyContainer
    extends Label {
        HeavyContainer() {
        }

        @Override
        public void update(Graphics g) {
            update.this.test.append('a');
            super.update(g);
        }

        @Override
        public void paint(Graphics g) {
            update.this.test.append('b');
            super.paint(g);
        }
    }

    class LightContainer
    extends Container {
        LightContainer() {
        }

        @Override
        public void update(Graphics g) {
            update.this.test.append('7');
            super.update(g);
        }

        @Override
        public void paint(Graphics g) {
            update.this.test.append('8');
            super.paint(g);
        }
    }

    class HeavyWeight
    extends Label {
        HeavyWeight() {
        }

        @Override
        public void update(Graphics g) {
            update.this.test.append('5');
            super.update(g);
        }

        @Override
        public void paint(Graphics g) {
            update.this.test.append('6');
            super.paint(g);
        }

        @Override
        public boolean isLightweight() {
            return false;
        }
    }

    class LightWeight
    extends Component {
        LightWeight() {
        }

        @Override
        public void update(Graphics g) {
            update.this.test.append('3');
            super.update(g);
        }

        @Override
        public void paint(Graphics g) {
            update.this.test.append('4');
            super.paint(g);
        }

        @Override
        public boolean isLightweight() {
            return true;
        }
    }

    class TopLevel
    extends Frame {
        TopLevel() {
        }

        @Override
        public void update(Graphics g) {
            update.this.test.append('1');
            super.update(g);
        }

        @Override
        public void paint(Graphics g) {
            update.this.test.append('2');
            super.paint(g);
        }
    }
}

