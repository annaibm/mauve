/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class MissingCRLTest1
extends BaseInvalidTest {
    public MissingCRLTest1() {
        super(new String[]{"data/certs/InvalidMissingCRLTest1EE.crt", "data/certs/NoCRLCACert.crt"}, new String[0]);
    }
}

