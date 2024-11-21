/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.HashAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;

public class nullTests
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("constructor tests");
        try {
            new HashAttributeSet((Attribute)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new HashAttributeSet((AttributeSet)null);
            harness.check(true);
        }
        catch (NullPointerException e) {
            harness.check(false);
        }
        try {
            new HashAttributeSet((Attribute[])null);
            harness.check(true);
        }
        catch (NullPointerException e) {
            harness.check(false);
        }
        try {
            new HashAttributeSet(new Attribute[]{null});
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        harness.checkPoint("method tests");
        HashAttributeSet testSet = new HashAttributeSet();
        try {
            testSet.get(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            testSet.add(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            testSet.addAll(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        harness.check(testSet.remove((Attribute)null), false);
        harness.check(testSet.remove((Class)null), false);
        harness.check(testSet.containsKey(null), false);
        harness.check(testSet.containsValue(null), false);
    }
}

