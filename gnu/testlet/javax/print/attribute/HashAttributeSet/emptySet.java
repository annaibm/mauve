/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.HashAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.print.attribute.HashAttributeSet.SimpleAttribute;
import javax.print.attribute.HashAttributeSet;

public class emptySet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashAttributeSet testSet = new HashAttributeSet();
        HashAttributeSet testSet2 = new HashAttributeSet();
        harness.check(testSet.equals(testSet2), true, "equals");
        harness.check(testSet.hashCode(), 0, "hashcode");
        harness.check(testSet.toArray().length, 0, "toArray");
        harness.check(testSet.isEmpty(), true, "isEmpty 1");
        testSet.add(new SimpleAttribute(1));
        testSet.remove(new SimpleAttribute(1).getCategory());
        harness.check(testSet.isEmpty(), true, "isEmpty 2");
    }
}

