/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidkeyUsageNotCriticalTest3
extends BaseValidTest {
    public ValidkeyUsageNotCriticalTest3() {
        super(new String[]{"data/certs/ValidkeyUsageNotCriticalTest3EE.crt", "data/certs/keyUsageNotCriticalCACert.crt"}, new String[]{"data/crls/keyUsageNotCriticalCACRL.crl"});
    }
}

