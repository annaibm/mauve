/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.SimpleType;

public class GetArrayType
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType<Integer[]> type = null;
        try {
            h.checkPoint("1-dimensional integer array");
            type = ArrayType.getArrayType(SimpleType.INTEGER);
            h.check(type.getClassName(), (Object)"[Ljava.lang.Integer;");
            h.check(type.getTypeName(), (Object)"[Ljava.lang.Integer;");
            h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
            h.check(type.getDescription(), (Object)"1-dimension array of java.lang.Integer");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        try {
            h.checkPoint("2-dimensional integer array");
            type = ArrayType.getArrayType(type);
            h.check(type.getClassName(), (Object)"[[Ljava.lang.Integer;");
            h.check(type.getTypeName(), (Object)"[[Ljava.lang.Integer;");
            h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
            h.check(type.getDescription(), (Object)"2-dimension array of java.lang.Integer");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        try {
            h.checkPoint("3-dimensional integer array");
            type = ArrayType.getArrayType(type);
            h.check(type.getClassName(), (Object)"[[[Ljava.lang.Integer;");
            h.check(type.getTypeName(), (Object)"[[[Ljava.lang.Integer;");
            h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
            h.check(type.getDescription(), (Object)"3-dimension array of java.lang.Integer");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
    }
}

