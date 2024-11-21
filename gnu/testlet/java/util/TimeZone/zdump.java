/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.TimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class zdump
implements Testlet {
    public static final String zdump = "/usr/sbin/zdump";

    @Override
    public void test(TestHarness harness) {
        String zoneinfodir = System.getProperty("gnu.java.util.zoneinfo.dir");
        if (zoneinfodir == null) {
            return;
        }
        if (!new File(zdump).exists() || !new File(zoneinfodir).isDirectory()) {
            return;
        }
        SimpleTimeZone utc = new SimpleTimeZone(0, "GMT");
        TimeZone.setDefault(utc);
        String[] zones = TimeZone.getAvailableIDs();
        for (int i = 0; i < zones.length; ++i) {
            if (!new File(zoneinfodir, zones[i]).exists() || zones[i].equals("EST") || zones[i].equals("MST")) continue;
            gnu.testlet.java.util.TimeZone.zdump.checkZone(harness, zones[i]);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void checkZone(TestHarness harness, String zone) {
        harness.checkPoint(zone);
        TimeZone tz = TimeZone.getTimeZone(zone);
        if (tz == null) {
            harness.check(false);
            return;
        }
        Calendar cal = Calendar.getInstance(tz);
        BufferedReader br = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("/usr/sbin/zdump -v " + zone);
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = br.readLine();
            while (line != null) {
                int start1;
                int end1 = line.indexOf(" UTC = ");
                if (end1 >= 0 && (start1 = line.indexOf("  ")) >= 0 && start1 < end1) {
                    int start2 = line.indexOf(" isdst=");
                    int start3 = line.indexOf(" gmtoff=");
                    if (start2 > end1 && start3 > start2) {
                        Date d = new Date(line.substring(start1 + 2, end1 + 4));
                        cal.setTime(d);
                        int isdst = Integer.parseInt(line.substring(start2 + 7, start3));
                        int gmtoff = Integer.parseInt(line.substring(start3 + 8, line.length()));
                        harness.debug("Zone " + zone + " " + d + " isdst=" + isdst + " inDaylightTime=" + tz.inDaylightTime(d));
                        harness.check(tz.inDaylightTime(d) == (isdst != 0));
                        harness.debug("Zone " + zone + " " + d + " gmtoff=" + gmtoff + " getOffset=" + tz.getOffset(d.getTime()));
                        harness.check(tz.getOffset(d.getTime()) == gmtoff * 1000);
                        int offset2 = cal.get(16) + cal.get(15);
                        harness.debug("Zone " + zone + " " + d + " gmtoff=" + gmtoff + " DST_OFFSET+ZONE_OFFSET=" + offset2);
                        harness.check(offset2 == gmtoff * 1000);
                    }
                }
                line = br.readLine();
            }
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (process != null) {
                    process.waitFor();
                    process.exitValue();
                }
            }
            catch (IOException iOException) {
            }
            catch (InterruptedException interruptedException) {}
        }
    }
}

