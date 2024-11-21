/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.AttributeSetUtilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.AttributeSetUtilities;

public class simple
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("NPE tests");
        try {
            AttributeSetUtilities.synchronizedView((AttributeSet)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            AttributeSetUtilities.unmodifiableView((AttributeSet)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        harness.checkPoint("casting tests");
        try {
            AttributeSetUtilities.verifyAttributeCategory(SimpleAttribute.class, Attribute.class);
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            AttributeSetUtilities.verifyAttributeCategory(String.class, Attribute.class);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            AttributeSetUtilities.verifyAttributeValue(new SimpleAttribute(1), Attribute.class);
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            AttributeSetUtilities.verifyAttributeValue(new String(), Attribute.class);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            AttributeSetUtilities.verifyCategoryForValue(SimpleAttribute.class, new SimpleAttribute(1));
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            AttributeSetUtilities.verifyCategoryForValue(String.class, new SimpleAttribute(1));
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    class SimpleAttribute
    implements Attribute {
        private int value;

        public SimpleAttribute(int value2) {
            this.value = value2;
        }

        public Class getCategory() {
            return this.getClass();
        }

        @Override
        public String getName() {
            return "SimpleAttribute";
        }

        public boolean equals(Object obj) {
            if (obj instanceof SimpleAttribute) {
                SimpleAttribute att = (SimpleAttribute)obj;
                if (att.value == this.value) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.value;
        }
    }
}

