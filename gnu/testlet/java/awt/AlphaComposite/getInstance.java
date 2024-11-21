/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AlphaComposite;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AlphaComposite;

public class getInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(int)");
        AlphaComposite a = AlphaComposite.getInstance(1);
        harness.check(a.getRule(), 1);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(2);
        harness.check(a.getRule(), 2);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(9);
        harness.check(a.getRule(), 9);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(3);
        harness.check(a.getRule(), 3);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(4);
        harness.check(a.getRule(), 4);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(5);
        harness.check(a.getRule(), 5);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(6);
        harness.check(a.getRule(), 6);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(7);
        harness.check(a.getRule(), 7);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(8);
        harness.check(a.getRule(), 8);
        harness.check(a.getAlpha(), 1.0);
        boolean pass = false;
        try {
            a = AlphaComposite.getInstance(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            a = AlphaComposite.getInstance(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(int, float)");
        AlphaComposite a = AlphaComposite.getInstance(2, 0.123f);
        harness.check(a.getRule(), 2);
        harness.check(a.getAlpha(), 0.123f);
        boolean pass = false;
        try {
            AlphaComposite.getInstance(2, -0.01f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            AlphaComposite.getInstance(2, 1.01f);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

