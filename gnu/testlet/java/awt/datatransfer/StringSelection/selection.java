/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.datatransfer.StringSelection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Reader;

public class selection
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            String testString = "Mauve test data string";
            StringSelection ss = new StringSelection(testString);
            harness.check(ss.isDataFlavorSupported(DataFlavor.stringFlavor));
            harness.check(ss.isDataFlavorSupported(DataFlavor.plainTextFlavor));
            harness.check(!ss.isDataFlavorSupported(DataFlavor.imageFlavor));
            DataFlavor[] dfs = ss.getTransferDataFlavors();
            harness.check(dfs.length, 2);
            harness.check(dfs[0].equals(DataFlavor.stringFlavor) || dfs[0].equals(DataFlavor.plainTextFlavor));
            harness.check(dfs[1].equals(DataFlavor.stringFlavor) || dfs[1].equals(DataFlavor.plainTextFlavor));
            String s = (String)ss.getTransferData(DataFlavor.stringFlavor);
            harness.check(s, (Object)testString);
            Reader r = (Reader)ss.getTransferData(DataFlavor.plainTextFlavor);
            StringBuffer sb = new StringBuffer();
            int i = r.read();
            while (i != -1) {
                sb.append((char)i);
                i = r.read();
            }
            harness.check(sb.toString(), (Object)testString);
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false, ioe.toString());
        }
        catch (UnsupportedFlavorException ufe) {
            harness.debug(ufe);
            harness.check(false, ufe.toString());
        }
    }
}

