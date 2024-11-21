/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.javax.swing.text.ZoneView.TestView;
import java.util.ArrayList;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.ZoneView;

public class TestZoneView
extends ZoneView {
    private static final Element DEFAULT_ELEMENT;
    ArrayList lastUnloadedZones = new ArrayList();

    TestZoneView() {
        this(0);
    }

    TestZoneView(int axis) {
        this(DEFAULT_ELEMENT, axis);
    }

    TestZoneView(Element el, int axis) {
        super(el, axis);
    }

    @Override
    public void zoneWasLoaded(View zone) {
        super.zoneWasLoaded(zone);
    }

    @Override
    public void unloadZone(View zone) {
        super.unloadZone(zone);
        this.lastUnloadedZones.add(zone);
    }

    @Override
    public boolean isZoneLoaded(View z) {
        return super.isZoneLoaded(z);
    }

    @Override
    public View createZone(int p0, int p1) {
        return super.createZone(p0, p1);
    }

    @Override
    public int getViewIndexAtPosition(int pos) {
        return super.getViewIndexAtPosition(pos);
    }

    @Override
    public void loadChildren(ViewFactory vf) {
        super.loadChildren(vf);
    }

    @Override
    public ViewFactory getViewFactory() {
        return new ViewFactory(){

            @Override
            public View create(Element elem) {
                return new TestView(elem, 0);
            }
        };
    }

    static {
        Element el;
        PlainDocument doc = new PlainDocument();
        DEFAULT_ELEMENT = el = doc.getDefaultRootElement();
    }
}

