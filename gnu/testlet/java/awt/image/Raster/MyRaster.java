/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Raster;

import java.awt.Point;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.SampleModel;

public class MyRaster
extends Raster {
    public MyRaster(SampleModel sm, DataBuffer db, Point origin) {
        super(sm, db, origin);
    }
}

