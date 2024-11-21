/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.XMLDecoder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.XMLDecoder.DecoderTestHelper;
import gnu.testlet.java.beans.XMLDecoder.DoubleArrayChecker;
import gnu.testlet.java.beans.XMLDecoder.IntArrayChecker;
import gnu.testlet.java.beans.XMLDecoder.PointArrayChecker;
import java.awt.Point;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class jdk14
implements Testlet {
    private List testHelpers = new LinkedList();

    public jdk14() {
        DecoderTestHelper testHelper = new DecoderTestHelper("booleanTest", "gnu#testlet#java#beans#XMLDecoder#data#boolean.xml");
        testHelper.addObject(new Boolean(true));
        testHelper.addObject(new Boolean(false));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("byteTest", "gnu#testlet#java#beans#XMLDecoder#data#byte.xml");
        testHelper.addObject(new Byte(-120));
        testHelper.addObject(new Byte(0));
        testHelper.addObject(new Byte(-128));
        testHelper.addObject(new Byte(127));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("shortTest", "gnu#testlet#java#beans#XMLDecoder#data#short.xml");
        testHelper.addObject(new Short(16000));
        testHelper.addObject(new Short(-16000));
        testHelper.addObject(new Short(Short.MIN_VALUE));
        testHelper.addObject(new Short(Short.MAX_VALUE));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("intTest", "gnu#testlet#java#beans#XMLDecoder#data#int.xml");
        testHelper.addObject(new Integer(54321));
        testHelper.addObject(new Integer(-54321));
        testHelper.addObject(new Integer(Integer.MIN_VALUE));
        testHelper.addObject(new Integer(Integer.MAX_VALUE));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("longTest", "gnu#testlet#java#beans#XMLDecoder#data#long.xml");
        testHelper.addObject(new Long(5432154321L));
        testHelper.addObject(new Long(-5432154321L));
        testHelper.addObject(new Long(Long.MIN_VALUE));
        testHelper.addObject(new Long(Long.MAX_VALUE));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("floatTest", "gnu#testlet#java#beans#XMLDecoder#data#float.xml");
        testHelper.addObject(new Float((float)Math.PI));
        testHelper.addObject(new Float((float)Math.E));
        testHelper.addObject(new Float((float)Math.pow(2.0, -16.0)));
        testHelper.addObject(new Float(0.0f));
        testHelper.addObject(new Float(Float.NaN));
        testHelper.addObject(new Float(Float.POSITIVE_INFINITY));
        testHelper.addObject(new Float(Float.NEGATIVE_INFINITY));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("doubleTest", "gnu#testlet#java#beans#XMLDecoder#data#double.xml");
        testHelper.addObject(new Double(Math.PI));
        testHelper.addObject(new Double(Math.E));
        testHelper.addObject(new Double(Math.pow(2.0, -16.0)));
        testHelper.addObject(new Double(Double.MIN_VALUE));
        testHelper.addObject(new Double(Double.MAX_VALUE));
        testHelper.addObject(new Double(Double.NaN));
        testHelper.addObject(new Double(Double.POSITIVE_INFINITY));
        testHelper.addObject(new Double(Double.NEGATIVE_INFINITY));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("simpleElementsTest", "gnu#testlet#java#beans#XMLDecoder#data#simpleElements.xml");
        testHelper.addObject(new Boolean(true));
        testHelper.addObject(new Boolean(false));
        testHelper.addObject(new Character('j'));
        testHelper.addObject(new Character('a'));
        testHelper.addObject(new Character('v'));
        testHelper.addObject(new Character('a'));
        testHelper.addObject(new Byte(8));
        testHelper.addObject(new Short(16));
        testHelper.addObject(new Integer(32));
        testHelper.addObject(new Long(64L));
        testHelper.addObject(new Float(32.0f));
        testHelper.addObject(new Double(64.0));
        testHelper.addObject("Hello World");
        testHelper.addObject(Object.class);
        testHelper.addObject(null);
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("listTest", "gnu#testlet#java#beans#XMLDecoder#data#list.xml");
        ArrayList<Object> expectedList = new ArrayList<Object>();
        expectedList.add(new Integer(100));
        expectedList.add("Hello World");
        expectedList.add(WeakReference.class);
        testHelper.addObject(expectedList);
        testHelper.addObject(expectedList);
        testHelper.addObject(new Boolean(true));
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("intArray", "gnu#testlet#java#beans#XMLDecoder#data#intArray.xml");
        testHelper.addObject(new int[]{1, 2, 3}, new IntArrayChecker());
        testHelper = new DecoderTestHelper("growableIntArray", "gnu#testlet#java#beans#XMLDecoder#data#growableIntArray.xml");
        testHelper.addObject(new int[]{0, 1, 2, 3, 4, 5}, new IntArrayChecker());
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("growableIntArray2", "gnu#testlet#java#beans#XMLDecoder#data#growableIntArray2.xml");
        testHelper.addObject(new int[]{0, 1, 2}, new IntArrayChecker());
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("growableDoubleArray", "gnu#testlet#java#beans#XMLDecoder#data#growableDoubleArray.xml");
        testHelper.addObject(new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0}, new DoubleArrayChecker());
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("pointArrayTest", "gnu#testlet#java#beans#XMLDecoder#data#pointArray.xml");
        testHelper.addObject(new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2)}, new PointArrayChecker());
        this.addHelper(testHelper);
        testHelper = new DecoderTestHelper("growablePointArrayTest", "gnu#testlet#java#beans#XMLDecoder#data#growablePointArray.xml");
        testHelper.addObject(new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4), new Point(5, 5)}, new PointArrayChecker());
        this.addHelper(testHelper);
    }

    private void addHelper(DecoderTestHelper helper2) {
        this.testHelpers.add(helper2);
    }

    @Override
    public void test(TestHarness harness) {
        Iterator ite = this.testHelpers.iterator();
        while (ite.hasNext()) {
            ((DecoderTestHelper)ite.next()).doComparison(harness);
        }
    }
}

