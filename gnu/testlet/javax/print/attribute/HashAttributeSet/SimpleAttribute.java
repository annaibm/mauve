/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.HashAttributeSet;

import javax.print.attribute.Attribute;

public class SimpleAttribute
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

