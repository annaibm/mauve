/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Properties;

public class getLong
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Properties p = System.getProperties();
        p.put("e1", Long.toString(Long.MIN_VALUE));
        p.put("e2", Long.toString(Long.MAX_VALUE));
        p.put("e3", "0" + Long.toOctalString(Long.MIN_VALUE));
        p.put("e4", "0" + Long.toOctalString(Long.MAX_VALUE));
        p.put("e5", "0x" + Long.toHexString(Long.MIN_VALUE));
        p.put("e6", "0x" + Long.toHexString(Long.MAX_VALUE));
        p.put("e7", "0" + Long.toString(Long.MAX_VALUE, 8));
        p.put("e8", "#" + Long.toString(Long.MAX_VALUE, 16));
        p.put("e9", "");
        p.put("e10", " ");
        p.put("e11", "foo");
        try {
            harness.check(Long.getLong("e1").toString(), (Object)"-9223372036854775808");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e2").toString(), (Object)"9223372036854775807");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e3"), null);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e4").toString(), (Object)"9223372036854775807");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e5", 12345L).toString(), (Object)"12345");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e6", new Long(56789L)).toString(), (Object)"9223372036854775807");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e7", null).toString(), (Object)"9223372036854775807");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e8", 12345L).toString(), (Object)"9223372036854775807");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e9", new Long(56789L)).toString(), (Object)"56789");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e10", null), null);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("e11"), null);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("junk", 12345L).toString(), (Object)"12345");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("junk", new Long(56789L)).toString(), (Object)"56789");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("junk", null), null);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("junk"), null);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
    }
}

