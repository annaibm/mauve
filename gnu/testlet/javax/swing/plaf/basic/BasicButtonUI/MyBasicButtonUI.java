/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicButtonUI;

import javax.swing.plaf.basic.BasicButtonUI;

public class MyBasicButtonUI
extends BasicButtonUI {
    public int getDefaultTextIconGapField() {
        return this.defaultTextIconGap;
    }

    public int getDefaultTextShiftOffsetField() {
        return this.defaultTextShiftOffset;
    }

    public void setDefaultTextShiftOffsetField(int offset2) {
        this.defaultTextShiftOffset = offset2;
    }

    @Override
    public String getPropertyPrefix() {
        return super.getPropertyPrefix();
    }

    @Override
    public int getTextShiftOffset() {
        return super.getTextShiftOffset();
    }

    @Override
    public void setTextShiftOffset() {
        super.setTextShiftOffset();
    }

    @Override
    public void clearTextShiftOffset() {
        super.clearTextShiftOffset();
    }
}

