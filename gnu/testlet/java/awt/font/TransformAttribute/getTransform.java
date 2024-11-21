/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TransformAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TransformAttribute;
import java.awt.geom.AffineTransform;

public class getTransform
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = AffineTransform.getTranslateInstance(1.2, 3.4);
        TransformAttribute ta = new TransformAttribute(t1);
        AffineTransform t2 = ta.getTransform();
        harness.check(t1, t2);
        t2.setToIdentity();
        AffineTransform t3 = ta.getTransform();
        harness.check(!t3.equals(t2));
    }
}

