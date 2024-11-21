/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TransformAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TransformAttribute;
import java.awt.geom.AffineTransform;

public class isIdentity
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform();
        TransformAttribute ta = new TransformAttribute(t1);
        harness.check(ta.isIdentity());
        AffineTransform t2 = AffineTransform.getTranslateInstance(1.2, 3.4);
        ta = new TransformAttribute(t2);
        harness.check(!ta.isIdentity());
    }
}

