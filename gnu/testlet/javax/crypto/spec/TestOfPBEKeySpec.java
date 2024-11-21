/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.crypto.spec;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.crypto.spec.PBEKeySpec;

public class TestOfPBEKeySpec
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructorP(harness);
        this.testConstructorPSI(harness);
        this.testConstructorPSIK(harness);
        this.testPassword(harness);
        this.testSalt(harness);
        this.testIterationCount(harness);
        this.testKeyLength(harness);
    }

    private void testConstructorP(TestHarness harness) {
        PBEKeySpec pbeKeySpec;
        char[] password = "HelloWorld".toCharArray();
        try {
            pbeKeySpec = new PBEKeySpec(password);
            harness.check(pbeKeySpec.getSalt() == null, "salt MUST have a default value of null");
            harness.check(pbeKeySpec.getIterationCount() == 0, "iterationCount MUST have a default value of 0");
            harness.check(pbeKeySpec.getKeyLength() == 0, "keyLength MUST have a default value of 0");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("PBEKeySpec() with valid password failed: " + x);
        }
        try {
            pbeKeySpec = new PBEKeySpec(null);
            char[] pbePassword = pbeKeySpec.getPassword();
            harness.check(pbePassword.length == 0, "a null password MUST produce an empty char array");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
    }

    private void testConstructorPSI(TestHarness harness) {
        PBEKeySpec pbeKeySpec;
        char[] password = "HelloWorld".toCharArray();
        byte[] salt = new byte[]{0, 1, 1, 2, 3, 5, 8};
        int iterationCount = 102;
        try {
            pbeKeySpec = new PBEKeySpec(password, salt, iterationCount);
            harness.check(pbeKeySpec.getKeyLength() == 0, "keyLength MUST have a default value of 0");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("PBEKeySpec() with valid password, salt and iterationCount failed:" + x);
        }
        try {
            pbeKeySpec = new PBEKeySpec(null, salt, iterationCount);
            char[] pbePassword = pbeKeySpec.getPassword();
            harness.check(pbePassword.length == 0, "a null password MUST produce an empty char array");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
        String msg = "PBEKeySpec() MUST throw NullPointerException if salt is null";
        try {
            new PBEKeySpec(password, null, iterationCount);
            harness.fail(msg);
        }
        catch (NullPointerException npe) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
        msg = "PBEKeySpec() MUST throw IllegalArgumentException if salt is an empty array";
        try {
            byte[] emptySalt = new byte[]{};
            new PBEKeySpec(password, emptySalt, iterationCount);
            harness.fail(msg);
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
        msg = "PBEKeySpec() MUST throw IllegalArgumentException if iterationCount is negative";
        try {
            new PBEKeySpec(password, salt, -1);
            harness.fail(msg);
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
    }

    private void testConstructorPSIK(TestHarness harness) {
        char[] password = "HelloWorld".toCharArray();
        byte[] salt = new byte[]{0, 1, 1, 2, 3, 5, 8};
        int iterationCount = 102;
        int keyLength = 4;
        try {
            new PBEKeySpec(password, salt, iterationCount, keyLength);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("PBEKeySpec() with valid password, salt, iterationCount and keyLength failed: " + x);
        }
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(null, salt, iterationCount, keyLength);
            char[] pbePassword = pbeKeySpec.getPassword();
            harness.check(pbePassword.length == 0, "a null password MUST produce an empty char array");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("PBEKeySpec(password, salt, iterationcount, keyLength) with a null password failed: " + x);
        }
        String msg = "PBEKeySpec() MUST throw NullPointerException if salt is null";
        try {
            new PBEKeySpec(password, null, iterationCount, keyLength);
            harness.fail(msg);
        }
        catch (NullPointerException npe) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
        msg = "PBEKeySpec() MUST throw IllegalArgumentException if salt is an empty array";
        try {
            byte[] emptySalt = new byte[]{};
            new PBEKeySpec(password, emptySalt, iterationCount, keyLength);
            harness.fail(msg);
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
        msg = "PBEKeySpec() MUST throw IllegalArgumentException if iterationCount is negative";
        try {
            new PBEKeySpec(password, salt, -1, keyLength);
            harness.fail(msg);
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
        msg = "PBEKeySpec() MUST throw IllegalArgumentException if keyLength is negative";
        try {
            new PBEKeySpec(password, salt, iterationCount, -1);
            harness.fail(msg);
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(String.valueOf(x));
        }
    }

    private void testPassword(TestHarness harness) {
        char[] password = "HelloWorld".toCharArray();
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
            harness.check(Arrays.equals(pbeKeySpec.getPassword(), password), "Value returned from getPassword() MUST equal the actual password");
            char[] passwordCopy = pbeKeySpec.getPassword();
            for (int i = 0; i < passwordCopy.length; ++i) {
                passwordCopy[i] = 97;
            }
            char[] originalPassword = "HelloWorld".toCharArray();
            harness.check(Arrays.equals(password, originalPassword), "Changing the stored password changed the actual password. MUST store a COPY of the password");
            harness.check(Arrays.equals(pbeKeySpec.getPassword(), originalPassword), "Changing the value returned from getPassword() changed the stored password. MUST return a COPY of the password");
            pbeKeySpec.clearPassword();
            harness.check(Arrays.equals(password, "HelloWorld".toCharArray()), "clearPassword() cleared the actual password. MUST store a COPY of the password");
            String msg = "Calling getPassword() after clearPassword() MUST throw IllegalStateException";
            try {
                pbeKeySpec.getPassword();
                harness.fail(msg);
            }
            catch (IllegalStateException ise) {
                harness.check(true, msg);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("testPassword(): " + x);
        }
    }

    private void testSalt(TestHarness harness) {
        char[] password = "HelloWorld".toCharArray();
        byte[] salt = new byte[]{0, 1, 1, 2, 3, 5, 8};
        int iterationCount = 102;
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, iterationCount);
            harness.check(Arrays.equals(pbeKeySpec.getSalt(), salt), "Value returned from getSalt() MUST equal actual salt");
            byte[] saltCopy = pbeKeySpec.getSalt();
            for (int i = 0; i < saltCopy.length; ++i) {
                saltCopy[i] = (byte)i;
            }
            byte[] originalSalt = new byte[]{0, 1, 1, 2, 3, 5, 8};
            harness.check(Arrays.equals(salt, originalSalt), "Changing the stored salt changed the actual salt. MUST store a COPY of the salt");
            harness.check(Arrays.equals(pbeKeySpec.getSalt(), originalSalt), "Changing the value returned from getSalt() changed the stored salt. MUST return a COPY of the salt");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("testSalt(): " + x);
        }
    }

    private void testIterationCount(TestHarness harness) {
        char[] password = "HelloWorld".toCharArray();
        byte[] salt = new byte[]{0, 1, 1, 2, 3, 5, 8};
        int iterationCount = 102;
        String msg = "getIterationCount() MUST match iterationCount";
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, iterationCount);
            harness.check(pbeKeySpec.getIterationCount() == iterationCount, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("testIterationCount(): " + x);
        }
    }

    private void testKeyLength(TestHarness harness) {
        char[] password = "HelloWorld".toCharArray();
        byte[] salt = new byte[]{0, 1, 1, 2, 3, 5, 8};
        int iterationCount = 102;
        int keyLength = 4;
        String msg = "getKeyLength() MUST match keyLength";
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
            harness.check(pbeKeySpec.getKeyLength() == keyLength, msg);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("testKeyLength(): " + x);
        }
    }
}

