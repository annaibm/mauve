/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidkeyUsageCriticalcRLSignFalseTest4
extends BaseInvalidTest {
    public InvalidkeyUsageCriticalcRLSignFalseTest4() {
        super(new String[]{"data/certs/InvalidkeyUsageCriticalcRLSignFalseTest4EE.crt", "data/certs/keyUsageCriticalcRLSignFalseCACert.crt"}, new String[]{"data/crls/keyUsageCriticalcRLSignFalseCACRL.crl"});
    }
}

