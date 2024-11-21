/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ToolTipManager;

import gnu.testlet.VisualTestlet;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

public class DynamicToolTipTest
extends VisualTestlet {
    @Override
    public String getInstructions() {
        return "Move the mouse pointer over the empty panel. Wait for 1-2 seconds until the tooltip appears. Moving the mouse should update the tooltip text with the current mouse coordinates.";
    }

    @Override
    public String getExpectedResults() {
        return "A tooltip should appear after 1-2 seconds. When the mouse is moved further, the tooltip text is updated with the mouse coordinates and the tooltip location follows the mouse pointer";
    }

    @Override
    public Component getTestComponent() {
        JPanel p = new JPanel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }

            @Override
            public String getToolTipText(MouseEvent ev) {
                return "" + ev.getX() + ", " + ev.getY();
            }
        };
        ToolTipManager.sharedInstance().registerComponent(p);
        return p;
    }
}

