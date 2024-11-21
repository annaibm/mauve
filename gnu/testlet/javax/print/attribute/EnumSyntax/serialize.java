/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.EnumSyntax;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.print.attribute.EnumSyntax.CorrectEnumSyntax;
import gnu.testlet.javax.print.attribute.EnumSyntax.WrongEnumSyntax;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serialize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSerializeErrors(harness);
        this.testSerializeNoErrors(harness);
    }

    private void testSerializeErrors(TestHarness harness) {
        WrongEnumSyntax test = WrongEnumSyntax.TEST;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(test);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            in.readObject();
            in.close();
            harness.check(false, "serialize error");
        }
        catch (Exception e) {
            harness.check(true, "serialize error");
        }
    }

    private void testSerializeNoErrors(TestHarness harness) {
        CorrectEnumSyntax inObj = CorrectEnumSyntax.TEST2;
        CorrectEnumSyntax outObj = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(inObj);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            outObj = (CorrectEnumSyntax)in.readObject();
            in.close();
            harness.check(true, "serialize no error");
            harness.check(inObj == outObj, "identity test");
            harness.check(inObj.equals(outObj), "equality test");
            harness.check(inObj.hashCode() == outObj.hashCode(), "hashcode test");
        }
        catch (Exception e) {
            harness.check(false, "serialize no error");
        }
    }
}

