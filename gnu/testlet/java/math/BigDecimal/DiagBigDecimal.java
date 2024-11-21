/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

public class DiagBigDecimal
implements Testlet {
    private final boolean CHECK_EXCEPTION_MESSAGES = false;
    private static final String xx0 = "DiagBigDecimal.nrx";
    Vector Tests = new Vector(100);
    private int totalcount = 0;
    private static final int testcount = 38;
    private static final BigDecimal zero = new BigDecimal(BigInteger.valueOf(0L), 0);
    private static final BigDecimal one = new BigDecimal(BigInteger.valueOf(1L), 0);
    private static final BigDecimal two = new BigDecimal(BigInteger.valueOf(2L), 0);
    private static final BigDecimal ten = new BigDecimal(BigInteger.valueOf(10L), 0);
    private static final BigDecimal tenlong = new BigDecimal(1234554321L);
    private static final byte bmin = -128;
    private static final byte bmax = 127;
    private static final byte bzer = 0;
    private static final byte bneg = -1;
    private static final byte bpos = 1;
    private static final int imin = Integer.MIN_VALUE;
    private static final int imax = Integer.MAX_VALUE;
    private static final int izer = 0;
    private static final int ineg = -1;
    private static final int ipos = 1;
    private static final long lmin = Long.MIN_VALUE;
    private static final long lmax = Long.MAX_VALUE;
    private static final String lminString = "-9223372036854775808";
    private static final String lmaxString = "9223372036854775807";
    private static final long lzer = 0L;
    private static final long lneg = -1L;
    private static final long lpos = 1L;
    private static final short smin = Short.MIN_VALUE;
    private static final short smax = Short.MAX_VALUE;
    private static final short szer = 0;
    private static final short sneg = -1;
    private static final short spos = 1;
    private static final String copyright = " Copyright (c) IBM Corporation 1996, 2000.  All rights reserved. ";

    public void diagrun(TestHarness harness) {
        int num = 0;
        RuntimeException de = null;
        RuntimeException e = null;
        Object rest = null;
        try {
            for (num = 1; num <= 38; ++num) {
                try {
                    this.dotest(harness, num);
                    continue;
                }
                catch (RuntimeException xx1) {
                    de = xx1;
                    this.say(harness);
                    harness.verbose("**** Failed: " + de.getMessage() + " ****");
                    this.say(harness);
                }
            }
        }
        catch (RuntimeException xx2) {
            e = xx2;
            this.say(harness);
            harness.verbose("**** Failed: unexpected exception ****");
            e.printStackTrace();
            return;
        }
    }

    private void dotest(TestHarness harness, int num) {
        switch (num) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                this.diagabs(harness);
                break;
            }
            case 4: {
                this.diagadd(harness);
                break;
            }
            case 5: {
                this.diagcompareto(harness);
                break;
            }
            case 6: {
                this.diagdivide(harness);
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                this.diagmax(harness);
                break;
            }
            case 9: {
                this.diagmin(harness);
                break;
            }
            case 10: {
                this.diagmultiply(harness);
                break;
            }
            case 11: {
                this.diagnegate(harness);
                break;
            }
            case 12: {
                break;
            }
            case 13: {
                break;
            }
            case 14: {
                break;
            }
            case 15: {
                this.diagsubtract(harness);
                break;
            }
            case 16: {
                break;
            }
            case 17: {
                this.diagbyteValue(harness);
                break;
            }
            case 18: {
                this.diagcomparetoObj(harness);
                break;
            }
            case 19: {
                this.diagdoublevalue(harness);
                break;
            }
            case 20: {
                this.diagequals(harness);
                break;
            }
            case 21: {
                this.diagfloatvalue(harness);
                break;
            }
            case 22: {
                break;
            }
            case 23: {
                this.diaghashcode(harness);
                break;
            }
            case 24: {
                this.diagintvalue(harness);
                break;
            }
            case 25: {
                this.diaglongvalue(harness);
                break;
            }
            case 26: {
                this.diagmovepointleft(harness);
                break;
            }
            case 27: {
                this.diagmovepointright(harness);
                break;
            }
            case 28: {
                this.diagscale(harness);
                break;
            }
            case 29: {
                this.diagsetscale(harness);
                break;
            }
            case 30: {
                this.diagshortvalue(harness);
                break;
            }
            case 31: {
                this.diagsignum(harness);
                break;
            }
            case 32: {
                break;
            }
            case 33: {
                this.diagtobiginteger(harness);
                break;
            }
            case 34: {
                break;
            }
            case 35: {
                this.diagtostring(harness);
                break;
            }
            case 36: {
                break;
            }
            case 37: {
                this.diagvalueof(harness);
                break;
            }
            case 38: {
                this.diagmutation(harness);
                break;
            }
            default: {
                this.say("*** dotest case not found: " + num + " ***", harness);
            }
        }
    }

    public void diagconstructors(TestHarness harness) {
        boolean flag = false;
        RuntimeException e = null;
        int i = 0;
        harness.check(zero.toString().equals("0"), "con001");
        harness.check(one.toString().equals("1"), "con002");
        harness.check(ten.toString().equals("10"), "con003");
        harness.check(zero.intValue() == 0, "con004");
        harness.check(one.intValue() == 1, "con005");
        harness.check(ten.intValue() == 10, "con006");
        harness.check(new BigDecimal(new BigDecimal("0").toString()).toString().equals("0"), "cbd001");
        harness.check(new BigDecimal(new BigDecimal("1").toString()).toString().equals("1"), "cbd002");
        harness.check(new BigDecimal(new BigDecimal("10").toString()).toString().equals("10"), "cbd003");
        harness.check(new BigDecimal(new BigDecimal("1000").toString()).toString().equals("1000"), "cbd004");
        harness.check(new BigDecimal(new BigDecimal("10.0").toString()).toString().equals("10.0"), "cbd005");
        harness.check(new BigDecimal(new BigDecimal("10.1").toString()).toString().equals("10.1"), "cbd006");
        harness.check(new BigDecimal(new BigDecimal("-1.1").toString()).toString().equals("-1.1"), "cbd007");
        harness.check(new BigDecimal(new BigDecimal("-9.0").toString()).toString().equals("-9.0"), "cbd008");
        harness.check(new BigDecimal(new BigDecimal("0.9").toString()).toString().equals("0.9"), "cbd009");
        String num = "123456789.123456789";
        harness.check(new BigDecimal(new BigDecimal(num).toString()).toString().equals(num), "cbd010");
        num = "123456789.000000000";
        harness.check(new BigDecimal(new BigDecimal(num).toString()).toString().equals(num), "cbd011");
        num = "123456789000000000";
        harness.check(new BigDecimal(new BigDecimal(num).toString()).toString().equals(num), "cbd012");
        num = "0.00000123456789";
        harness.check(new BigDecimal(new BigDecimal(num).toString()).toString().equals(num), "cbd013");
        num = "0.000000123456789";
        harness.check(new BigDecimal(new BigDecimal(num).toString()).toString().equals(num), "cbd014");
        BigInteger bip = new BigInteger("987654321987654321987654321");
        BigInteger biz = new BigInteger("0");
        BigInteger bin = new BigInteger("-12345678998765432112345678");
        harness.check(new BigDecimal(bip).toString().equals(bip.toString()), "cbi001");
        harness.check(new BigDecimal(biz).toString().equals("0"), "cbi002");
        harness.check(new BigDecimal(bin).toString().equals(bin.toString()), "cbi003");
        try {
            new BigDecimal((BigInteger)null);
            flag = false;
        }
        catch (NullPointerException xx4) {
            flag = true;
        }
        harness.check(flag, "cbi004");
        bip = new BigInteger("123456789");
        BigDecimal bda = new BigDecimal(bip);
        BigDecimal bdb = new BigDecimal(bip, 5);
        BigDecimal bmc = new BigDecimal(bip, 15);
        harness.check(bda.toString().equals("123456789"), "cbs001");
        harness.check(bdb.toString().equals("1234.56789"), "cbs002");
        harness.check(bmc.toString().equals("0.000000123456789"), "cbs003");
        bip = new BigInteger("123456789123456789123456789");
        bda = new BigDecimal(bip);
        bdb = new BigDecimal(bip, 7);
        bmc = new BigDecimal(bip, 13);
        BigDecimal bmd = new BigDecimal(bip, 19);
        BigDecimal bme = new BigDecimal(bip, 29);
        harness.check(bda.toString().equals("123456789123456789123456789"), "cbs011");
        harness.check(bdb.toString().equals("12345678912345678912.3456789"), "cbs012");
        harness.check(bmc.toString().equals("12345678912345.6789123456789"), "cbs013");
        harness.check(bmd.toString().equals("12345678.9123456789123456789"), "cbs014");
        harness.check(bme.toString().equals("0.00123456789123456789123456789"), "cbs015");
        try {
            new BigDecimal((BigInteger)null, 1);
            flag = false;
        }
        catch (NullPointerException xx5) {
            flag = true;
        }
        harness.check(flag, "cbs004");
        try {
            new BigDecimal(bip, -8);
            flag = false;
        }
        catch (RuntimeException xx6) {
            e = xx6;
            flag = this.checkMessage(e, "Negative scale: -8");
        }
        harness.check(flag, "cbs005");
        double dzer = 0.0;
        double dpos = 1.0;
        double dneg = -(dpos /= 10.0);
        harness.check(new BigDecimal(dneg).toString().equals("-0.1000000000000000055511151231257827021181583404541015625"), "cdo001");
        harness.check(new BigDecimal(dzer).toString().equals("0"), "cdo002");
        harness.check(new BigDecimal(dpos).toString().equals("0.1000000000000000055511151231257827021181583404541015625"), "cdo003");
        double dpos5 = 0.5;
        double dneg5 = -dpos5;
        harness.check(new BigDecimal(dneg5).toString().equals("-0.5"), "cdo004");
        harness.check(new BigDecimal(dpos5).toString().equals("0.5"), "cdo005");
        double dmin = Double.MIN_VALUE;
        double dmax = Double.MAX_VALUE;
        harness.check(new BigDecimal(dmin).toString().equals("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"), "cdo006");
        harness.check(new BigDecimal(dmax).toString().equals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), "cdo007");
        double d = 9.0;
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.90000000000000002220446049250313080847263336181640625"), "cdo010");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.0899999999999999966693309261245303787291049957275390625"), "cdo011");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.00899999999999999931998839741709161899052560329437255859375"), "cdo012");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.00089999999999999997536692664112933925935067236423492431640625"), "cdo013");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.00008999999999999999211568180168541175589780323207378387451171875"), "cdo014");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.00000899999999999999853394182236510090433512232266366481781005859375"), "cdo015");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.000000899999999999999853394182236510090433512232266366481781005859375"), "cdo016");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.0000000899999999999999853394182236510090433512232266366481781005859375"), "cdo017");
        harness.check(new BigDecimal(d /= 10.0).toString().equals("0.000000008999999999999997872197332322678764437995369007694534957408905029296875"), "cdo018");
        try {
            new BigDecimal(Double.POSITIVE_INFINITY);
            flag = false;
        }
        catch (NumberFormatException xx13) {
            flag = true;
        }
        harness.check(flag, "cdo101");
        try {
            new BigDecimal(Double.NEGATIVE_INFINITY);
            flag = false;
        }
        catch (NumberFormatException xx14) {
            flag = true;
        }
        harness.check(flag, "cdo102");
        try {
            new BigDecimal(Double.NaN);
            flag = false;
        }
        catch (NumberFormatException xx15) {
            flag = true;
        }
        harness.check(flag, "cdo103");
        harness.check(new BigDecimal(Integer.MIN_VALUE).toString().equals("-2147483648"), "cin001");
        harness.check(new BigDecimal(Integer.MAX_VALUE).toString().equals("2147483647"), "cin002");
        harness.check(new BigDecimal(-1).toString().equals("-1"), "cin003");
        harness.check(new BigDecimal(0).toString().equals("0"), "cin004");
        harness.check(new BigDecimal(1).toString().equals("1"), "cin005");
        harness.check(new BigDecimal(10).toString().equals("10"), "cin006");
        harness.check(new BigDecimal(9).toString().equals("9"), "cin007");
        harness.check(new BigDecimal(5).toString().equals("5"), "cin008");
        harness.check(new BigDecimal(2).toString().equals("2"), "cin009");
        harness.check(new BigDecimal(-2).toString().equals("-2"), "cin010");
        harness.check(new BigDecimal(-5).toString().equals("-5"), "cin011");
        harness.check(new BigDecimal(-9).toString().equals("-9"), "cin012");
        harness.check(new BigDecimal(-10).toString().equals("-10"), "cin013");
        harness.check(new BigDecimal(-11).toString().equals("-11"), "cin014");
        harness.check(new BigDecimal(-99).toString().equals("-99"), "cin015");
        harness.check(new BigDecimal(-100).toString().equals("-100"), "cin016");
        harness.check(new BigDecimal(-999).toString().equals("-999"), "cin017");
        harness.check(new BigDecimal(-1000).toString().equals("-1000"), "cin018");
        harness.check(new BigDecimal(11).toString().equals("11"), "cin019");
        harness.check(new BigDecimal(99).toString().equals("99"), "cin020");
        harness.check(new BigDecimal(100).toString().equals("100"), "cin021");
        harness.check(new BigDecimal(999).toString().equals("999"), "cin022");
        harness.check(new BigDecimal(1000).toString().equals("1000"), "cin023");
        harness.check(new BigDecimal(Long.MIN_VALUE).toString().equals(lminString), "clo001");
        harness.check(new BigDecimal(Long.MAX_VALUE).toString().equals(lmaxString), "clo002");
        harness.check(new BigDecimal(-1L).toString().equals("-1"), "clo003");
        harness.check(new BigDecimal(0L).toString().equals("0"), "clo004");
        harness.check(new BigDecimal(1L).toString().equals("1"), "clo005");
        harness.check(new BigDecimal("12").toString().equals("12"), "cst001");
        harness.check(new BigDecimal("-76").toString().equals("-76"), "cst002");
        harness.check(new BigDecimal("12.76").toString().equals("12.76"), "cst003");
        harness.check(new BigDecimal("+12.76").toString().equals("12.76"), "cst004");
        harness.check(new BigDecimal("012.76").toString().equals("12.76"), "cst005");
        harness.check(new BigDecimal("+0.003").toString().equals("0.003"), "cst006");
        harness.check(new BigDecimal("17.").toString().equals("17"), "cst007");
        harness.check(new BigDecimal(".5").toString().equals("0.5"), "cst008");
        harness.check(new BigDecimal("044").toString().equals("44"), "cst009");
        harness.check(new BigDecimal("0044").toString().equals("44"), "cst010");
        harness.check(new BigDecimal("0.0005").toString().equals("0.0005"), "cst011");
        harness.check(new BigDecimal("00.00005").toString().equals("0.00005"), "cst012");
        harness.check(new BigDecimal("0.000005").toString().equals("0.000005"), "cst013");
        harness.check(new BigDecimal("0.0000005").toString().equals("0.0000005"), "cst014");
        harness.check(new BigDecimal("0.00000005").toString().equals("0.00000005"), "cst015");
        harness.check(new BigDecimal("12345678.876543210").toString().equals("12345678.876543210"), "cst016");
        harness.check(new BigDecimal("2345678.876543210").toString().equals("2345678.876543210"), "cst017");
        harness.check(new BigDecimal("345678.876543210").toString().equals("345678.876543210"), "cst018");
        harness.check(new BigDecimal("0345678.87654321").toString().equals("345678.87654321"), "cst019");
        harness.check(new BigDecimal("345678.8765432").toString().equals("345678.8765432"), "cst020");
        harness.check(new BigDecimal("+345678.8765432").toString().equals("345678.8765432"), "cst021");
        harness.check(new BigDecimal("+0345678.8765432").toString().equals("345678.8765432"), "cst022");
        harness.check(new BigDecimal("+00345678.8765432").toString().equals("345678.8765432"), "cst023");
        harness.check(new BigDecimal("-345678.8765432").toString().equals("-345678.8765432"), "cst024");
        harness.check(new BigDecimal("-0345678.8765432").toString().equals("-345678.8765432"), "cst025");
        harness.check(new BigDecimal("-00345678.8765432").toString().equals("-345678.8765432"), "cst026");
        harness.check(new BigDecimal("\u0e57.\u0e50").toString().equals("7.0"), "cst035");
        harness.check(new BigDecimal("\u0b66.\u0b67").toString().equals("0.1"), "cst036");
        harness.check(new BigDecimal("\u0b66\u0b66").toString().equals("0"), "cst037");
        harness.check(new BigDecimal("\u0b6a\u0b66").toString().equals("40"), "cst038");
        try {
            harness.check(new BigDecimal("1E+9").toString().equals("1E+9"), "cst040");
        }
        catch (Exception ecst040) {
            harness.check(false, "cst040");
        }
        try {
            harness.check(new BigDecimal("1e+09").toString().equals("1E+9"), "cst041");
        }
        catch (Exception ecst041) {
            harness.check(false, "cst041");
        }
        try {
            harness.check(new BigDecimal("1E+90").toString().equals("1E+90"), "cst042");
        }
        catch (Exception ecst042) {
            harness.check(false, "cst042");
        }
        try {
            harness.check(new BigDecimal("+1E+009").toString().equals("1E+9"), "cst043");
        }
        catch (Exception ecst043) {
            harness.check(false, "cst043");
        }
        try {
            harness.check(new BigDecimal("0E+9").toString().equals("0"), "cst044");
        }
        catch (Exception ecst044) {
            harness.check(false, "cst044");
        }
        try {
            harness.check(new BigDecimal("1E+9").toString().equals("1E+9"), "cst045");
        }
        catch (Exception ecst045) {
            harness.check(false, "cst045");
        }
        try {
            harness.check(new BigDecimal("1E+09").toString().equals("1E+9"), "cst046");
        }
        catch (Exception ecst046) {
            harness.check(false, "cst046");
        }
        try {
            harness.check(new BigDecimal("1e+90").toString().equals("1E+90"), "cst047");
        }
        catch (Exception ecst047) {
            harness.check(false, "cst047");
        }
        try {
            harness.check(new BigDecimal("1E+009").toString().equals("1E+9"), "cst048");
        }
        catch (Exception ecst048) {
            harness.check(false, "cst048");
        }
        try {
            harness.check(new BigDecimal("0E+9").toString().equals("0"), "cst049");
        }
        catch (Exception ecst049) {
            harness.check(false, "cst049");
        }
        try {
            harness.check(new BigDecimal("1E9").toString().equals("1E+9"), "cst050");
        }
        catch (Exception ecst050) {
            harness.check(false, "cst050");
        }
        try {
            harness.check(new BigDecimal("1e09").toString().equals("1E+9"), "cst051");
        }
        catch (Exception ecst051) {
            harness.check(false, "cst051");
        }
        try {
            harness.check(new BigDecimal("1E90").toString().equals("1E+90"), "cst052");
        }
        catch (Exception ecst052) {
            harness.check(false, "cst052");
        }
        try {
            harness.check(new BigDecimal("1E009").toString().equals("1E+9"), "cst053");
        }
        catch (Exception ecst053) {
            harness.check(false, "cst053");
        }
        try {
            harness.check(new BigDecimal("0E9").toString().equals("0"), "cst054");
        }
        catch (Exception ecst054) {
            harness.check(false, "cst054");
        }
        try {
            harness.check(new BigDecimal("0.000e+0").toString().equals("0"), "cst055");
        }
        catch (Exception ecst055) {
            harness.check(false, "cst055");
        }
        try {
            harness.check(new BigDecimal("0.000E-1").toString().equals("0"), "cst056");
        }
        catch (Exception ecst056) {
            harness.check(false, "cst056");
        }
        try {
            harness.check(new BigDecimal("4E+9").toString().equals("4E+9"), "cst057");
        }
        catch (Exception ecst057) {
            harness.check(false, "cst057");
        }
        try {
            harness.check(new BigDecimal("44E+9").toString().equals("4.4E+10"), "cst058");
        }
        catch (Exception ecst058) {
            harness.check(false, "cst058");
        }
        try {
            harness.check(new BigDecimal("0.73e-7").toString().equals("7.3E-8"), "cst059");
        }
        catch (Exception ecst059) {
            harness.check(false, "cst059");
        }
        try {
            harness.check(new BigDecimal("00E+9").toString().equals("0"), "cst060");
        }
        catch (Exception ecst060) {
            harness.check(false, "cst060");
        }
        try {
            harness.check(new BigDecimal("00E-9").toString().equals("0"), "cst061");
        }
        catch (Exception ecst061) {
            harness.check(false, "cst061");
        }
        try {
            harness.check(new BigDecimal("10E+9").toString().equals("1.0E+10"), "cst062");
        }
        catch (Exception ecst062) {
            harness.check(false, "cst062");
        }
        try {
            harness.check(new BigDecimal("10E+09").toString().equals("1.0E+10"), "cst063");
        }
        catch (Exception ecst063) {
            harness.check(false, "cst063");
        }
        try {
            harness.check(new BigDecimal("10e+90").toString().equals("1.0E+91"), "cst064");
        }
        catch (Exception ecst064) {
            harness.check(false, "cst064");
        }
        try {
            harness.check(new BigDecimal("10E+009").toString().equals("1.0E+10"), "cst065");
        }
        catch (Exception ecst065) {
            harness.check(false, "cst065");
        }
        try {
            harness.check(new BigDecimal("100e+9").toString().equals("1.00E+11"), "cst066");
        }
        catch (Exception ecst066) {
            harness.check(false, "cst066");
        }
        try {
            harness.check(new BigDecimal("100e+09").toString().equals("1.00E+11"), "cst067");
        }
        catch (Exception ecst067) {
            harness.check(false, "cst067");
        }
        try {
            harness.check(new BigDecimal("100E+90").toString().equals("1.00E+92"), "cst068");
        }
        catch (Exception ecst068) {
            harness.check(false, "cst068");
        }
        try {
            harness.check(new BigDecimal("100e+009").toString().equals("1.00E+11"), "cst069");
        }
        catch (Exception ecst069) {
            harness.check(false, "cst069");
        }
        try {
            harness.check(new BigDecimal("1.265").toString().equals("1.265"), "cst070");
        }
        catch (Exception ecst070) {
            harness.check(false, "cst070");
        }
        try {
            harness.check(new BigDecimal("1.265E-20").toString().equals("1.265E-20"), "cst071");
        }
        catch (Exception ecst071) {
            harness.check(false, "cst071");
        }
        try {
            harness.check(new BigDecimal("1.265E-8").toString().equals("1.265E-8"), "cst072");
        }
        catch (Exception ecst072) {
            harness.check(false, "cst072");
        }
        try {
            harness.check(new BigDecimal("1.265E-4").toString().equals("1.265E-4"), "cst073");
        }
        catch (Exception ecst073) {
            harness.check(false, "cst073");
        }
        try {
            harness.check(new BigDecimal("1.265E-3").toString().equals("1.265E-3"), "cst074");
        }
        catch (Exception ecst074) {
            harness.check(false, "cst074");
        }
        try {
            harness.check(new BigDecimal("1.265E-2").toString().equals("1.265E-2"), "cst075");
        }
        catch (Exception ecst075) {
            harness.check(false, "cst075");
        }
        try {
            harness.check(new BigDecimal("1.265E-1").toString().equals("1.265E-1"), "cst076");
        }
        catch (Exception ecst076) {
            harness.check(false, "cst076");
        }
        try {
            harness.check(new BigDecimal("1.265E-0").toString().equals("1.265"), "cst077");
        }
        catch (Exception ecst077) {
            harness.check(false, "cst077");
        }
        try {
            harness.check(new BigDecimal("1.265E+1").toString().equals("1.265E+1"), "cst078");
        }
        catch (Exception ecst078) {
            harness.check(false, "cst078");
        }
        try {
            harness.check(new BigDecimal("1.265E+2").toString().equals("1.265E+2"), "cst079");
        }
        catch (Exception ecst079) {
            harness.check(false, "cst079");
        }
        try {
            harness.check(new BigDecimal("1.265E+3").toString().equals("1.265E+3"), "cst080");
        }
        catch (Exception ecst080) {
            harness.check(false, "cst080");
        }
        try {
            harness.check(new BigDecimal("1.265E+4").toString().equals("1.265E+4"), "cst081");
        }
        catch (Exception ecst081) {
            harness.check(false, "cst081");
        }
        try {
            harness.check(new BigDecimal("1.265E+8").toString().equals("1.265E+8"), "cst082");
        }
        catch (Exception ecst082) {
            harness.check(false, "cst082");
        }
        try {
            harness.check(new BigDecimal("1.265E+20").toString().equals("1.265E+20"), "cst083");
        }
        catch (Exception ecst083) {
            harness.check(false, "cst083");
        }
        try {
            harness.check(new BigDecimal("12.65").toString().equals("12.65"), "cst090");
        }
        catch (Exception ecst090) {
            harness.check(false, "cst090");
        }
        try {
            harness.check(new BigDecimal("12.65E-20").toString().equals("1.265E-19"), "cst091");
        }
        catch (Exception ecst091) {
            harness.check(false, "cst091");
        }
        try {
            harness.check(new BigDecimal("12.65E-8").toString().equals("1.265E-7"), "cst092");
        }
        catch (Exception ecst092) {
            harness.check(false, "cst092");
        }
        try {
            harness.check(new BigDecimal("12.65E-4").toString().equals("1.265E-3"), "cst093");
        }
        catch (Exception ecst093) {
            harness.check(false, "cst093");
        }
        try {
            harness.check(new BigDecimal("12.65E-3").toString().equals("1.265E-2"), "cst094");
        }
        catch (Exception ecst094) {
            harness.check(false, "cst094");
        }
        try {
            harness.check(new BigDecimal("12.65E-2").toString().equals("1.265E-1"), "cst095");
        }
        catch (Exception ecst095) {
            harness.check(false, "cst095");
        }
        try {
            harness.check(new BigDecimal("12.65E-1").toString().equals("1.265"), "cst096");
        }
        catch (Exception ecst096) {
            harness.check(false, "cst096");
        }
        try {
            harness.check(new BigDecimal("12.65E-0").toString().equals("1.265E+1"), "cst097");
        }
        catch (Exception ecst097) {
            harness.check(false, "cst097");
        }
        try {
            harness.check(new BigDecimal("12.65E+1").toString().equals("1.265E+2"), "cst098");
        }
        catch (Exception ecst098) {
            harness.check(false, "cst098");
        }
        try {
            harness.check(new BigDecimal("12.65E+2").toString().equals("1.265E+3"), "cst099");
        }
        catch (Exception ecst099) {
            harness.check(false, "cst099");
        }
        try {
            harness.check(new BigDecimal("12.65E+3").toString().equals("1.265E+4"), "cst100");
        }
        catch (Exception ecst100) {
            harness.check(false, "cst100");
        }
        try {
            harness.check(new BigDecimal("12.65E+4").toString().equals("1.265E+5"), "cst101");
        }
        catch (Exception ecst101) {
            harness.check(false, "cst101");
        }
        try {
            harness.check(new BigDecimal("12.65E+8").toString().equals("1.265E+9"), "cst102");
        }
        catch (Exception ecst102) {
            harness.check(false, "cst102");
        }
        try {
            harness.check(new BigDecimal("12.65E+20").toString().equals("1.265E+21"), "cst103");
        }
        catch (Exception ecst103) {
            harness.check(false, "cst103");
        }
        try {
            harness.check(new BigDecimal("126.5").toString().equals("126.5"), "cst110");
        }
        catch (Exception ecst110) {
            harness.check(false, "cst110");
        }
        try {
            harness.check(new BigDecimal("126.5E-20").toString().equals("1.265E-18"), "cst111");
        }
        catch (Exception ecst111) {
            harness.check(false, "cst111");
        }
        try {
            harness.check(new BigDecimal("126.5E-8").toString().equals("1.265E-6"), "cst112");
        }
        catch (Exception ecst112) {
            harness.check(false, "cst112");
        }
        try {
            harness.check(new BigDecimal("126.5E-4").toString().equals("1.265E-2"), "cst113");
        }
        catch (Exception ecst113) {
            harness.check(false, "cst113");
        }
        try {
            harness.check(new BigDecimal("126.5E-3").toString().equals("1.265E-1"), "cst114");
        }
        catch (Exception ecst114) {
            harness.check(false, "cst114");
        }
        try {
            harness.check(new BigDecimal("126.5E-2").toString().equals("1.265"), "cst115");
        }
        catch (Exception ecst115) {
            harness.check(false, "cst115");
        }
        try {
            harness.check(new BigDecimal("126.5E-1").toString().equals("1.265E+1"), "cst116");
        }
        catch (Exception ecst116) {
            harness.check(false, "cst116");
        }
        try {
            harness.check(new BigDecimal("126.5E-0").toString().equals("1.265E+2"), "cst117");
        }
        catch (Exception ecst117) {
            harness.check(false, "cst117");
        }
        try {
            harness.check(new BigDecimal("126.5E+1").toString().equals("1.265E+3"), "cst118");
        }
        catch (Exception ecst118) {
            harness.check(false, "cst118");
        }
        try {
            harness.check(new BigDecimal("126.5E+2").toString().equals("1.265E+4"), "cst119");
        }
        catch (Exception ecst119) {
            harness.check(false, "cst119");
        }
        try {
            harness.check(new BigDecimal("126.5E+3").toString().equals("1.265E+5"), "cst120");
        }
        catch (Exception ecst120) {
            harness.check(false, "cst120");
        }
        try {
            harness.check(new BigDecimal("126.5E+4").toString().equals("1.265E+6"), "cst121");
        }
        catch (Exception ecst121) {
            harness.check(false, "cst121");
        }
        try {
            harness.check(new BigDecimal("126.5E+8").toString().equals("1.265E+10"), "cst122");
        }
        catch (Exception ecst122) {
            harness.check(false, "cst122");
        }
        try {
            harness.check(new BigDecimal("126.5E+20").toString().equals("1.265E+22"), "cst123");
        }
        catch (Exception ecst123) {
            harness.check(false, "cst123");
        }
        try {
            harness.check(new BigDecimal("1265").toString().equals("1265"), "cst130");
        }
        catch (Exception ecst130) {
            harness.check(false, "cst130");
        }
        try {
            harness.check(new BigDecimal("1265E-20").toString().equals("1.265E-17"), "cst131");
        }
        catch (Exception ecst131) {
            harness.check(false, "cst131");
        }
        try {
            harness.check(new BigDecimal("1265E-8").toString().equals("1.265E-5"), "cst132");
        }
        catch (Exception ecst132) {
            harness.check(false, "cst132");
        }
        try {
            harness.check(new BigDecimal("1265E-4").toString().equals("1.265E-1"), "cst133");
        }
        catch (Exception ecst133) {
            harness.check(false, "cst133");
        }
        try {
            harness.check(new BigDecimal("1265E-3").toString().equals("1.265"), "cst134");
        }
        catch (Exception ecst134) {
            harness.check(false, "cst134");
        }
        try {
            harness.check(new BigDecimal("1265E-2").toString().equals("1.265E+1"), "cst135");
        }
        catch (Exception ecst135) {
            harness.check(false, "cst135");
        }
        try {
            harness.check(new BigDecimal("1265E-1").toString().equals("1.265E+2"), "cst136");
        }
        catch (Exception ecst136) {
            harness.check(false, "cst136");
        }
        try {
            harness.check(new BigDecimal("1265E-0").toString().equals("1.265E+3"), "cst137");
        }
        catch (Exception ecst137) {
            harness.check(false, "cst137");
        }
        try {
            harness.check(new BigDecimal("1265E+1").toString().equals("1.265E+4"), "cst138");
        }
        catch (Exception ecst138) {
            harness.check(false, "cst138");
        }
        try {
            harness.check(new BigDecimal("1265E+2").toString().equals("1.265E+5"), "cst139");
        }
        catch (Exception ecst139) {
            harness.check(false, "cst139");
        }
        try {
            harness.check(new BigDecimal("1265E+3").toString().equals("1.265E+6"), "cst140");
        }
        catch (Exception ecst140) {
            harness.check(false, "cst140");
        }
        try {
            harness.check(new BigDecimal("1265E+4").toString().equals("1.265E+7"), "cst141");
        }
        catch (Exception ecst141) {
            harness.check(false, "cst141");
        }
        try {
            harness.check(new BigDecimal("1265E+8").toString().equals("1.265E+11"), "cst142");
        }
        catch (Exception ecst142) {
            harness.check(false, "cst142");
        }
        try {
            harness.check(new BigDecimal("1265E+20").toString().equals("1.265E+23"), "cst143");
        }
        catch (Exception ecst143) {
            harness.check(false, "cst143");
        }
        try {
            harness.check(new BigDecimal("0.1265").toString().equals("0.1265"), "cst150");
        }
        catch (Exception ecst150) {
            harness.check(false, "cst150");
        }
        try {
            harness.check(new BigDecimal("0.1265E-20").toString().equals("1.265E-21"), "cst151");
        }
        catch (Exception ecst151) {
            harness.check(false, "cst151");
        }
        try {
            harness.check(new BigDecimal("0.1265E-8").toString().equals("1.265E-9"), "cst152");
        }
        catch (Exception ecst152) {
            harness.check(false, "cst152");
        }
        try {
            harness.check(new BigDecimal("0.1265E-4").toString().equals("1.265E-5"), "cst153");
        }
        catch (Exception ecst153) {
            harness.check(false, "cst153");
        }
        try {
            harness.check(new BigDecimal("0.1265E-3").toString().equals("1.265E-4"), "cst154");
        }
        catch (Exception ecst154) {
            harness.check(false, "cst154");
        }
        try {
            harness.check(new BigDecimal("0.1265E-2").toString().equals("1.265E-3"), "cst155");
        }
        catch (Exception ecst155) {
            harness.check(false, "cst155");
        }
        try {
            harness.check(new BigDecimal("0.1265E-1").toString().equals("1.265E-2"), "cst156");
        }
        catch (Exception ecst156) {
            harness.check(false, "cst156");
        }
        try {
            harness.check(new BigDecimal("0.1265E-0").toString().equals("1.265E-1"), "cst157");
        }
        catch (Exception ecst157) {
            harness.check(false, "cst157");
        }
        try {
            harness.check(new BigDecimal("0.1265E+1").toString().equals("1.265"), "cst158");
        }
        catch (Exception ecst158) {
            harness.check(false, "cst158");
        }
        try {
            harness.check(new BigDecimal("0.1265E+2").toString().equals("1.265E+1"), "cst159");
        }
        catch (Exception ecst159) {
            harness.check(false, "cst159");
        }
        try {
            harness.check(new BigDecimal("0.1265E+3").toString().equals("1.265E+2"), "cst160");
        }
        catch (Exception ecst160) {
            harness.check(false, "cst160");
        }
        try {
            harness.check(new BigDecimal("0.1265E+4").toString().equals("1.265E+3"), "cst161");
        }
        catch (Exception ecst161) {
            harness.check(false, "cst161");
        }
        try {
            harness.check(new BigDecimal("0.1265E+8").toString().equals("1.265E+7"), "cst162");
        }
        catch (Exception ecst162) {
            harness.check(false, "cst162");
        }
        try {
            harness.check(new BigDecimal("0.1265E+20").toString().equals("1.265E+19"), "cst163");
        }
        catch (Exception ecst163) {
            harness.check(false, "cst163");
        }
        try {
            harness.check(new BigDecimal("0.09e999999999").toString().equals("9E+999999997"), "cst170");
        }
        catch (Exception ecst170) {
            harness.check(false, "cst170");
        }
        try {
            harness.check(new BigDecimal("0.9e999999999").toString().equals("9E+999999998"), "cst171");
        }
        catch (Exception ecst171) {
            harness.check(false, "cst171");
        }
        try {
            harness.check(new BigDecimal("9e999999999").toString().equals("9E+999999999"), "cst172");
        }
        catch (Exception ecst172) {
            harness.check(false, "cst172");
        }
        try {
            harness.check(new BigDecimal("9.9e999999999").toString().equals("9.9E+999999999"), "cst173");
        }
        catch (Exception ecst173) {
            harness.check(false, "cst173");
        }
        try {
            harness.check(new BigDecimal("9.99e999999999").toString().equals("9.99E+999999999"), "cst174");
        }
        catch (Exception ecst174) {
            harness.check(false, "cst174");
        }
        try {
            harness.check(new BigDecimal("9.99e-999999999").toString().equals("9.99E-999999999"), "cst175");
        }
        catch (Exception ecst175) {
            harness.check(false, "cst175");
        }
        try {
            harness.check(new BigDecimal("9.9e-999999999").toString().equals("9.9E-999999999"), "cst176");
        }
        catch (Exception ecst176) {
            harness.check(false, "cst176");
        }
        try {
            harness.check(new BigDecimal("9e-999999999").toString().equals("9E-999999999"), "cst177");
        }
        catch (Exception ecst177) {
            harness.check(false, "cst177");
        }
        try {
            harness.check(new BigDecimal("99e-999999999").toString().equals("9.9E-999999998"), "cst179");
        }
        catch (Exception ecst179) {
            harness.check(false, "cst179");
        }
        try {
            harness.check(new BigDecimal("999e-999999999").toString().equals("9.99E-999999997"), "cst180");
        }
        catch (Exception ecst180) {
            harness.check(false, "cst180");
        }
        String[] badstrings = new String[]{"1..2", ".", "..", "++1", "--1", "-+1", "+-1", "12e", "12e++", "12f4", " +1", "+ 1", "12 ", " + 1", " - 1 ", "x", "-1-", "12-", "3+", "", "1e-", "7e1000000000", "", "e100", "\u0e5a", "\u0b65", "99e999999999", "999e999999999", "0.9e-999999999", "0.09e-999999999", "0.1e1000000000", "10e-1000000000", "0.9e9999999999", "99e-9999999999", "111e9999999999", "1111e-9999999999 111e*123", "111e123-", "111e+12+", "111e1-3-", "111e1*23", "111e1e+3", "1e1.0", "1e123e", "ten", "ONE", "1e.1", "1e1.", "1ee", "e+1"};
        int xx16 = badstrings.length;
        i = 0;
        while (xx16 > 0) {
            try {
                new BigDecimal(badstrings[i]);
                this.say(">>> cst" + (200 + i) + ": " + badstrings[i] + " " + new BigDecimal(badstrings[i]).toString(), harness);
                flag = false;
            }
            catch (NumberFormatException xx17) {
                flag = true;
            }
            harness.check(flag, "cst" + (200 + i));
            --xx16;
            ++i;
        }
        try {
            new BigDecimal((String)null);
            flag = false;
        }
        catch (NullPointerException xx18) {
            flag = true;
        }
        harness.check(flag, "cst301");
    }

    public void diagmutation(TestHarness harness) {
        harness.check(zero.toString().equals("0"), "cuc001");
        harness.check(one.toString().equals("1"), "cuc002");
        harness.check(ten.toString().equals("10"), "cuc003");
    }

    public void diagabs(TestHarness harness) {
        boolean flag = false;
        Object ae = null;
        harness.check(new BigDecimal("2").abs().toString().equals("2"), "abs001");
        harness.check(new BigDecimal("-2").abs().toString().equals("2"), "abs002");
        harness.check(new BigDecimal("+0.000").abs().toString().equals("0.000"), "abs003");
        harness.check(new BigDecimal("00.000").abs().toString().equals("0.000"), "abs004");
        harness.check(new BigDecimal("-0.000").abs().toString().equals("0.000"), "abs005");
        harness.check(new BigDecimal("-2000000").abs().toString().equals("2000000"), "abs009");
        harness.check(new BigDecimal("0.2").abs().toString().equals("0.2"), "abs013");
        harness.check(new BigDecimal("-0.2").abs().toString().equals("0.2"), "abs014");
        harness.check(new BigDecimal("0.01").abs().toString().equals("0.01"), "abs015");
        harness.check(new BigDecimal("-0.01").abs().toString().equals("0.01"), "abs016");
    }

    public void diagadd(TestHarness harness) {
        boolean flag = false;
        Object ae = null;
        harness.check(new BigDecimal(2).add(new BigDecimal(3)).toString().equals("5"), "add030");
        harness.check(new BigDecimal("5.75").add(new BigDecimal("3.3")).toString().equals("9.05"), "add031");
        harness.check(new BigDecimal("5").add(new BigDecimal("-3")).toString().equals("2"), "add032");
        harness.check(new BigDecimal("-5").add(new BigDecimal("-3")).toString().equals("-8"), "add033");
        harness.check(new BigDecimal("-7").add(new BigDecimal("2.5")).toString().equals("-4.5"), "add034");
        harness.check(new BigDecimal("0.7").add(new BigDecimal("0.3")).toString().equals("1.0"), "add035");
        harness.check(new BigDecimal("1.25").add(new BigDecimal("1.25")).toString().equals("2.50"), "add036");
        harness.check(new BigDecimal("1.23456789").add(new BigDecimal("1.00000000")).toString().equals("2.23456789"), "add037");
        harness.check(new BigDecimal("1.23456789").add(new BigDecimal("1.00000011")).toString().equals("2.23456800"), "add038");
        harness.check(new BigDecimal("0.4444444444").add(new BigDecimal("0.5555555555")).toString().equals("0.9999999999"), "add039");
        harness.check(new BigDecimal("0.4444444440").add(new BigDecimal("0.5555555555")).toString().equals("0.9999999995"), "add040");
        harness.check(new BigDecimal("0.4444444444").add(new BigDecimal("0.5555555550")).toString().equals("0.9999999994"), "add041");
        harness.check(new BigDecimal("0.4444444444999").add(new BigDecimal("0")).toString().equals("0.4444444444999"), "add042");
        harness.check(new BigDecimal("0.4444444445000").add(new BigDecimal("0")).toString().equals("0.4444444445000"), "add043");
        harness.check(new BigDecimal("70").add(new BigDecimal("10000e+9")).toString().equals("10000000000070"), "add044");
        harness.check(new BigDecimal("700").add(new BigDecimal("10000e+9")).toString().equals("10000000000700"), "add045");
        harness.check(new BigDecimal("7000").add(new BigDecimal("10000e+9")).toString().equals("10000000007000"), "add046");
        harness.check(new BigDecimal("70000").add(new BigDecimal("10000e+9")).toString().equals("10000000070000"), "add047");
        harness.check(new BigDecimal("700000").add(new BigDecimal("10000e+9")).toString().equals("10000000700000"), "add048");
        harness.check(new BigDecimal("10000e+9").add(new BigDecimal("70")).toString().equals("10000000000070"), "add054");
        harness.check(new BigDecimal("10000e+9").add(new BigDecimal("700")).toString().equals("10000000000700"), "add055");
        harness.check(new BigDecimal("10000e+9").add(new BigDecimal("7000")).toString().equals("10000000007000"), "add056");
        harness.check(new BigDecimal("10000e+9").add(new BigDecimal("70000")).toString().equals("10000000070000"), "add057");
        harness.check(new BigDecimal("10000e+9").add(new BigDecimal("700000")).toString().equals("10000000700000"), "add058");
        harness.check(new BigDecimal("0.9998").add(new BigDecimal("0.0000")).toString().equals("0.9998"), "add059");
        harness.check(new BigDecimal("0.9998").add(new BigDecimal("0.0001")).toString().equals("0.9999"), "add060");
        harness.check(new BigDecimal("0.9998").add(new BigDecimal("0.0002")).toString().equals("1.0000"), "add061");
        harness.check(new BigDecimal("0.9998").add(new BigDecimal("0.0003")).toString().equals("1.0001"), "add062");
        harness.check(new BigDecimal("-56267E-10").add(zero).toString().equals("-0.0000056267"), "add090");
        harness.check(new BigDecimal("-56267E-6").add(zero).toString().equals("-0.056267"), "add091");
        harness.check(new BigDecimal("-56267E-5").add(zero).toString().equals("-0.56267"), "add092");
        harness.check(new BigDecimal("-56267E-4").add(zero).toString().equals("-5.6267"), "add093");
        harness.check(new BigDecimal("-56267E-3").add(zero).toString().equals("-56.267"), "add094");
        harness.check(new BigDecimal("-56267E-2").add(zero).toString().equals("-562.67"), "add095");
        harness.check(new BigDecimal("-56267E-1").add(zero).toString().equals("-5626.7"), "add096");
        harness.check(new BigDecimal("-56267E-0").add(zero).toString().equals("-56267"), "add097");
        harness.check(new BigDecimal("-5E-10").add(zero).toString().equals("-5E-10"), "add098");
        harness.check(new BigDecimal("-5E-5").add(zero).toString().equals("-0.00005"), "add099");
        harness.check(new BigDecimal("-5E-1").add(zero).toString().equals("-0.5"), "add100");
        harness.check(new BigDecimal("-5E-10").add(zero).toString().equals("-5E-10"), "add101");
        harness.check(new BigDecimal("-5E-5").add(zero).toString().equals("-0.00005"), "add102");
        harness.check(new BigDecimal("-5E-1").add(zero).toString().equals("-0.5"), "add103");
        harness.check(new BigDecimal("-5E10").add(zero).toString().equals("-50000000000"), "add104");
        harness.check(new BigDecimal("-5E5").add(zero).toString().equals("-500000"), "add105");
        harness.check(new BigDecimal("-5E1").add(zero).toString().equals("-50"), "add106");
        harness.check(new BigDecimal("-5E0").add(zero).toString().equals("-5"), "add107");
        harness.check(zero.add(new BigDecimal("-56267E-10")).toString().equals("-0.0000056267"), "add108");
        harness.check(zero.add(new BigDecimal("-56267E-6")).toString().equals("-0.056267"), "add109");
        harness.check(zero.add(new BigDecimal("-56267E-5")).toString().equals("-0.56267"), "add110");
        harness.check(zero.add(new BigDecimal("-56267E-4")).toString().equals("-5.6267"), "add111");
        harness.check(zero.add(new BigDecimal("-56267E-3")).toString().equals("-56.267"), "add112");
        harness.check(zero.add(new BigDecimal("-56267E-2")).toString().equals("-562.67"), "add113");
        harness.check(zero.add(new BigDecimal("-56267E-1")).toString().equals("-5626.7"), "add114");
        harness.check(zero.add(new BigDecimal("-56267E-0")).toString().equals("-56267"), "add115");
        harness.check(zero.add(new BigDecimal("-5E-10")).toString().equals("-5E-10"), "add116");
        harness.check(zero.add(new BigDecimal("-5E-5")).toString().equals("-0.00005"), "add117");
        harness.check(zero.add(new BigDecimal("-5E-1")).toString().equals("-0.5"), "add118");
        harness.check(zero.add(new BigDecimal("-5E-10")).toString().equals("-5E-10"), "add129");
        harness.check(zero.add(new BigDecimal("-5E-5")).toString().equals("-0.00005"), "add130");
        harness.check(zero.add(new BigDecimal("-5E-1")).toString().equals("-0.5"), "add131");
        harness.check(zero.add(new BigDecimal("-5E10")).toString().equals("-50000000000"), "add132");
        harness.check(zero.add(new BigDecimal("-5E5")).toString().equals("-500000"), "add133");
        harness.check(zero.add(new BigDecimal("-5E1")).toString().equals("-50"), "add134");
        harness.check(zero.add(new BigDecimal("-5E0")).toString().equals("-5"), "add135");
        harness.check(new BigDecimal("00.0").add(new BigDecimal("0.00")).toString().equals("0.00"), "add150");
        harness.check(new BigDecimal("0.00").add(new BigDecimal("00.0")).toString().equals("0.00"), "add151");
        harness.check(new BigDecimal("3").add(new BigDecimal(".3")).toString().equals("3.3"), "add152");
        harness.check(new BigDecimal("3.").add(new BigDecimal(".3")).toString().equals("3.3"), "add153");
        harness.check(new BigDecimal("3.0").add(new BigDecimal(".3")).toString().equals("3.3"), "add154");
        harness.check(new BigDecimal("3.00").add(new BigDecimal(".3")).toString().equals("3.30"), "add155");
        harness.check(new BigDecimal("3").add(new BigDecimal("3")).toString().equals("6"), "add156");
        harness.check(new BigDecimal("3").add(new BigDecimal("+3")).toString().equals("6"), "add157");
        harness.check(new BigDecimal("3").add(new BigDecimal("-3")).toString().equals("0"), "add158");
        harness.check(new BigDecimal("0.3").add(new BigDecimal("-0.3")).toString().equals("0.0"), "add159");
        harness.check(new BigDecimal("0.03").add(new BigDecimal("-0.03")).toString().equals("0.00"), "add160");
        BigDecimal alhs = new BigDecimal("12345678900000");
        BigDecimal arhs = new BigDecimal("9999999999999");
        try {
            ten.add(null);
            flag = false;
        }
        catch (NullPointerException xx22) {
            flag = true;
        }
        harness.check(flag, "add200");
    }

    public void diagcompareto(TestHarness harness) {
        boolean flag = false;
        Object ae = null;
        harness.check(new BigDecimal("5").compareTo(new BigDecimal("2")) == 1, "cpt001");
        harness.check(new BigDecimal("5").compareTo(new BigDecimal("5")) == 0, "cpt002");
        harness.check(new BigDecimal("5").compareTo(new BigDecimal("5.00")) == 0, "cpt003");
        harness.check(new BigDecimal("0.5").compareTo(new BigDecimal("0.5")) == 0, "cpt004");
        harness.check(new BigDecimal("2").compareTo(new BigDecimal("5")) == -1, "cpt005");
        try {
            ten.compareTo((BigDecimal)null);
            flag = false;
        }
        catch (NullPointerException xx28) {
            flag = true;
        }
        harness.check(flag, "cpt100");
    }

    public void diagdivide(TestHarness harness) {
        boolean flag = false;
        Object e = null;
        ArithmeticException ae = null;
        harness.check(new BigDecimal("1").divide(new BigDecimal("3"), 4).toString().equals("0"), "div350");
        harness.check(new BigDecimal("2").divide(new BigDecimal("3"), 4).toString().equals("1"), "div351");
        harness.check(new BigDecimal("2.4").divide(new BigDecimal("1"), 4).toString().equals("2.4"), "div352");
        harness.check(new BigDecimal("2.4").divide(new BigDecimal("-1"), 4).toString().equals("-2.4"), "div353");
        harness.check(new BigDecimal("-2.4").divide(new BigDecimal("1"), 4).toString().equals("-2.4"), "div354");
        harness.check(new BigDecimal("-2.4").divide(new BigDecimal("-1"), 4).toString().equals("2.4"), "div355");
        harness.check(new BigDecimal("2.40").divide(new BigDecimal("1"), 4).toString().equals("2.40"), "div356");
        harness.check(new BigDecimal("2.400").divide(new BigDecimal("1"), 4).toString().equals("2.400"), "div357");
        harness.check(new BigDecimal("2.4").divide(new BigDecimal("2"), 4).toString().equals("1.2"), "div358");
        harness.check(new BigDecimal("2.400").divide(new BigDecimal("2"), 4).toString().equals("1.200"), "div359");
        harness.check(new BigDecimal("2.").divide(new BigDecimal("2"), 4).toString().equals("1"), "div360");
        harness.check(new BigDecimal("20").divide(new BigDecimal("20"), 4).toString().equals("1"), "div361");
        harness.check(new BigDecimal("187").divide(new BigDecimal("187"), 4).toString().equals("1"), "div362");
        harness.check(new BigDecimal("5").divide(new BigDecimal("2"), 4).toString().equals("3"), "div363");
        harness.check(new BigDecimal("5").divide(new BigDecimal("2.0"), 4).toString().equals("3"), "div364");
        harness.check(new BigDecimal("5").divide(new BigDecimal("2.000"), 4).toString().equals("3"), "div365");
        harness.check(new BigDecimal("5").divide(new BigDecimal("0.200"), 4).toString().equals("25"), "div366");
        harness.check(new BigDecimal("5.0").divide(new BigDecimal("2"), 4).toString().equals("2.5"), "div367");
        harness.check(new BigDecimal("5.0").divide(new BigDecimal("2.0"), 4).toString().equals("2.5"), "div368");
        harness.check(new BigDecimal("5.0").divide(new BigDecimal("2.000"), 4).toString().equals("2.5"), "div369");
        harness.check(new BigDecimal("5.0").divide(new BigDecimal("0.200"), 4).toString().equals("25.0"), "div370");
        harness.check(new BigDecimal("999999999").divide(new BigDecimal("1"), 4).toString().equals("999999999"), "div371");
        harness.check(new BigDecimal("999999999.4").divide(new BigDecimal("1"), 4).toString().equals("999999999.4"), "div372");
        harness.check(new BigDecimal("999999999.5").divide(new BigDecimal("1"), 4).toString().equals("999999999.5"), "div373");
        harness.check(new BigDecimal("999999999.9").divide(new BigDecimal("1"), 4).toString().equals("999999999.9"), "div374");
        harness.check(new BigDecimal("999999999.999").divide(new BigDecimal("1"), 4).toString().equals("999999999.999"), "div375");
        harness.check(new BigDecimal("0.0000E-5").divide(new BigDecimal("1"), 4).toString().equals("0E-9"), "div376");
        harness.check(new BigDecimal("0.000000000").divide(new BigDecimal("1"), 4).toString().equals("0E-9"), "div377");
        harness.check(new BigDecimal("0").divide(new BigDecimal("3"), 4).toString().equals("0"), "div001");
        harness.check(new BigDecimal("1").divide(new BigDecimal("3"), 4).toString().equals("0"), "div008");
        harness.check(new BigDecimal("2").divide(new BigDecimal("3"), 4).toString().equals("1"), "div015");
        try {
            new BigDecimal("5").divide(new BigDecimal("0.00"), 4);
            flag = false;
        }
        catch (ArithmeticException xx40) {
            ae = xx40;
            flag = this.checkMessage(ae, "Divide by 0");
        }
        harness.check(flag, "div204");
    }

    public void diagmax(TestHarness harness) {
        boolean flag = false;
        Object ae = null;
        harness.check(new BigDecimal("5").max(new BigDecimal("2")).toString().equals("5"), "max001");
        harness.check(new BigDecimal("5").max(new BigDecimal("5")).toString().equals("5"), "max002");
        harness.check(new BigDecimal("2").max(new BigDecimal("7")).toString().equals("7"), "max003");
        harness.check(new BigDecimal("2E+3").max(new BigDecimal("7")).toString().equals("2E+3"), "max006");
        harness.check(new BigDecimal("7").max(new BigDecimal("2E+3")).toString().equals("2E+3"), "max008");
        try {
            ten.max(null);
            flag = false;
        }
        catch (NullPointerException xx47) {
            flag = true;
        }
        harness.check(flag, "max010");
    }

    public void diagmin(TestHarness harness) {
        boolean flag = false;
        BigDecimal minx = null;
        Object ae = null;
        harness.check(new BigDecimal("5").min(new BigDecimal("2")).toString().equals("2"), "min001");
        harness.check(new BigDecimal("5").min(new BigDecimal("5")).toString().equals("5"), "min002");
        harness.check(new BigDecimal("2").min(new BigDecimal("7")).toString().equals("2"), "min003");
        harness.check(new BigDecimal("-2E+3").min(new BigDecimal("7")).toString().equals("-2E+3"), "min006");
        harness.check(new BigDecimal("7").min(new BigDecimal("-2E+3")).toString().equals("-2E+3"), "min008");
        try {
            minx = ten;
            minx.min(null);
            flag = false;
        }
        catch (NullPointerException xx51) {
            flag = true;
        }
        harness.check(flag, "min010");
    }

    public void diagmultiply(TestHarness harness) {
        boolean flag = false;
        Object d1 = null;
        Object d2 = null;
        Object oe = null;
        Object ae = null;
        harness.check(new BigDecimal("2").multiply(new BigDecimal("3")).toString().equals("6"), "mul020");
        harness.check(new BigDecimal("5").multiply(new BigDecimal("1")).toString().equals("5"), "mul021");
        harness.check(new BigDecimal("5").multiply(new BigDecimal("2")).toString().equals("10"), "mul022");
        harness.check(new BigDecimal("1.20").multiply(new BigDecimal("2")).toString().equals("2.40"), "mul023");
        harness.check(new BigDecimal("1.20").multiply(new BigDecimal("0")).toString().equals("0.00"), "mul024");
        harness.check(new BigDecimal("1.20").multiply(new BigDecimal("-2")).toString().equals("-2.40"), "mul025");
        harness.check(new BigDecimal("-1.20").multiply(new BigDecimal("2")).toString().equals("-2.40"), "mul026");
        harness.check(new BigDecimal("-1.20").multiply(new BigDecimal("0")).toString().equals("0.00"), "mul027");
        harness.check(new BigDecimal("-1.20").multiply(new BigDecimal("-2")).toString().equals("2.40"), "mul028");
        harness.check(new BigDecimal("5.09").multiply(new BigDecimal("7.1")).toString().equals("36.139"), "mul029");
        harness.check(new BigDecimal("2.5").multiply(new BigDecimal("4")).toString().equals("10.0"), "mul030");
        harness.check(new BigDecimal("2.50").multiply(new BigDecimal("4")).toString().equals("10.00"), "mul031");
        harness.check(new BigDecimal("1.23456789").multiply(new BigDecimal("1.00000000")).toString().equals("1.2345678900000000"), "mul032");
        harness.check(new BigDecimal("1234.56789").multiply(new BigDecimal("-1000.00000")).toString().equals("-1234567.8900000000"), "mul033");
        harness.check(new BigDecimal("-1234.56789").multiply(new BigDecimal("1000.00000")).toString().equals("-1234567.8900000000"), "mul034");
        harness.check(new BigDecimal("9.999999999").multiply(new BigDecimal("9.999999999")).toString().equals("99.999999980000000001"), "mul035");
        harness.check(new BigDecimal("5.00").multiply(new BigDecimal("1E-3")).toString().equals("0.00500"), "mul036");
        harness.check(new BigDecimal("00.00").multiply(new BigDecimal("0.000")).toString().equals("0.00000"), "mul037");
        harness.check(new BigDecimal("00.00").multiply(new BigDecimal("0E-3")).toString().equals("0.00000"), "mul038");
        harness.check(new BigDecimal("999999999999").multiply(new BigDecimal("9765625")).toString().equals("9765624999990234375"), "mul039");
        BigDecimal l9 = new BigDecimal("123456789E+10");
        BigDecimal l77e = new BigDecimal("77E-20");
        harness.check(l9.multiply(new BigDecimal("3456757")).toString().equals("4.26760119573273E+24"), "mul040");
        harness.check(l9.multiply(l77e).toString().equals("0.9506172753"), "mul042");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9")).toString().equals("81"), "mul101");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90")).toString().equals("810"), "mul102");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900")).toString().equals("8100"), "mul103");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000")).toString().equals("81000"), "mul104");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000")).toString().equals("810000"), "mul105");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900000")).toString().equals("8100000"), "mul106");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000000")).toString().equals("81000000"), "mul107");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000000")).toString().equals("810000000"), "mul108");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900000000")).toString().equals("8100000000"), "mul109");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000000000")).toString().equals("81000000000"), "mul110");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000000000")).toString().equals("810000000000"), "mul111");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900000000000")).toString().equals("8100000000000"), "mul112");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000000000000")).toString().equals("81000000000000"), "mul113");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000000000000")).toString().equals("810000000000000"), "mul114");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900000000000000")).toString().equals("8100000000000000"), "mul115");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000000000000000")).toString().equals("81000000000000000"), "mul116");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000000000000000")).toString().equals("810000000000000000"), "mul117");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900000000000000000")).toString().equals("8100000000000000000"), "mul118");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000000000000000000")).toString().equals("81000000000000000000"), "mul119");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000000000000000000")).toString().equals("810000000000000000000"), "mul120");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("900000000000000000000")).toString().equals("8100000000000000000000"), "mul121");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("9000000000000000000000")).toString().equals("81000000000000000000000"), "mul122");
        harness.check(new BigDecimal("9").multiply(new BigDecimal("90000000000000000000000")).toString().equals("810000000000000000000000"), "mul123");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3")).toString().equals("9"), "mul131");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30")).toString().equals("90"), "mul132");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300")).toString().equals("900"), "mul133");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000")).toString().equals("9000"), "mul134");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000")).toString().equals("90000"), "mul135");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300000")).toString().equals("900000"), "mul136");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000000")).toString().equals("9000000"), "mul137");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000000")).toString().equals("90000000"), "mul138");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300000000")).toString().equals("900000000"), "mul139");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000000000")).toString().equals("9000000000"), "mul140");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000000000")).toString().equals("90000000000"), "mul141");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300000000000")).toString().equals("900000000000"), "mul142");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000000000000")).toString().equals("9000000000000"), "mul143");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000000000000")).toString().equals("90000000000000"), "mul144");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300000000000000")).toString().equals("900000000000000"), "mul145");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000000000000000")).toString().equals("9000000000000000"), "mul146");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000000000000000")).toString().equals("90000000000000000"), "mul147");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300000000000000000")).toString().equals("900000000000000000"), "mul148");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000000000000000000")).toString().equals("9000000000000000000"), "mul149");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000000000000000000")).toString().equals("90000000000000000000"), "mul150");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("300000000000000000000")).toString().equals("900000000000000000000"), "mul151");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("3000000000000000000000")).toString().equals("9000000000000000000000"), "mul152");
        harness.check(new BigDecimal("3").multiply(new BigDecimal("30000000000000000000000")).toString().equals("90000000000000000000000"), "mul153");
        try {
            ten.multiply(null);
            flag = false;
        }
        catch (NullPointerException xx55) {
            flag = true;
        }
        harness.check(flag, "mul200");
    }

    public void diagnegate(TestHarness harness) {
        boolean flag = false;
        Object ae = null;
        harness.check(new BigDecimal("2").negate().toString().equals("-2"), "neg001");
        harness.check(new BigDecimal("-2").negate().toString().equals("2"), "neg002");
        harness.check(new BigDecimal("2.00").negate().toString().equals("-2.00"), "neg010");
        harness.check(new BigDecimal("-2.00").negate().toString().equals("2.00"), "neg011");
        harness.check(new BigDecimal("0").negate().toString().equals("0"), "neg012");
        harness.check(new BigDecimal("0.00").negate().toString().equals("0.00"), "neg013");
        harness.check(new BigDecimal("00.0").negate().toString().equals("0.0"), "neg014");
        harness.check(new BigDecimal("00.00").negate().toString().equals("0.00"), "neg015");
        harness.check(new BigDecimal("00").negate().toString().equals("0"), "neg016");
        harness.check(new BigDecimal("-2000000").negate().toString().equals("2000000"), "neg020");
    }

    public void diagsubtract(TestHarness harness) {
        boolean flag = false;
        Object ae = null;
        harness.check(new BigDecimal(2).subtract(new BigDecimal(3)).toString().equals("-1"), "sub001");
        harness.check(new BigDecimal("5.75").subtract(new BigDecimal("3.3")).toString().equals("2.45"), "sub002");
        harness.check(new BigDecimal("5").subtract(new BigDecimal("-3")).toString().equals("8"), "sub003");
        harness.check(new BigDecimal("-5").subtract(new BigDecimal("-3")).toString().equals("-2"), "sub004");
        harness.check(new BigDecimal("-7").subtract(new BigDecimal("2.5")).toString().equals("-9.5"), "sub005");
        harness.check(new BigDecimal("0.7").subtract(new BigDecimal("0.3")).toString().equals("0.4"), "sub006");
        harness.check(new BigDecimal("1.3").subtract(new BigDecimal("0.3")).toString().equals("1.0"), "sub007");
        harness.check(new BigDecimal("1.25").subtract(new BigDecimal("1.25")).toString().equals("0.00"), "sub008");
        harness.check(new BigDecimal("0.02").subtract(new BigDecimal("0.02")).toString().equals("0.00"), "sub009");
        harness.check(new BigDecimal("1.23456789").subtract(new BigDecimal("1.00000000")).toString().equals("0.23456789"), "sub010");
        harness.check(new BigDecimal("1.23456789").subtract(new BigDecimal("1.00000089")).toString().equals("0.23456700"), "sub011");
        harness.check(new BigDecimal("0.5555555559").subtract(new BigDecimal("0.0000000001")).toString().equals("0.5555555558"), "sub012");
        harness.check(new BigDecimal("0.5555555559").subtract(new BigDecimal("0.0000000005")).toString().equals("0.5555555554"), "sub013");
        harness.check(new BigDecimal("0.4444444444").subtract(new BigDecimal("0.1111111111")).toString().equals("0.3333333333"), "sub014");
        harness.check(new BigDecimal("1.0000000000").subtract(new BigDecimal("0.00000001")).toString().equals("0.9999999900"), "sub015");
        harness.check(new BigDecimal("0.4444444444999").subtract(new BigDecimal("0")).toString().equals("0.4444444444999"), "sub016");
        harness.check(new BigDecimal("0.4444444445000").subtract(new BigDecimal("0")).toString().equals("0.4444444445000"), "sub017");
        harness.check(new BigDecimal("70").subtract(new BigDecimal("10000e+9")).toString().equals("-9999999999930"), "sub018");
        harness.check(new BigDecimal("700").subtract(new BigDecimal("10000e+9")).toString().equals("-9999999999300"), "sub019");
        harness.check(new BigDecimal("7000").subtract(new BigDecimal("10000e+9")).toString().equals("-9999999993000"), "sub020");
        harness.check(new BigDecimal("70000").subtract(new BigDecimal("10000e+9")).toString().equals("-9999999930000"), "sub021");
        harness.check(new BigDecimal("700000").subtract(new BigDecimal("10000e+9")).toString().equals("-9999999300000"), "sub022");
        harness.check(new BigDecimal("10000e+9").subtract(new BigDecimal("70")).toString().equals("9999999999930"), "sub023");
        harness.check(new BigDecimal("10000e+9").subtract(new BigDecimal("700")).toString().equals("9999999999300"), "sub024");
        harness.check(new BigDecimal("10000e+9").subtract(new BigDecimal("7000")).toString().equals("9999999993000"), "sub025");
        harness.check(new BigDecimal("10000e+9").subtract(new BigDecimal("70000")).toString().equals("9999999930000"), "sub026");
        harness.check(new BigDecimal("10000e+9").subtract(new BigDecimal("700000")).toString().equals("9999999300000"), "sub027");
        harness.check(new BigDecimal("00.0").subtract(new BigDecimal("0.0")).toString().equals("0.0"), "sub040");
        harness.check(new BigDecimal("00.0").subtract(new BigDecimal("0.00")).toString().equals("0.00"), "sub041");
        harness.check(new BigDecimal("0.00").subtract(new BigDecimal("00.0")).toString().equals("0.00"), "sub042");
        harness.check(new BigDecimal("3").subtract(new BigDecimal(".3")).toString().equals("2.7"), "sub052");
        harness.check(new BigDecimal("3.").subtract(new BigDecimal(".3")).toString().equals("2.7"), "sub053");
        harness.check(new BigDecimal("3.0").subtract(new BigDecimal(".3")).toString().equals("2.7"), "sub054");
        harness.check(new BigDecimal("3.00").subtract(new BigDecimal(".3")).toString().equals("2.70"), "sub055");
        harness.check(new BigDecimal("3").subtract(new BigDecimal("3")).toString().equals("0"), "sub056");
        harness.check(new BigDecimal("3").subtract(new BigDecimal("+3")).toString().equals("0"), "sub057");
        harness.check(new BigDecimal("3").subtract(new BigDecimal("-3")).toString().equals("6"), "sub058");
        BigDecimal alhs = new BigDecimal("12345678900000");
        BigDecimal arhs = new BigDecimal("9999999999999");
        harness.check(alhs.subtract(arhs).toString().equals("2345678900001"), "sub112");
        harness.check(arhs.subtract(alhs).toString().equals("-2345678900001"), "sub113");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".1")).toString().equals("-0.1"), "sub120");
        harness.check(new BigDecimal("00").subtract(new BigDecimal(".97983")).toString().equals("-0.97983"), "sub121");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".9")).toString().equals("-0.9"), "sub122");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("0.102")).toString().equals("-0.102"), "sub123");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".4")).toString().equals("-0.4"), "sub124");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".307")).toString().equals("-0.307"), "sub125");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".43822")).toString().equals("-0.43822"), "sub126");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".911")).toString().equals("-0.911"), "sub127");
        harness.check(new BigDecimal(".0").subtract(new BigDecimal(".02")).toString().equals("-0.02"), "sub128");
        harness.check(new BigDecimal("00").subtract(new BigDecimal(".392")).toString().equals("-0.392"), "sub129");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".26")).toString().equals("-0.26"), "sub130");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("0.51")).toString().equals("-0.51"), "sub131");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".2234")).toString().equals("-0.2234"), "sub132");
        harness.check(new BigDecimal("0").subtract(new BigDecimal(".2")).toString().equals("-0.2"), "sub133");
        harness.check(new BigDecimal(".0").subtract(new BigDecimal(".0008")).toString().equals("-0.0008"), "sub134");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.1")).toString().equals("0.1"), "sub140");
        harness.check(new BigDecimal("0.00").subtract(new BigDecimal("-.97983")).toString().equals("0.97983"), "sub141");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.9")).toString().equals("0.9"), "sub142");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-0.102")).toString().equals("0.102"), "sub143");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.4")).toString().equals("0.4"), "sub144");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.307")).toString().equals("0.307"), "sub145");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.43822")).toString().equals("0.43822"), "sub146");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.911")).toString().equals("0.911"), "sub147");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.02")).toString().equals("0.02"), "sub148");
        harness.check(new BigDecimal("0.00").subtract(new BigDecimal("-.392")).toString().equals("0.392"), "sub149");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.26")).toString().equals("0.26"), "sub150");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-0.51")).toString().equals("0.51"), "sub151");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.2234")).toString().equals("0.2234"), "sub152");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.2")).toString().equals("0.2"), "sub153");
        harness.check(new BigDecimal("0.0").subtract(new BigDecimal("-.0008")).toString().equals("0.0008"), "sub154");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.1")).toString().equals("0.1"), "sub160");
        harness.check(new BigDecimal("00").subtract(new BigDecimal("-.97983")).toString().equals("0.97983"), "sub161");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.9")).toString().equals("0.9"), "sub162");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-0.102")).toString().equals("0.102"), "sub163");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.4")).toString().equals("0.4"), "sub164");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.307")).toString().equals("0.307"), "sub165");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.43822")).toString().equals("0.43822"), "sub166");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.911")).toString().equals("0.911"), "sub167");
        harness.check(new BigDecimal(".0").subtract(new BigDecimal("-.02")).toString().equals("0.02"), "sub168");
        harness.check(new BigDecimal("00").subtract(new BigDecimal("-.392")).toString().equals("0.392"), "sub169");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.26")).toString().equals("0.26"), "sub170");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-0.51")).toString().equals("0.51"), "sub171");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.2234")).toString().equals("0.2234"), "sub172");
        harness.check(new BigDecimal("0").subtract(new BigDecimal("-.2")).toString().equals("0.2"), "sub173");
        harness.check(new BigDecimal(".0").subtract(new BigDecimal("-.0008")).toString().equals("0.0008"), "sub174");
        harness.check(new BigDecimal("-56267E-10").subtract(zero).toString().equals("-0.0000056267"), "sub180");
        harness.check(new BigDecimal("-56267E-5").subtract(zero).toString().equals("-0.56267"), "sub181");
        harness.check(new BigDecimal("-56267E-2").subtract(zero).toString().equals("-562.67"), "sub182");
        harness.check(new BigDecimal("-56267E-1").subtract(zero).toString().equals("-5626.7"), "sub183");
        harness.check(new BigDecimal("-56267E-0").subtract(zero).toString().equals("-56267"), "sub185");
        try {
            ten.subtract(null);
            flag = false;
        }
        catch (NullPointerException xx83) {
            flag = true;
        }
        harness.check(flag, "sub200");
    }

    public void diagbyteValue(TestHarness harness) {
        boolean flag = false;
        Object v = null;
        Object ae = null;
        boolean i = false;
        Object norm = null;
        harness.check(-128 == new BigDecimal("-128").byteValue(), "byv001");
        harness.check(0 == new BigDecimal("0").byteValue(), "byv002");
        harness.check(1 == new BigDecimal("1").byteValue(), "byv003");
        harness.check(99 == new BigDecimal("99").byteValue(), "byv004");
        harness.check(127 == new BigDecimal("127").byteValue(), "byv005");
        harness.check(-128 == new BigDecimal("128").byteValue(), "byv006");
        harness.check(-127 == new BigDecimal("129").byteValue(), "byv007");
        harness.check(127 == new BigDecimal("-129").byteValue(), "byv008");
        harness.check(126 == new BigDecimal("-130").byteValue(), "byv009");
        harness.check(127 == new BigDecimal(127).byteValue(), "byv010");
        harness.check(-128 == new BigDecimal(-128).byteValue(), "byv011");
        harness.check(-1 == new BigDecimal(-1).byteValue(), "byv012");
        harness.check(0 == new BigDecimal(0).byteValue(), "byv013");
        harness.check(1 == new BigDecimal(1).byteValue(), "byv014");
        harness.check(-128 == new BigDecimal(128).byteValue(), "byv015");
        harness.check(127 == new BigDecimal(-129).byteValue(), "byv016");
        String[] badstrings = new String[]{"1234", new BigDecimal(127).add(one).toString(), new BigDecimal(-128).subtract(one).toString(), "170", "270", "370", "470", "570", "670", "770", "870", "970", "-170", "-270", "-370", "-470", "-570", "-670", "-770", "-870", "-970", new BigDecimal(-128).multiply(two).toString(), new BigDecimal(127).multiply(two).toString(), new BigDecimal(-128).multiply(ten).toString(), new BigDecimal(127).multiply(ten).toString(), "-1234"};
    }

    public void diagcomparetoObj(TestHarness harness) {
        boolean flag = false;
        BigDecimal d = new BigDecimal(17);
        harness.check(d.compareTo(new BigDecimal(66)) == -1, "cto001");
        harness.check(d.compareTo(new BigDecimal(10).add(new BigDecimal(7))) == 0, "cto002");
        harness.check(d.compareTo(new BigDecimal(10)) == 1, "cto003");
        BigDecimal long1 = new BigDecimal("12345678903");
        BigDecimal long2 = new BigDecimal("12345678900");
        harness.check(long1.compareTo(long2) == 1, "cto004");
        harness.check(long2.compareTo(long1) == -1, "cto005");
        harness.check(long2.compareTo(long2) == 0, "cto006");
        try {
            d.compareTo(null);
            flag = false;
        }
        catch (NullPointerException xx92) {
            flag = true;
        }
        harness.check(flag, "cto101");
        try {
            d.compareTo("foo");
            flag = false;
        }
        catch (ClassCastException xx93) {
            flag = true;
        }
        harness.check(flag, "cto102");
    }

    public void diagdoublevalue(TestHarness harness) {
        String val = "-1";
        harness.check(new BigDecimal(val).doubleValue() == new Double(val).doubleValue(), "dov001");
        val = "-0.1";
        harness.check(new BigDecimal(val).doubleValue() == new Double(val).doubleValue(), "dov002");
        val = "0";
        harness.check(new BigDecimal(val).doubleValue() == new Double(val).doubleValue(), "dov003");
        val = "0.1";
        harness.check(new BigDecimal(val).doubleValue() == new Double(val).doubleValue(), "dov004");
        val = "1";
        harness.check(new BigDecimal(val).doubleValue() == new Double(val).doubleValue(), "dov005");
        val = "1e1000";
        harness.check(new BigDecimal(val).doubleValue() == Double.POSITIVE_INFINITY, "dov006");
        val = "-1e1000";
        harness.check(new BigDecimal(val).doubleValue() == Double.NEGATIVE_INFINITY, "dov007");
    }

    public void diagequals(TestHarness harness) {
        BigDecimal d = new BigDecimal(17);
        harness.check(!d.equals(null), "equ001");
        harness.check(!d.equals("foo"), "equ002");
        harness.check(!d.equals(new BigDecimal(66)), "equ003");
        harness.check(d.equals(d), "equ004");
        harness.check(d.equals(new BigDecimal(10).add(new BigDecimal(7))), "equ005");
    }

    public void diagfloatvalue(TestHarness harness) {
        String val = "-1";
        harness.check(new BigDecimal(val).floatValue() == new Float(val).floatValue(), "flv001");
        val = "-0.1";
        harness.check(new BigDecimal(val).floatValue() == new Float(val).floatValue(), "flv002");
        val = "0";
        harness.check(new BigDecimal(val).floatValue() == new Float(val).floatValue(), "flv003");
        val = "0.1";
        harness.check(new BigDecimal(val).floatValue() == new Float(val).floatValue(), "flv004");
        val = "1";
        harness.check(new BigDecimal(val).floatValue() == new Float(val).floatValue(), "flv005");
        val = "1e200";
        harness.check(new BigDecimal(val).floatValue() == Float.POSITIVE_INFINITY, "flv006");
        val = "-1e200";
        harness.check(new BigDecimal(val).floatValue() == Float.NEGATIVE_INFINITY, "flv007");
        val = "1e1000";
        harness.check(new BigDecimal(val).floatValue() == Float.POSITIVE_INFINITY, "flv008");
        val = "-1e1000";
        harness.check(new BigDecimal(val).floatValue() == Float.NEGATIVE_INFINITY, "flv009");
    }

    public void diaghashcode(TestHarness harness) {
    }

    public void diagintvalue(TestHarness harness) {
        boolean flag = false;
        Object v = null;
        Object ae = null;
        boolean i = false;
        Object norm = null;
        Object num = null;
        Object dv = null;
        harness.check(Integer.MIN_VALUE == new BigDecimal(Integer.MIN_VALUE).intValue(), "inv001");
        harness.check(99 == new BigDecimal("99").intValue(), "inv002");
        harness.check(1 == new BigDecimal("1").intValue(), "inv003");
        harness.check(0 == new BigDecimal("0").intValue(), "inv004");
        harness.check(-1 == new BigDecimal("-1").intValue(), "inv005");
        harness.check(-99 == new BigDecimal("-99").intValue(), "inv006");
        harness.check(Integer.MAX_VALUE == new BigDecimal(Integer.MAX_VALUE).intValue(), "inv007");
        harness.check(5 == new BigDecimal("5.0").intValue(), "inv008");
        harness.check(5 == new BigDecimal("5.3").intValue(), "inv009");
        harness.check(5 == new BigDecimal("5.5").intValue(), "inv010");
        harness.check(5 == new BigDecimal("5.7").intValue(), "inv011");
        harness.check(5 == new BigDecimal("5.9").intValue(), "inv012");
        harness.check(-5 == new BigDecimal("-5.0").intValue(), "inv013");
        harness.check(-5 == new BigDecimal("-5.3").intValue(), "inv014");
        harness.check(-5 == new BigDecimal("-5.5").intValue(), "inv015");
        harness.check(-5 == new BigDecimal("-5.7").intValue(), "inv016");
        harness.check(-5 == new BigDecimal("-5.9").intValue(), "inv017");
        harness.check(new BigDecimal("88888888888").intValue() == -1305424328, "inv018");
        harness.check(new BigDecimal("-88888888888").intValue() == 1305424328, "inv019");
        harness.check(Integer.MIN_VALUE == new BigDecimal(0x80000000L).intValue(), "inv020");
        harness.check(Integer.MAX_VALUE == new BigDecimal(-2147483649L).intValue(), "inv021");
        harness.check(99 == new BigDecimal("99").intValue(), "inv102");
        harness.check(1 == new BigDecimal("1").intValue(), "inv103");
        harness.check(0 == new BigDecimal("0").intValue(), "inv104");
        harness.check(-1 == new BigDecimal("-1").intValue(), "inv105");
        harness.check(-99 == new BigDecimal("-99").intValue(), "inv106");
        harness.check(Integer.MAX_VALUE == new BigDecimal(Integer.MAX_VALUE).intValue(), "inv107");
        harness.check(5 == new BigDecimal("5.0").intValue(), "inv108");
        harness.check(-5 == new BigDecimal("-5.0").intValue(), "inv109");
    }

    public void diaglongvalue(TestHarness harness) {
        boolean flag = false;
        Object v = null;
        Object ae = null;
        boolean i = false;
        Object norm = null;
        Object num = null;
        Object dv = null;
        harness.check(Long.MIN_VALUE == new BigDecimal(Long.MIN_VALUE).longValue(), "lov001");
        harness.check(Long.MIN_VALUE == new BigDecimal(lminString).longValue(), "lov001a");
        harness.check(99L == new BigDecimal("99").longValue(), "lov002");
        harness.check(1L == new BigDecimal("1").longValue(), "lov003");
        harness.check(0L == new BigDecimal("0").longValue(), "lov004");
        harness.check(-1L == new BigDecimal("-1").longValue(), "lov005");
        harness.check(-99L == new BigDecimal("-99").longValue(), "lov006");
        harness.check(Long.MAX_VALUE == new BigDecimal(lmaxString).longValue(), "lov007a");
        harness.check(5L == new BigDecimal("5.0").longValue(), "lov008");
        harness.check(5L == new BigDecimal("5.3").longValue(), "lov009");
        harness.check(5L == new BigDecimal("5.5").longValue(), "lov010");
        harness.check(5L == new BigDecimal("5.7").longValue(), "lov011");
        harness.check(5L == new BigDecimal("5.9").longValue(), "lov012");
        harness.check(-5L == new BigDecimal("-5.0").longValue(), "lov013");
        harness.check(-5L == new BigDecimal("-5.3").longValue(), "lov014");
        harness.check(-5L == new BigDecimal("-5.5").longValue(), "lov015");
        harness.check(-5L == new BigDecimal("-5.7").longValue(), "lov016");
        harness.check(-5L == new BigDecimal("-5.9").longValue(), "lov017");
        harness.check(new BigDecimal("888888888899999999998").longValue() == 3445173361941522430L, "lov018");
        harness.check(new BigDecimal("-888888888899999999998").longValue() == -3445173361941522430L, "lov019");
        harness.check(Long.MIN_VALUE == new BigDecimal(lminString).longValue(), "lov101");
        harness.check(99L == new BigDecimal("99").longValue(), "lov102");
        harness.check(1L == new BigDecimal("1").longValue(), "lov103");
        harness.check(0L == new BigDecimal("0").longValue(), "lov104");
        harness.check(-1L == new BigDecimal("-1").longValue(), "lov105");
        harness.check(-99L == new BigDecimal("-99").longValue(), "lov106");
        harness.check(Long.MAX_VALUE == new BigDecimal(lmaxString).longValue(), "lov107a");
        harness.check(5L == new BigDecimal("5.0").longValue(), "lov108");
        harness.check(-5L == new BigDecimal("-5.0").longValue(), "lov109");
    }

    public void diagmovepointleft(TestHarness harness) {
        harness.check(new BigDecimal("-1").movePointLeft(-10).toString().equals("-10000000000"), "mpl001");
        harness.check(new BigDecimal("-1").movePointLeft(-5).toString().equals("-100000"), "mpl002");
        harness.check(new BigDecimal("-1").movePointLeft(-1).toString().equals("-10"), "mpl003");
        harness.check(new BigDecimal("-1").movePointLeft(0).toString().equals("-1"), "mpl004");
        harness.check(new BigDecimal("-1").movePointLeft(1).toString().equals("-0.1"), "mpl005");
        harness.check(new BigDecimal("-1").movePointLeft(5).toString().equals("-0.00001"), "mpl006");
        harness.check(new BigDecimal("-1").movePointLeft(10).toString().equals("-1E-10"), "mpl007");
        harness.check(new BigDecimal("0").movePointLeft(-10).toString().equals("0"), "mpl010");
        harness.check(new BigDecimal("0").movePointLeft(-5).toString().equals("0"), "mpl010");
        harness.check(new BigDecimal("0").movePointLeft(-1).toString().equals("0"), "mpl010");
        harness.check(new BigDecimal("0").movePointLeft(0).toString().equals("0"), "mpl010");
        harness.check(new BigDecimal("0").movePointLeft(1).toString().equals("0.0"), "mpl010");
        harness.check(new BigDecimal("0").movePointLeft(5).toString().equals("0.00000"), "mpl010");
        harness.check(new BigDecimal("0").movePointLeft(10).toString().equals("0E-10"), "mpl010");
        harness.check(new BigDecimal("+1").movePointLeft(-10).toString().equals("10000000000"), "mpl020");
        harness.check(new BigDecimal("+1").movePointLeft(-5).toString().equals("100000"), "mpl021");
        harness.check(new BigDecimal("+1").movePointLeft(-1).toString().equals("10"), "mpl022");
        harness.check(new BigDecimal("+1").movePointLeft(0).toString().equals("1"), "mpl023");
        harness.check(new BigDecimal("+1").movePointLeft(1).toString().equals("0.1"), "mpl024");
        harness.check(new BigDecimal("+1").movePointLeft(5).toString().equals("0.00001"), "mpl025");
        harness.check(new BigDecimal("+1").movePointLeft(10).toString().equals("1E-10"), "mpl026");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(-10).toString().equals("50000000000"), "mpl030");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(-5).toString().equals("500000"), "mpl031");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(-1).toString().equals("50"), "mpl032");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(0).toString().equals("5"), "mpl033");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(1).toString().equals("0.5"), "mpl034");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(5).toString().equals("0.00005"), "mpl035");
        harness.check(new BigDecimal("0.5E+1").movePointLeft(10).toString().equals("5E-10"), "mpl036");
    }

    public void diagmovepointright(TestHarness harness) {
        harness.check(new BigDecimal("-1").movePointRight(10).toString().equals("-10000000000"), "mpr001");
        harness.check(new BigDecimal("-1").movePointRight(5).toString().equals("-100000"), "mpr002");
        harness.check(new BigDecimal("-1").movePointRight(1).toString().equals("-10"), "mpr003");
        harness.check(new BigDecimal("-1").movePointRight(0).toString().equals("-1"), "mpr004");
        harness.check(new BigDecimal("-1").movePointRight(-1).toString().equals("-0.1"), "mpr005");
        harness.check(new BigDecimal("-1").movePointRight(-5).toString().equals("-0.00001"), "mpr006");
        harness.check(new BigDecimal("-1").movePointRight(-10).toString().equals("-1E-10"), "mpr007");
        harness.check(new BigDecimal("0").movePointRight(10).toString().equals("0"), "mpr010");
        harness.check(new BigDecimal("0").movePointRight(5).toString().equals("0"), "mpr011");
        harness.check(new BigDecimal("0").movePointRight(1).toString().equals("0"), "mpr012");
        harness.check(new BigDecimal("0").movePointRight(0).toString().equals("0"), "mpr013");
        harness.check(new BigDecimal("0").movePointRight(-1).toString().equals("0.0"), "mpr014");
        harness.check(new BigDecimal("0").movePointRight(-5).toString().equals("0.00000"), "mpr015");
        harness.check(new BigDecimal("0").movePointRight(-10).toString().equals("0E-10"), "mpr016");
        harness.check(new BigDecimal("+1").movePointRight(10).toString().equals("10000000000"), "mpr020");
        harness.check(new BigDecimal("+1").movePointRight(5).toString().equals("100000"), "mpr021");
        harness.check(new BigDecimal("+1").movePointRight(1).toString().equals("10"), "mpr022");
        harness.check(new BigDecimal("+1").movePointRight(0).toString().equals("1"), "mpr023");
        harness.check(new BigDecimal("+1").movePointRight(-1).toString().equals("0.1"), "mpr024");
        harness.check(new BigDecimal("+1").movePointRight(-5).toString().equals("0.00001"), "mpr025");
        harness.check(new BigDecimal("+1").movePointRight(-10).toString().equals("1E-10"), "mpr026");
        harness.check(new BigDecimal("0.5E+1").movePointRight(10).toString().equals("50000000000"), "mpr030");
        harness.check(new BigDecimal("0.5E+1").movePointRight(5).toString().equals("500000"), "mpr031");
        harness.check(new BigDecimal("0.5E+1").movePointRight(1).toString().equals("50"), "mpr032");
        harness.check(new BigDecimal("0.5E+1").movePointRight(0).toString().equals("5"), "mpr033");
        harness.check(new BigDecimal("0.5E+1").movePointRight(-1).toString().equals("0.5"), "mpr034");
        harness.check(new BigDecimal("0.5E+1").movePointRight(-5).toString().equals("0.00005"), "mpr035");
        harness.check(new BigDecimal("0.5E+1").movePointRight(-10).toString().equals("5E-10"), "mpr036");
    }

    public void diagscale(TestHarness harness) {
        harness.check(new BigDecimal("-1").scale() == 0, "sca001");
        harness.check(new BigDecimal("-10").scale() == 0, "sca002");
        harness.check(new BigDecimal("+1").scale() == 0, "sca003");
        harness.check(new BigDecimal("+10").scale() == 0, "sca004");
        harness.check(new BigDecimal("1E+10").scale() == -10, "sca005");
        harness.check(new BigDecimal("1E-10").scale() == 10, "sca006");
        harness.check(new BigDecimal("0E-10").scale() == 10, "sca007");
        harness.check(new BigDecimal("0.000").scale() == 3, "sca008");
        harness.check(new BigDecimal("0.00").scale() == 2, "sca009");
        harness.check(new BigDecimal("0.0").scale() == 1, "sca010");
        harness.check(new BigDecimal("0.1").scale() == 1, "sca011");
        harness.check(new BigDecimal("0.12").scale() == 2, "sca012");
        harness.check(new BigDecimal("0.123").scale() == 3, "sca013");
        harness.check(new BigDecimal("-0.0").scale() == 1, "sca014");
        harness.check(new BigDecimal("-0.1").scale() == 1, "sca015");
        harness.check(new BigDecimal("-0.12").scale() == 2, "sca016");
        harness.check(new BigDecimal("-0.123").scale() == 3, "sca017");
    }

    public void diagsetscale(TestHarness harness) {
        boolean flag = false;
        ArithmeticException e = null;
        harness.check(new BigDecimal("-1").setScale(0).toString().equals("-1"), "ssc001");
        harness.check(new BigDecimal("-1").setScale(1).toString().equals("-1.0"), "ssc002");
        harness.check(new BigDecimal("-1").setScale(2).toString().equals("-1.00"), "ssc003");
        harness.check(new BigDecimal("0").setScale(0).toString().equals("0"), "ssc004");
        harness.check(new BigDecimal("0").setScale(1).toString().equals("0.0"), "ssc005");
        harness.check(new BigDecimal("0").setScale(2).toString().equals("0.00"), "ssc006");
        harness.check(new BigDecimal("+1").setScale(0).toString().equals("1"), "ssc007");
        harness.check(new BigDecimal("+1").setScale(1).toString().equals("1.0"), "ssc008");
        harness.check(new BigDecimal("+1").setScale(2).toString().equals("1.00"), "ssc009");
        try {
            new BigDecimal(1).setScale(-8);
            flag = false;
        }
        catch (ArithmeticException xx117) {
            e = xx117;
            flag = this.checkMessage(e, "Negative scale: -8");
        }
        harness.check(flag, "ssc100");
        try {
            new BigDecimal(1.0001).setScale(3);
            flag = false;
        }
        catch (ArithmeticException xx118) {
            e = xx118;
            flag = this.checkMessage(e, "Rounding necessary");
        }
        harness.check(flag, "ssc101");
        try {
            new BigDecimal(1.0E-8).setScale(3);
            flag = false;
        }
        catch (ArithmeticException xx119) {
            e = xx119;
            flag = this.checkMessage(e, "Rounding necessary");
        }
        harness.check(flag, "ssc102");
    }

    public void diagshortvalue(TestHarness harness) {
        boolean flag = false;
        Object v = null;
        Object ae = null;
        boolean i = false;
        Object norm = null;
        harness.check(0 == new BigDecimal("0").shortValue(), "shv002");
        harness.check(1 == new BigDecimal("1").shortValue(), "shv003");
        harness.check(99 == new BigDecimal("99").shortValue(), "shv004");
        harness.check(Short.MAX_VALUE == new BigDecimal(Short.MAX_VALUE).shortValue(), "shv006");
        harness.check(Short.MIN_VALUE == new BigDecimal(Short.MIN_VALUE).shortValue(), "shv007");
        harness.check(-1 == new BigDecimal(-1).shortValue(), "shv008");
        harness.check(0 == new BigDecimal(0).shortValue(), "shv009");
        harness.check(1 == new BigDecimal(1).shortValue(), "shv010");
        harness.check(Short.MIN_VALUE == new BigDecimal(32768).shortValue(), "shv011");
        harness.check(Short.MAX_VALUE == new BigDecimal(-32769).shortValue(), "shv012");
    }

    public void diagsignum(TestHarness harness) {
        harness.check(-1 == new BigDecimal("-1").signum(), "sig001");
        harness.check(-1 == new BigDecimal("-0.0010").signum(), "sig002");
        harness.check(-1 == new BigDecimal("-0.001").signum(), "sig003");
        harness.check(0 == new BigDecimal("-0.00").signum(), "sig004");
        harness.check(0 == new BigDecimal("-0").signum(), "sig005");
        harness.check(0 == new BigDecimal("0").signum(), "sig006");
        harness.check(0 == new BigDecimal("00").signum(), "sig007");
        harness.check(0 == new BigDecimal("00.0").signum(), "sig008");
        harness.check(1 == new BigDecimal("00.01").signum(), "sig009");
        harness.check(1 == new BigDecimal("00.01").signum(), "sig010");
        harness.check(1 == new BigDecimal("00.010").signum(), "sig011");
        harness.check(1 == new BigDecimal("01.01").signum(), "sig012");
        harness.check(1 == new BigDecimal("+0.01").signum(), "sig013");
        harness.check(1 == new BigDecimal("+0.001").signum(), "sig014");
        harness.check(1 == new BigDecimal("1").signum(), "sig015");
        harness.check(1 == new BigDecimal("1e+12").signum(), "sig016");
        harness.check(0 == new BigDecimal("00e+12").signum(), "sig017");
    }

    public void diagtobiginteger(TestHarness harness) {
        boolean flag = false;
        boolean i = false;
        harness.check(new BigDecimal("-1").toBigInteger().toString().equals("-1"), "tbi001");
        harness.check(new BigDecimal("0").toBigInteger().toString().equals("0"), "tbi002");
        harness.check(new BigDecimal("+1").toBigInteger().toString().equals("1"), "tbi003");
        harness.check(new BigDecimal("10").toBigInteger().toString().equals("10"), "tbi004");
        harness.check(new BigDecimal("1000").toBigInteger().toString().equals("1000"), "tbi005");
        harness.check(new BigDecimal("-1E+0").toBigInteger().toString().equals("-1"), "tbi006");
        harness.check(new BigDecimal("0E+0").toBigInteger().toString().equals("0"), "tbi007");
        harness.check(new BigDecimal("+1E+0").toBigInteger().toString().equals("1"), "tbi008");
        harness.check(new BigDecimal("10E+0").toBigInteger().toString().equals("10"), "tbi009");
        harness.check(new BigDecimal("1E+3").toBigInteger().toString().equals("1000"), "tbi010");
        harness.check(new BigDecimal("0.00").toBigInteger().toString().equals("0"), "tbi011");
        harness.check(new BigDecimal("0.01").toBigInteger().toString().equals("0"), "tbi012");
        harness.check(new BigDecimal("0.0").toBigInteger().toString().equals("0"), "tbi013");
        harness.check(new BigDecimal("0.1").toBigInteger().toString().equals("0"), "tbi014");
        harness.check(new BigDecimal("-0.00").toBigInteger().toString().equals("0"), "tbi015");
        harness.check(new BigDecimal("-0.01").toBigInteger().toString().equals("0"), "tbi016");
        harness.check(new BigDecimal("-0.0").toBigInteger().toString().equals("0"), "tbi017");
        harness.check(new BigDecimal("-0.1").toBigInteger().toString().equals("0"), "tbi018");
        harness.check(new BigDecimal("1.00").toBigInteger().toString().equals("1"), "tbi019");
        harness.check(new BigDecimal("1.01").toBigInteger().toString().equals("1"), "tbi020");
        harness.check(new BigDecimal("1.0").toBigInteger().toString().equals("1"), "tbi021");
        harness.check(new BigDecimal("1.1").toBigInteger().toString().equals("1"), "tbi022");
        harness.check(new BigDecimal("-1.00").toBigInteger().toString().equals("-1"), "tbi023");
        harness.check(new BigDecimal("-1.01").toBigInteger().toString().equals("-1"), "tbi024");
        harness.check(new BigDecimal("-1.0").toBigInteger().toString().equals("-1"), "tbi025");
        harness.check(new BigDecimal("-1.1").toBigInteger().toString().equals("-1"), "tbi026");
        harness.check(new BigDecimal("-111.111").toBigInteger().toString().equals("-111"), "tbi027");
        harness.check(new BigDecimal("+111.111").toBigInteger().toString().equals("111"), "tbi028");
        harness.check(new BigDecimal("0.09").toBigInteger().toString().equals("0"), "tbi029");
        harness.check(new BigDecimal("0.9").toBigInteger().toString().equals("0"), "tbi030");
        harness.check(new BigDecimal("1.09").toBigInteger().toString().equals("1"), "tbi031");
        harness.check(new BigDecimal("1.05").toBigInteger().toString().equals("1"), "tbi032");
        harness.check(new BigDecimal("1.04").toBigInteger().toString().equals("1"), "tbi033");
        harness.check(new BigDecimal("1.99").toBigInteger().toString().equals("1"), "tbi034");
        harness.check(new BigDecimal("1.9").toBigInteger().toString().equals("1"), "tbi034");
        harness.check(new BigDecimal("1.5").toBigInteger().toString().equals("1"), "tbi035");
        harness.check(new BigDecimal("1.4").toBigInteger().toString().equals("1"), "tbi036");
        harness.check(new BigDecimal("-1.09").toBigInteger().toString().equals("-1"), "tbi037");
        harness.check(new BigDecimal("-1.05").toBigInteger().toString().equals("-1"), "tbi038");
        harness.check(new BigDecimal("-1.04").toBigInteger().toString().equals("-1"), "tbi039");
        harness.check(new BigDecimal("-1.99").toBigInteger().toString().equals("-1"), "tbi040");
        harness.check(new BigDecimal("-1.9").toBigInteger().toString().equals("-1"), "tbi041");
        harness.check(new BigDecimal("-1.5").toBigInteger().toString().equals("-1"), "tbi042");
        harness.check(new BigDecimal("-1.4").toBigInteger().toString().equals("-1"), "tbi043");
        harness.check(new BigDecimal("1E-1000").toBigInteger().toString().equals("0"), "tbi044");
        harness.check(new BigDecimal("-1E-1000").toBigInteger().toString().equals("0"), "tbi045");
    }

    public void diagtostring(TestHarness harness) {
        String str = "123.45";
        BigDecimal d = new BigDecimal(str);
        String cs = d.toString();
        harness.check(str.length() == cs.length(), "tos002");
        harness.check(str.equals(cs), "tos004");
        harness.check(cs instanceof String, "tos005");
        harness.check(d.toString() instanceof String, "tos006");
    }

    public void diagvalueof(TestHarness harness) {
        boolean flag = false;
        Object e = null;
        harness.check(BigDecimal.valueOf(-2L).toString().equals("-2"), "val001");
        harness.check(BigDecimal.valueOf(-1L).toString().equals("-1"), "val002");
        harness.check(BigDecimal.valueOf(0L).toString().equals("0"), "val003");
        harness.check(BigDecimal.valueOf(1L).toString().equals("1"), "val004");
        harness.check(BigDecimal.valueOf(2L).toString().equals("2"), "val005");
        harness.check(BigDecimal.valueOf(10L).toString().equals("10"), "val006");
        harness.check(BigDecimal.valueOf(11L).toString().equals("11"), "val007");
        harness.check(BigDecimal.valueOf(Long.MIN_VALUE).toString().equals(lminString), "val008");
        harness.check(BigDecimal.valueOf(Long.MAX_VALUE).toString().equals(lmaxString), "val009");
        harness.check(BigDecimal.valueOf(-1L).toString().equals("-1"), "val010");
        harness.check(BigDecimal.valueOf(0L).toString().equals("0"), "val011");
        harness.check(BigDecimal.valueOf(1L).toString().equals("1"), "val012");
        harness.check(BigDecimal.valueOf(Long.MIN_VALUE, 0).toString().equals(lminString), "val013");
        harness.check(BigDecimal.valueOf(Long.MAX_VALUE, 0).toString().equals(lmaxString), "val014");
        harness.check(BigDecimal.valueOf(-1L, 0).toString().equals("-1"), "val015");
        harness.check(BigDecimal.valueOf(1L, 0).toString().equals("1"), "val016");
        harness.check(BigDecimal.valueOf(0L, 0).toString().equals("0"), "val017");
        harness.check(BigDecimal.valueOf(0L, 1).toString().equals("0.0"), "val018");
        harness.check(BigDecimal.valueOf(0L, 2).toString().equals("0.00"), "val019");
        harness.check(BigDecimal.valueOf(0L, 3).toString().equals("0.000"), "val020");
        harness.check(BigDecimal.valueOf(0L, 10).toString().equals("0E-10"), "val021");
        harness.check(BigDecimal.valueOf(Long.MIN_VALUE, 7).toString().equals("-922337203685.4775808"), "val022");
        harness.check(BigDecimal.valueOf(Long.MAX_VALUE, 11).toString().equals("92233720.36854775807"), "val023");
    }

    private static String right(String s, int len) {
        int slen = s.length();
        if (slen == len) {
            return s;
        }
        if (slen > len) {
            return s.substring(slen - len);
        }
        return new String(new char[len - slen]).replace('\u0000', ' ').concat(s);
    }

    private static String left(String s, int len) {
        int slen = s.length();
        if (slen == len) {
            return s;
        }
        if (slen > len) {
            return s.substring(0, len);
        }
        return s.concat(new String(new char[len - slen]).replace('\u0000', ' '));
    }

    private void say(TestHarness harness) {
        this.say(null, harness);
    }

    private void say(String s, TestHarness harness) {
        if (s == null) {
            s = "  ";
        }
        harness.verbose(s);
    }

    private boolean checkMessage(Throwable ex, String msg) {
        return true;
    }

    @Override
    public void test(TestHarness harness) {
        this.diagrun(harness);
    }
}

