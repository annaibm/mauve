/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;

public class getLineWidth
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.positiveTests(harness);
        this.negativeTests(harness);
    }

    public void positiveTests(TestHarness harness) {
        harness.checkPoint("positive tests");
        BasicStroke stroke = new BasicStroke();
        harness.check(stroke.getLineWidth(), 1.0);
        stroke = new BasicStroke(0.0f);
        harness.check(stroke.getLineWidth(), 0.0);
        stroke = new BasicStroke(10.0f);
        harness.check(stroke.getLineWidth(), 10.0);
        stroke = new BasicStroke(10.0f, 1, 1);
        harness.check(stroke.getLineWidth(), 10.0);
        stroke = new BasicStroke(10.0f, 1, 1, 1.0f);
        harness.check(stroke.getLineWidth(), 10.0);
    }

    public void negativeTests(TestHarness harness) {
        BasicStroke stroke;
        harness.checkPoint("positive tests");
        try {
            stroke = new BasicStroke(-10.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(-10.0f, 1, 1);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(-10.0f, 1, 1, 1.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

