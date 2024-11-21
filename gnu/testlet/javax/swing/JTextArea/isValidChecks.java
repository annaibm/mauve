/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextArea;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class isValidChecks
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFrame jf = new JFrame();
        JTextArea area = new JTextArea(20, 45);
        JScrollPane scrollpane = new JScrollPane(area);
        Robot r = null;
        try {
            r = new Robot();
        }
        catch (AWTException e) {
            harness.fail("caught AWTException: " + e.getMessage());
        }
        jf.setContentPane(scrollpane);
        for (int i = 0; i < 80; ++i) {
            area.append("line#" + i + "\n");
        }
        r.waitForIdle();
        jf.pack();
        r.waitForIdle();
        harness.checkPoint("append checks");
        area.append("");
        r.waitForIdle();
        harness.check(area.isValid(), true);
        area.append("lineNEw\n");
        r.waitForIdle();
        harness.check(area.isValid(), false);
        area.validate();
        harness.checkPoint("setRows checks");
        area.setRows(area.getRows());
        r.waitForIdle();
        harness.check(area.isValid(), true);
        area.setRows(area.getRows() + 1);
        r.waitForIdle();
        harness.check(area.isValid(), false);
        area.validate();
        harness.checkPoint("setColumns checks");
        area.setColumns(area.getColumns());
        r.waitForIdle();
        harness.check(area.isValid(), true);
        area.setColumns(area.getColumns() + 1);
        r.waitForIdle();
        harness.check(area.isValid(), false);
    }
}

