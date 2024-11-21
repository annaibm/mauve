/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.HashAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.print.attribute.HashAttributeSet.AnotherSimpleAttribute;
import gnu.testlet.javax.print.attribute.HashAttributeSet.SimpleAttribute;
import javax.print.attribute.Attribute;
import javax.print.attribute.HashAttributeSet;

public class populatedSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttribute att1 = new SimpleAttribute(1);
        HashAttributeSet testSet = new HashAttributeSet(att1);
        harness.check(testSet.containsValue(att1), true, "containsValue");
        harness.check(testSet.containsKey(att1.getCategory()), true, "containsKey");
        harness.check(testSet.remove(att1), true, "remove");
        harness.check(testSet.isEmpty(), true, "isEmpty");
        harness.check(testSet.add(att1), true, "add");
        harness.check(testSet.add(att1), false, "re-add");
        SimpleAttribute att2 = new SimpleAttribute(3);
        Attribute[] array = new SimpleAttribute[]{new SimpleAttribute(2), att2};
        testSet = new HashAttributeSet(array);
        harness.check(testSet.size(), 1, "size");
        harness.check(testSet.hashCode(), 3, "hashcode");
        harness.check(testSet.containsValue(att2), true, "containsValue");
        AnotherSimpleAttribute att3 = new AnotherSimpleAttribute(4);
        harness.check(testSet.add(att3), true, "add");
        harness.check(testSet.size(), 2, "size");
        harness.check(testSet.hashCode(), 7, "hashcode");
        HashAttributeSet testSet2 = new HashAttributeSet();
        testSet2.add(att2);
        testSet2.add(att3);
        harness.check(testSet.equals(testSet2), true, "equals");
        harness.check(testSet2.addAll(testSet), false, "addAll");
        testSet2.clear();
        harness.check(testSet2.isEmpty(), true, "isEmpty");
        testSet = new HashAttributeSet();
        testSet.add(new SimpleAttribute(1));
        testSet.add(new AnotherSimpleAttribute(2));
        testSet2 = new HashAttributeSet();
        testSet2.add(new SimpleAttribute(2));
        testSet2.add(new AnotherSimpleAttribute(1));
        harness.check(testSet.hashCode() == testSet2.hashCode(), "equal hashcode");
        harness.check(testSet.equals(testSet2), false, "no equality");
    }
}

