/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicLookAndFeel;

import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

public class MyBasicLookAndFeel
extends BasicLookAndFeel {
    @Override
    public String getID() {
        return "MyBasicLookAndFeel";
    }

    @Override
    public String getName() {
        return "MyBasicLookAndFeel";
    }

    @Override
    public String getDescription() {
        return "MyBasicLookAndFeel";
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
        defaults.put("SliderUI", "gnu.testlet.javax.swing.plaf.basic.BasicLookAndFeel.MyBasicSliderUI");
    }
}

