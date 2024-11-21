/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.openmbean.ArrayType;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.SimpleType;

public class Constructor2
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ArrayType type;
        try {
            type = new ArrayType(SimpleType.STRING, true);
            h.fail("Non-primitive type allowed.");
        }
        catch (OpenDataException e) {
            h.check(true, "Exception thrown for primitive array with non-primitive type");
        }
        try {
            h.checkPoint("Primitive integer array");
            type = new ArrayType(SimpleType.INTEGER, true);
            h.check(type.getClassName(), (Object)"[I");
            h.check(type.getTypeName(), (Object)"[I");
            h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.Integer");
            h.check(type.getDescription(), (Object)"1-dimension array of int");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
        try {
            h.checkPoint("String array");
            type = new ArrayType(SimpleType.STRING, false);
            h.check(type.getClassName(), (Object)"[Ljava.lang.String;");
            h.check(type.getTypeName(), (Object)"[Ljava.lang.String;");
            h.check(type.getElementOpenType().getClassName(), (Object)"java.lang.String");
            h.check(type.getDescription(), (Object)"1-dimension array of java.lang.String");
        }
        catch (OpenDataException e) {
            h.debug(e);
        }
    }
}

