/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.sql.Date;

public class DateTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Date d = new Date(0L);
        try {
            d.getHours();
            harness.check(false, "getHours");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getHours");
        }
        try {
            d.getMinutes();
            harness.check(false, "getMinutes");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getMinutes");
        }
        try {
            d.getSeconds();
            harness.check(false, "getSeconds");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getSeconds");
        }
        try {
            d.setHours(0);
            harness.check(false, "setHours");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "setHours");
        }
        try {
            d.setMinutes(0);
            harness.check(false, "setMinutes");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "setMinutes");
        }
        try {
            d.setSeconds(0);
            harness.check(false, "setSeconds");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "setSeconds");
        }
        try {
            Date.valueOf("NoSuchDate");
            harness.check(false, "valueOf");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "valueOf");
        }
    }
}

