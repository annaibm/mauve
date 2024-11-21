/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class VisualTestlet
implements Testlet {
    @Override
    public void test(TestHarness h) {
        Frame f;
        Component c = this.getTestComponent();
        if (c instanceof JComponent) {
            JFrame jFrame = new JFrame();
            jFrame.setContentPane((JComponent)c);
            f = jFrame;
        } else {
            f = new Frame();
            f.add(c);
        }
        f.pack();
        f.setVisible(true);
        System.out.println("====================================================");
        System.out.print("This is a test that needs human interaction. Please ");
        System.out.print("read the instructions carefully and follow them. ");
        System.out.print("Then check if your results match the expected results. ");
        System.out.print("Type p <ENTER> if the test showed the expected results,");
        System.out.println(" f <ENTER> otherwise.");
        System.out.println("====================================================");
        System.out.println("INSTRUCTIONS:");
        System.out.println(this.getInstructions());
        System.out.println("====================================================");
        System.out.println("EXPECTED RESULTS:");
        System.out.println(this.getExpectedResults());
        System.out.println("====================================================");
        System.out.println("(P)ASS or (F)AIL ?");
        block2: while (true) {
            try {
                int ch;
                do {
                    if ((ch = System.in.read()) != 80 && ch != 112) continue;
                    h.check(true);
                    break block2;
                } while (ch != 102 && ch != 70);
                h.check(false);
            }
            catch (IOException ex) {
                h.debug(ex);
                h.fail("Unexpected IO problem on console");
                continue;
            }
            break;
        }
    }

    public abstract String getInstructions();

    public abstract String getExpectedResults();

    public abstract Component getTestComponent();
}

