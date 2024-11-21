/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class useProtocolVersion
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            String toSerialize = "Hello";
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bytes);
            try {
                out.useProtocolVersion(1);
                harness.check(true);
            }
            catch (RuntimeException e) {
                harness.check(false);
            }
            out.writeInt(4);
            try {
                out.useProtocolVersion(1);
                harness.check(true);
            }
            catch (IllegalStateException e) {
                harness.check(false);
            }
            out.writeObject(toSerialize);
            try {
                out.useProtocolVersion(1);
                harness.check(false);
            }
            catch (IllegalStateException e) {
                harness.check(true);
            }
            out = new ObjectOutputStream(bytes);
            try {
                out.useProtocolVersion(4);
                harness.check(false);
            }
            catch (IllegalArgumentException e) {
                harness.check(true);
            }
        }
        catch (IOException e) {
            harness.fail("Unexpected exception occured.");
            harness.debug(e);
        }
    }
}

