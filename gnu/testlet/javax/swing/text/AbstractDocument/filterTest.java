/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.GapContent;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.undo.UndoableEdit;

public class filterTest
implements Testlet {
    int DEFAULT_INT = -1234;
    String DEFAULT_STRING = "A specific value for this test";
    AttributeSet DEFAULT_ATTRIBUTESET = new SimpleAttributeSet();
    int testOffset;
    int testLength;
    String testString;
    AttributeSet testAttr;
    Exception testException;
    int testWhere;
    int testInsertWhere;
    int testNitems;

    @Override
    public void test(TestHarness harness) {
        PlainDocument doc = new PlainDocument();
        try {
            ((AbstractDocument)doc).insertString(0, "GNU Classpath\nGNU Classpath\nGNU Classpath\n", null);
        }
        catch (BadLocationException ble) {
            harness.verbose("Setting up the test failed. Something is seriously wrong with your AbstractDocument implementation.");
            harness.fail("test setup");
            return;
        }
        doc.setDocumentFilter(new TestDocFilter());
        harness.checkPoint("remove");
        this.reset();
        try {
            doc.remove(0, 0);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, 0);
        harness.check(this.testLength, 0);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.remove(0, -100);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, 0);
        harness.check(this.testLength, -100);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.remove(-222, -111);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, -222);
        harness.check(this.testLength, -111);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.remove(-100, 0);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, -100);
        harness.check(this.testLength, 0);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        harness.checkPoint("insertString");
        this.reset();
        try {
            ((AbstractDocument)doc).insertString(8888, null, SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, this.DEFAULT_INT);
        harness.check(this.testAttr, this.DEFAULT_ATTRIBUTESET);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            ((AbstractDocument)doc).insertString(8888, "", SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, this.DEFAULT_INT);
        harness.check(this.testAttr, this.DEFAULT_ATTRIBUTESET);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        harness.checkPoint("replace");
        this.reset();
        try {
            doc.replace(8888, 0, null, SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, this.DEFAULT_INT);
        harness.check(this.testLength, this.DEFAULT_INT);
        harness.check(this.testAttr, this.DEFAULT_ATTRIBUTESET);
        harness.check(this.testString, (Object)this.DEFAULT_STRING);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.replace(8888, 0, "", SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, this.DEFAULT_INT);
        harness.check(this.testLength, this.DEFAULT_INT);
        harness.check(this.testAttr, this.DEFAULT_ATTRIBUTESET);
        harness.check(this.testString, (Object)this.DEFAULT_STRING);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.replace(0, -1, null, SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, 0);
        harness.check(this.testLength, -1);
        harness.check(this.testAttr, SimpleAttributeSet.EMPTY);
        harness.check(this.testString, null);
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.replace(0, -1, "", SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, 0);
        harness.check(this.testLength, -1);
        harness.check(this.testAttr, SimpleAttributeSet.EMPTY);
        harness.check(this.testString, (Object)"");
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        this.reset();
        try {
            doc.replace(10, 0, "FOO!", SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException ble) {
            this.testException = ble;
            harness.debug(ble);
        }
        harness.check(this.testException, null);
        harness.check(this.testOffset, 10);
        harness.check(this.testLength, 0);
        harness.check(this.testAttr, SimpleAttributeSet.EMPTY);
        harness.check(this.testString, (Object)"FOO!");
        harness.check(this.testWhere, this.DEFAULT_INT);
        harness.check(this.testNitems, this.DEFAULT_INT);
        try {
            harness.check(doc.getText(10, 4), (Object)"FOO!");
        }
        catch (BadLocationException ble) {
            harness.debug(ble);
            harness.fail("replace6");
        }
    }

    void reset() {
        this.testOffset = this.DEFAULT_INT;
        this.testLength = this.DEFAULT_INT;
        this.testString = this.DEFAULT_STRING;
        this.testAttr = this.DEFAULT_ATTRIBUTESET;
        this.testException = null;
        this.testWhere = this.DEFAULT_INT;
        this.testNitems = this.DEFAULT_INT;
        this.testInsertWhere = this.DEFAULT_INT;
    }

    class TestGapContent
    extends GapContent {
        TestGapContent() {
        }

        @Override
        public UndoableEdit insertString(int where, String str) throws BadLocationException {
            filterTest.this.testInsertWhere = where;
            return super.insertString(where, str);
        }

        @Override
        public UndoableEdit remove(int where, int nitems) throws BadLocationException {
            filterTest.this.testWhere = where;
            filterTest.this.testNitems = nitems;
            return super.remove(where, nitems);
        }
    }

    class TestDocFilter
    extends DocumentFilter {
        TestDocFilter() {
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset2, String string, AttributeSet attr) throws BadLocationException {
            filterTest.this.testOffset = offset2;
            filterTest.this.testString = string;
            filterTest.this.testAttr = attr;
            super.insertString(fb, offset2, string, attr);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int offset2, int length2) throws BadLocationException {
            filterTest.this.testOffset = offset2;
            filterTest.this.testLength = length2;
            super.remove(fb, offset2, length2);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset2, int length2, String string, AttributeSet attr) throws BadLocationException {
            filterTest.this.testOffset = offset2;
            filterTest.this.testLength = length2;
            filterTest.this.testString = string;
            filterTest.this.testAttr = attr;
            super.replace(fb, offset2, length2, string, attr);
        }
    }
}

