/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;

public class createInverse
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform();
        try {
            AffineTransform t2 = t1.createInverse();
            harness.check(t2.getType() == 0);
        }
        catch (NoninvertibleTransformException e) {
            harness.check(false);
        }
        t1 = new AffineTransform(7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        try {
            AffineTransform t3 = t1.createInverse();
            harness.check(t3.getScaleX(), -5.0);
            harness.check(t3.getShearX(), 4.5);
            harness.check(t3.getTranslateX(), 1.0);
            harness.check(t3.getShearY(), 4.0);
            harness.check(t3.getScaleY(), -3.5);
            harness.check(t3.getTranslateY(), -2.0);
        }
        catch (NoninvertibleTransformException e) {
            harness.check(false);
        }
        AffineTransform t4 = new AffineTransform(3.0, 3.0, 3.0, 3.0, 3.0, 3.0);
        try {
            AffineTransform t5 = t4.createInverse();
            harness.check(false);
        }
        catch (NoninvertibleTransformException e) {
            harness.check(true);
        }
    }
}

