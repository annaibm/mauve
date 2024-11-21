/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;

public class GetPrimitiveArrayType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType<int[]> type = null;
        h.checkPoint("1-dimensional integer array");
        type = ArrayType.getPrimitiveArrayType(int[].class);
        h.check(type.getClassName(), (Object)"[I");
        h.check(type.getTypeName(), (Object)"[I");
        h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
        h.check(type.getDescription(), (Object)"1-dimension array of int");
        h.checkPoint("2-dimensional integer array");
        type = ArrayType.getPrimitiveArrayType(int[][].class);
        h.check(type.getClassName(), (Object)"[[I");
        h.check(type.getTypeName(), (Object)"[[I");
        h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
        h.check(type.getDescription(), (Object)"2-dimension array of int");
        h.checkPoint("3-dimensional integer array");
        type = ArrayType.getPrimitiveArrayType(int[][][].class);
        h.check(type.getClassName(), (Object)"[[[I");
        h.check(type.getTypeName(), (Object)"[[[I");
        h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
        h.check(type.getDescription(), (Object)"3-dimension array of int");
        try {
            ArrayType.getPrimitiveArrayType(Integer.TYPE);
            h.fail("int.class allowed.");
        }
        catch (IllegalArgumentException e) {
            h.check(true, "Exception thrown for int.class");
        }
        try {
            ArrayType.getPrimitiveArrayType(String.class);
            h.fail("String.class allowed.");
        }
        catch (IllegalArgumentException e) {
            h.check(true, "Exception thrown for String.class");
        }
    }
}

