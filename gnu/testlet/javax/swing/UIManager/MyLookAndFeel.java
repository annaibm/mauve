/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import javax.swing.LookAndFeel;
import javax.swing.UIDefaults;

public class MyLookAndFeel
extends LookAndFeel {
    @Override
    public String getDescription() {
        return "MyLookAndFeel Description";
    }

    @Override
    public String getID() {
        return "MyLookAndFeel ID";
    }

    @Override
    public String getName() {
        return "MyLookAndFeel Name";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    public UIDefaults getDefaults() {
        UIDefaults def = new UIDefaults();
        def.put("LabelUI", "gnu.testlet.javax.swing.UIManager.TestLabelUI");
        return def;
    }
}

