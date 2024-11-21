/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import java.awt.image.ComponentSampleModel;

public class MyComponentSampleModel
extends ComponentSampleModel {
    public MyComponentSampleModel(int dataType, int w, int h, int pixelStride, int scanlineStride, int[] bandOffsets) {
        super(dataType, w, h, pixelStride, scanlineStride, bandOffsets);
    }

    public MyComponentSampleModel(int dataType, int w, int h, int pixelStride, int scanlineStride, int[] bandOffsets, int[] bankIndices) {
        super(dataType, w, h, pixelStride, scanlineStride, bandOffsets);
    }

    public int[] getBandOffsetsDirect() {
        return this.bandOffsets;
    }

    public int[] getBankIndicesDirect() {
        return this.bankIndices;
    }
}

