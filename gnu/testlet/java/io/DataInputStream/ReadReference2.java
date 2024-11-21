/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.DataInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.DataInputStream.ReadStream2;
import java.io.DataInputStream;
import java.io.InputStream;

public class ReadReference2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            InputStream is = harness.getResourceStream("gnu#testlet#java#io#DataInputStream#reference2.data");
            DataInputStream dis = new DataInputStream(is);
            harness.debug("Reading reference DataInput data, set 2");
            ReadStream2.runReadTest(dis, harness);
            dis.close();
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "Read reference DataInput data (2)");
        }
    }
}

