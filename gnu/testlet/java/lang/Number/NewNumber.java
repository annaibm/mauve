/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Number;

class NewNumber
extends Number {
    private int intfld;

    public NewNumber() {
    }

    public NewNumber(int i) {
        this.intfld = i;
    }

    @Override
    public int intValue() {
        return this.intfld;
    }

    @Override
    public float floatValue() {
        return this.intfld;
    }

    @Override
    public double doubleValue() {
        return this.intfld;
    }

    @Override
    public long longValue() {
        return this.intfld;
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }
}

