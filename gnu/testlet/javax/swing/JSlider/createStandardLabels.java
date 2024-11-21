/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;
import javax.swing.JComponent;
import javax.swing.JSlider;

public class createStandardLabels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("createStandardLabels(int)");
        JSlider slider = new JSlider();
        Hashtable<Integer, JComponent> table2 = slider.createStandardLabels(10);
        harness.check(table2.containsKey(new Integer(0)));
        harness.check(table2.containsKey(new Integer(10)));
        harness.check(table2.containsKey(new Integer(20)));
        harness.check(table2.containsKey(new Integer(30)));
        harness.check(table2.containsKey(new Integer(40)));
        harness.check(table2.containsKey(new Integer(50)));
        harness.check(table2.containsKey(new Integer(60)));
        harness.check(table2.containsKey(new Integer(70)));
        harness.check(table2.containsKey(new Integer(80)));
        harness.check(table2.containsKey(new Integer(90)));
        harness.check(table2.containsKey(new Integer(100)));
        boolean pass = false;
        try {
            slider.createStandardLabels(0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider.createStandardLabels(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("createStandardLabels(int, int)");
        JSlider slider = new JSlider();
        Hashtable<Integer, JComponent> table2 = slider.createStandardLabels(10, 50);
        harness.check(table2.containsKey(new Integer(50)));
        harness.check(table2.containsKey(new Integer(60)));
        harness.check(table2.containsKey(new Integer(70)));
        harness.check(table2.containsKey(new Integer(80)));
        harness.check(table2.containsKey(new Integer(90)));
        harness.check(table2.containsKey(new Integer(100)));
        table2 = slider.createStandardLabels(10, 51);
        harness.check(table2.containsKey(new Integer(51)));
        harness.check(table2.containsKey(new Integer(61)));
        harness.check(table2.containsKey(new Integer(71)));
        harness.check(table2.containsKey(new Integer(81)));
        harness.check(table2.containsKey(new Integer(91)));
        table2 = slider.createStandardLabels(10, 100);
        harness.check(table2.containsKey(new Integer(100)));
        boolean pass = false;
        try {
            slider.createStandardLabels(0, 50);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider.createStandardLabels(-1, 50);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider.createStandardLabels(10, -50);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider.createStandardLabels(10, 110);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

