/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.datatransfer.DataFlavor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

public class flavor
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        DataFlavor df = DataFlavor.javaFileListFlavor;
        String primaryType = "application";
        String subType = "x-java-file-list";
        Class representationClass = List.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        df = DataFlavor.plainTextFlavor;
        primaryType = "text";
        subType = "plain";
        String param = "charset";
        String value2 = "unicode";
        representationClass = InputStream.class;
        this.checkFlavor(df, primaryType, subType, param, value2, representationClass);
        df = DataFlavor.stringFlavor;
        primaryType = "application";
        subType = "x-java-serialized-object";
        representationClass = String.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        try {
            df = new DataFlavor("image/jpeg");
            primaryType = "image";
            subType = "jpeg";
            representationClass = InputStream.class;
            this.checkFlavor(df, primaryType, subType, null, null, representationClass);
            harness.check(df.getHumanPresentableName(), (Object)"image/jpeg");
        }
        catch (ClassNotFoundException cnfe) {
            harness.debug(cnfe);
            harness.check(false, cnfe.toString());
        }
        try {
            df = new DataFlavor("application/x-java-serialized-object; class=java.awt.Point");
            primaryType = "application";
            subType = "x-java-serialized-object";
            representationClass = Point.class;
            this.checkFlavor(df, primaryType, subType, null, null, representationClass);
            harness.check(df.getHumanPresentableName(), (Object)"application/x-java-serialized-object; class=java.awt.Point");
        }
        catch (ClassNotFoundException cnfe) {
            harness.debug(cnfe);
            harness.check(false, cnfe.toString());
        }
        df = new DataFlavor("application/x-java-serialized-object; class=java.awt.Point", "Point object");
        primaryType = "application";
        subType = "x-java-serialized-object";
        representationClass = Point.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        harness.check(df.getHumanPresentableName(), (Object)"Point object");
        df = new DataFlavor("application/x-java-serialized-object; class=java.awt.Point", null);
        primaryType = "application";
        subType = "x-java-serialized-object";
        representationClass = Point.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        harness.check(df.getHumanPresentableName(), (Object)"application/x-java-serialized-object; class=java.awt.Point");
        df = new DataFlavor("image/jpeg", "JPEG image");
        primaryType = "image";
        subType = "jpeg";
        representationClass = InputStream.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        harness.check(df.getHumanPresentableName(), (Object)"JPEG image");
        df = new DataFlavor("image/jpeg", null);
        primaryType = "image";
        subType = "jpeg";
        representationClass = InputStream.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        harness.check(df.getHumanPresentableName(), (Object)"image/jpeg");
        try {
            df = new DataFlavor("application/x-java-serialized-object; class=java.awt.Point", "Point object", ClassLoader.getSystemClassLoader());
            primaryType = "application";
            subType = "x-java-serialized-object";
            representationClass = Point.class;
            this.checkFlavor(df, primaryType, subType, null, null, representationClass);
            harness.check(df.getHumanPresentableName(), (Object)"Point object");
        }
        catch (ClassNotFoundException cnfe) {
            harness.debug(cnfe);
            harness.check(false, cnfe.toString());
        }
        try {
            df = new DataFlavor("application/x-java-serialized-object; class=java.awt.Point", null, ClassLoader.getSystemClassLoader());
            primaryType = "application";
            subType = "x-java-serialized-object";
            representationClass = Point.class;
            this.checkFlavor(df, primaryType, subType, null, null, representationClass);
            harness.check(df.getHumanPresentableName(), (Object)"application/x-java-serialized-object; class=java.awt.Point");
        }
        catch (ClassNotFoundException cnfe) {
            harness.debug(cnfe);
            harness.check(false, cnfe.toString());
        }
        df = new DataFlavor(Point.class, "Point object");
        primaryType = "application";
        subType = "x-java-serialized-object";
        representationClass = Point.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        harness.check(df.getHumanPresentableName(), (Object)"Point object");
        df = new DataFlavor(Point.class, null);
        primaryType = "application";
        subType = "x-java-serialized-object";
        representationClass = Point.class;
        this.checkFlavor(df, primaryType, subType, null, null, representationClass);
        harness.check(df.getHumanPresentableName(), (Object)"application/x-java-serialized-object; class=java.awt.Point");
    }

    private void checkFlavor(DataFlavor df, String primaryType, String subType, String param, String value2, Class representationClass) {
        this.harness.checkPoint(df.toString());
        this.harness.check(df.getPrimaryType(), (Object)primaryType);
        this.harness.check(df.getSubType(), (Object)subType);
        this.harness.check(df.getRepresentationClass(), representationClass);
        boolean hasClassParam = subType.startsWith("x-java");
        String mimeType = primaryType + "/" + subType;
        if (hasClassParam) {
            mimeType = mimeType + "; class=" + representationClass.getName();
        }
        if (param != null) {
            mimeType = mimeType + "; " + param + "=" + value2;
        }
        this.harness.check(df.getMimeType(), (Object)mimeType);
        this.harness.check(df.isMimeTypeEqual(primaryType + "/" + subType));
        try {
            this.harness.check(df.isMimeTypeEqual((DataFlavor)df.clone()));
            this.harness.check(((DataFlavor)df.clone()).equals(df));
            this.harness.check(df.equals((DataFlavor)df.clone()));
        }
        catch (CloneNotSupportedException cnse) {
            this.harness.debug(cnse);
            this.harness.check(false, cnse.toString());
        }
        this.harness.check(df.getParameter("humanPresentableName"), (Object)df.getHumanPresentableName());
        if (hasClassParam) {
            this.harness.check(df.getParameter("class"), (Object)representationClass.getName());
        } else {
            this.harness.check(df.getParameter("class"), null);
        }
        if (param != null) {
            this.harness.check(df.getParameter(param), (Object)value2);
        }
        this.harness.check(df.getParameter("NO-SUCH-PARAM"), null);
        this.harness.check(df.isFlavorJavaFileListType(), subType.equals("x-java-file-list"));
        this.harness.check(df.isFlavorRemoteObjectType(), subType.equals("x-java-remote-object"));
        this.harness.check(df.isFlavorSerializedObjectType(), subType.equals("x-java-serialized-object"));
        this.harness.check(df.isRepresentationClassInputStream(), InputStream.class.isAssignableFrom(representationClass));
        this.harness.check(df.isRepresentationClassRemote(), Remote.class.isAssignableFrom(representationClass));
        this.harness.check(df.isRepresentationClassSerializable(), Serializable.class.isAssignableFrom(representationClass));
    }
}

