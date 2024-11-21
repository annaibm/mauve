/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.plugins.jpeg;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.Locale;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.plugins.jpeg.JPEGQTable;

public class TestJPEGImageWriteParam
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPEGImageWriteParam param = new JPEGImageWriteParam(Locale.ENGLISH);
        Object[] qTables = new JPEGQTable[]{JPEGQTable.K1Luminance, JPEGQTable.K1Div2Luminance, JPEGQTable.K2Chrominance, JPEGQTable.K2Div2Chrominance};
        Object[] DCHuffmanTables = new JPEGHuffmanTable[]{JPEGHuffmanTable.StdDCLuminance, JPEGHuffmanTable.StdDCChrominance};
        Object[] ACHuffmanTables = new JPEGHuffmanTable[]{JPEGHuffmanTable.StdACLuminance, JPEGHuffmanTable.StdACChrominance};
        harness.check(!param.areTablesSet());
        harness.check(!param.getOptimizeHuffmanTables());
        harness.check(param.getQTables() == null);
        harness.check(param.getDCHuffmanTables() == null);
        harness.check(param.getACHuffmanTables() == null);
        harness.check(!param.canWriteTiles());
        harness.check(param.canWriteProgressive());
        harness.check(param.getProgressiveMode() == 0);
        harness.check(param.canWriteCompressed());
        harness.check(param.getCompressionTypes().length == 1);
        harness.check(param.getCompressionTypes()[0].equals("JPEG"));
        param.setCompressionMode(2);
        harness.check(param.getCompressionType().equals("JPEG"));
        harness.check(param.getCompressionQuality() == 0.75f);
        harness.check(!param.isCompressionLossless());
        Object[] descriptions = param.getCompressionQualityDescriptions();
        harness.check(descriptions.length == 3);
        Object[] expectedDescriptions = new String[]{"Minimum useful", "Visually lossless", "Maximum useful"};
        harness.check(Arrays.equals(descriptions, expectedDescriptions));
        float[] values2 = param.getCompressionQualityValues();
        harness.check(values2.length == descriptions.length);
        float[] expectedValues = new float[]{0.05f, 0.75f, 0.95f};
        harness.check(Arrays.equals(values2, expectedValues));
        param.setOptimizeHuffmanTables(true);
        harness.check(param.getOptimizeHuffmanTables());
        param.setOptimizeHuffmanTables(false);
        harness.check(!param.getOptimizeHuffmanTables());
        param.setCompressionQuality(0.31f);
        harness.check(param.getCompressionQuality() == 0.31f);
        param.unsetCompression();
        harness.check(param.getCompressionQuality() == 0.75f);
        boolean settingFailed = false;
        try {
            param.setEncodeTables((JPEGQTable[])qTables, null, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(settingFailed);
        settingFailed = false;
        try {
            param.setEncodeTables(new JPEGQTable[]{JPEGQTable.K1Luminance, JPEGQTable.K1Div2Luminance, JPEGQTable.K2Chrominance, JPEGQTable.K2Div2Chrominance, JPEGQTable.K1Luminance}, (JPEGHuffmanTable[])DCHuffmanTables, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(settingFailed);
        settingFailed = false;
        try {
            param.setEncodeTables((JPEGQTable[])qTables, new JPEGHuffmanTable[]{JPEGHuffmanTable.StdDCLuminance}, (JPEGHuffmanTable[])ACHuffmanTables);
        }
        catch (IllegalArgumentException e) {
            settingFailed = true;
        }
        harness.check(settingFailed);
        settingFailed = false;
        try {
            param.setEncodeTables((JPEGQTable[])qTables, (JPEGHuffmanTable[])DCHuffmanTables, (JPEGHuffmanTable[])ACHuffmanTables);
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
        param.unsetEncodeTables();
        gotQTables = param.getQTables();
        harness.check(gotQTables == null);
        gotDCHuffmanTables = param.getDCHuffmanTables();
        harness.check(gotDCHuffmanTables == null);
        gotACHuffmanTables = param.getACHuffmanTables();
        harness.check(gotACHuffmanTables == null);
        harness.check(!param.areTablesSet());
    }
}

