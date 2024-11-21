/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf;

import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

public class TestLookAndFeel
extends BasicLookAndFeel {
    @Override
    public String getID() {
        return "TestLookAndFeel";
    }

    @Override
    public String getName() {
        return "TestLookAndFeel";
    }

    @Override
    public String getDescription() {
        return "TestLookAndFeel";
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

