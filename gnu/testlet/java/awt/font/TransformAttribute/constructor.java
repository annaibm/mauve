/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TransformAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TransformAttribute;
import java.awt.geom.AffineTransform;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform identity = new AffineTransform();
        TransformAttribute t = new TransformAttribute(identity);
        harness.check(t.getTransform(), identity);
        harness.check(t.getTransform() != identity);
        AffineTransform at = AffineTransform.getTranslateInstance(1.2, 3.4);
        t = new TransformAttribute(at);
        harness.check(t.getTransform(), at);
        boolean pass = false;
        try {
            t = new TransformAttribute(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

