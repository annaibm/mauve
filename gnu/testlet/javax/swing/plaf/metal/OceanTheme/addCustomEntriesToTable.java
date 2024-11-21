/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.OceanTheme;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Insets;
import java.util.Arrays;
import javax.swing.UIDefaults;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.OceanTheme;

public class addCustomEntriesToTable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UIDefaults defaults = new UIDefaults();
        OceanTheme theme = new OceanTheme();
        theme.addCustomEntriesToTable(defaults);
        harness.check(defaults.get("Button.disabledToolBarBorderBackground"), new ColorUIResource(204, 204, 204));
        harness.check(defaults.get("Button.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("Button.rollover"), Boolean.TRUE);
        harness.check(defaults.get("Button.rolloverIconType"), (Object)"ocean");
        harness.check(defaults.get("Button.toolBarBorderBackground"), new ColorUIResource(153, 153, 153));
        harness.check(defaults.get("CheckBox.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("CheckBox.rollover"), Boolean.TRUE);
        harness.check(defaults.get("CheckBoxMenuItem.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("InternalFrame.activeTitleGradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("Label.disabledForeground"), new ColorUIResource(153, 153, 153));
        BorderUIResource.LineBorderUIResource border = (BorderUIResource.LineBorderUIResource)defaults.get("List.focusCellHighlightBorder");
        harness.check(border.getThickness(), 1);
        harness.check(border.getLineColor(), new ColorUIResource(99, 130, 191));
        harness.check(defaults.get("MenuBar.borderColor"), new ColorUIResource(204, 204, 204));
        harness.check(defaults.get("MenuBar.gradient"), Arrays.asList(new Float(1.0), new Float(0.0), new ColorUIResource(Color.WHITE), new ColorUIResource(218, 218, 218), new ColorUIResource(218, 218, 218)));
        harness.check(defaults.get("MenuBarUI"), (Object)"javax.swing.plaf.metal.MetalMenuBarUI");
        harness.check(defaults.get("Menu.opaque"), Boolean.FALSE);
        harness.check(defaults.get("RadioButton.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("RadioButton.rollover"), Boolean.TRUE);
        harness.check(defaults.get("RadioButtonMenuItem.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("ScrollBar.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("Slider.altTrackColor"), new ColorUIResource(210, 226, 239));
        harness.check(defaults.get("Slider.focusGradient"), Arrays.asList(new Float(0.3), new Float(0.2), new ColorUIResource(200, 221, 242), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("Slider.gradient"), Arrays.asList(new Float(0.3), new Float(0.2), new ColorUIResource(200, 221, 242), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("SplitPane.dividerFocusColor"), new ColorUIResource(200, 221, 242));
        harness.check(defaults.get("SplitPane.oneTouchButtonsOpaque"), Boolean.FALSE);
        harness.check(defaults.get("TabbedPane.borderHightlightColor"), new ColorUIResource(99, 130, 191));
        harness.check(defaults.get("TabbedPane.contentAreaColor"), new ColorUIResource(200, 221, 242));
        harness.check(defaults.get("TabbedPane.contentBorderInsets"), new Insets(4, 2, 3, 3));
        harness.check(defaults.get("TabbedPane.tabAreaBackground"), new ColorUIResource(218, 218, 218));
        harness.check(defaults.get("TabbedPane.tabAreaInsets"), new Insets(2, 2, 0, 6));
        harness.check(defaults.get("TabbedPane.selected"), new ColorUIResource(200, 221, 242));
        harness.check(defaults.get("TabbedPane.unselectedBackground"), new ColorUIResource(238, 238, 238));
        harness.check(defaults.get("Table.focusCellHighlightBorder") instanceof BorderUIResource.LineBorderUIResource);
        harness.check(defaults.get("Table.gridColor"), new ColorUIResource(122, 138, 153));
        harness.check(defaults.get("ToggleButton.gradient"), Arrays.asList(new Float(0.3), new Float(0.0), new ColorUIResource(221, 232, 243), new ColorUIResource(Color.WHITE), new ColorUIResource(184, 207, 229)));
        harness.check(defaults.get("ToolBar.borderColor"), new ColorUIResource(204, 204, 204));
        harness.check(defaults.get("ToolBar.isRollover"), Boolean.TRUE);
        harness.check(defaults.get("Tree.selectionBorderColor"), new ColorUIResource(99, 130, 191));
    }
}

