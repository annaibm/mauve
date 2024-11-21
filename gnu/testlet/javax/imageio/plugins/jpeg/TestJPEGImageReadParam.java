/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.plugins.jpeg;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.imageio.plugins.jpeg.JPEGQTable;

public class TestJPEGImageReadParam
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPEGImageReadParam param = new JPEGImageReadParam();
        Object[] qTables = new JPEGQTable[]{JPEGQTable.K1Luminance, JPEGQTable.K1Div2Luminance, JPEGQTable.K2Chrominance, JPEGQTable.K2Div2Chrominance};
        Object[] DCHuffmanTables = new JPEGHuffmanTable[]{JPEGHuffmanTable.StdDCLuminance, JPEGHuffmanTable.StdDCChrominance};
        Object[] ACHuffmanTables = new JPEGHuffmanTable[]{JPEGHuffmanTable.StdACLuminance, JPEGHuffmanTable.StdACChrominance};
        harness.check(!param.areTablesSet());
        harness.check(param.getQTables() == null);
        harness.check(param.getDCHuffmanTables() == null);
        harness.check(param.getACHuffmanTables() == null);
        boolean settingFailed = false;
        try {
            param.setDecodeTables((JPEGQTable[])qTables, null, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(settingFailed);
        settingFailed = false;
        try {
            param.setDecodeTables(new JPEGQTable[]{JPEGQTable.K1Luminance, JPEGQTable.K1Div2Luminance, JPEGQTable.K2Chrominance, JPEGQTable.K2Div2Chrominance, JPEGQTable.K1Luminance}, (JPEGHuffmanTable[])DCHuffmanTables, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(settingFailed);
        settingFailed = false;
        try {
            param.setDecodeTables((JPEGQTable[])qTables, new JPEGHuffmanTable[]{JPEGHuffmanTable.StdDCLuminance}, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(settingFailed);
        settingFailed = false;
        try {
            param.setDecodeTables((JPEGQTable[])qTables, (JPEGHuffmanTable[])DCHuffmanTables, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(!settingFailed);
        harness.check(param.areTablesSet());
        Object[] gotQTables = param.getQTables();
        harness.check(gotQTables != null);
        harness.check(Arrays.equals(qTables, gotQTables));
        Object[] gotDCHuffmanTables = param.getDCHuffmanTables();
        harness.check(gotDCHuffmanTables != null);
        harness.check(Arrays.equals(DCHuffmanTables, gotDCHuffmanTables));
        Object[] gotACHuffmanTables = param.getACHuffmanTables();
        harness.check(gotACHuffmanTables != null);
        harness.check(Arrays.equals(ACHuffmanTables, gotACHuffmanTables));
        param.unsetDecodeTables();
        gotQTables = param.getQTables();
        harness.check(gotQTables == null);
        gotDCHuffmanTables = param.getDCHuffmanTables();
        harness.check(gotDCHuffmanTables == null);
        gotACHuffmanTables = param.getACHuffmanTables();
        harness.check(gotACHuffmanTables == null);
        harness.check(!param.areTablesSet());
    }
}

