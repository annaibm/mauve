/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import java.security.Provider;
import java.security.Security;

public class PKITS {
    public static final String ANY_POLICY = "2.5.29.32.0";
    public static final String NIST_TEST_POLICY_1 = "2.16.840.1.101.3.2.1.48.1";
    public static final String NIST_TEST_POLICY_2 = "2.16.840.1.101.3.2.1.48.2";
    public static final String NIST_TEST_POLICY_3 = "2.16.840.1.101.3.2.1.48.3";
    public static final String NIST_TEST_POLICY_4 = "2.16.840.1.101.3.2.1.48.4";
    public static final String NIST_TEST_POLICY_5 = "2.16.840.1.101.3.2.1.48.5";
    public static final String NIST_TEST_POLICY_6 = "2.16.840.1.101.3.2.1.48.6";

    static {
        String clazz = System.getProperty("pkits.provider.class", "gnu.java.security.provider.Gnu");
        String provider2 = System.getProperty("pkits.provider", "GNU");
        try {
            if (Security.getProvider(provider2) == null) {
                Security.addProvider((Provider)Class.forName(clazz).newInstance());
            }
        }
        catch (Throwable t) {
            System.err.println("WARNING: couldn't load PKITS test provider " + provider2 + " with class " + clazz);
            System.err.println(t);
            t.printStackTrace();
        }
    }
}

