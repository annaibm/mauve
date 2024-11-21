/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;

public class getDataTypeSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(DataBuffer.getDataTypeSize(0) == 8);
        harness.check(DataBuffer.getDataTypeSize(5) == 64);
        harness.check(DataBuffer.getDataTypeSize(4) == 32);
        harness.check(DataBuffer.getDataTypeSize(3) == 32);
        harness.check(DataBuffer.getDataTypeSize(2) == 16);
        harness.check(DataBuffer.getDataTypeSize(1) == 16);
        boolean pass = false;
        try {
            DataBuffer.getDataTypeSize(32);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DataBuffer.getDataTypeSize(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

