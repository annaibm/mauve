/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalLookAndFeel;

import javax.swing.UIDefaults;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MyMetalLookAndFeel
extends MetalLookAndFeel {
    @Override
    public String getID() {
        return "MyMetalLookAndFeel";
    }

    @Override
    public String getName() {
        return "MyMetalLookAndFeel";
    }

    @Override
    public String getDescription() {
        return "MyMetalLookAndFeel";
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public void initSystemColorDefaults(UIDefaults defaults) {
        super.initSystemColorDefaults(defaults);
    }

    @Override
    public void initComponentDefaults(UIDefaults defaults) {
        super.initComponentDefaults(defaults);
    }

    @Override
    public void initClassDefaults(UIDefaults defaults) {
        super.initClassDefaults(defaults);
    }
}

