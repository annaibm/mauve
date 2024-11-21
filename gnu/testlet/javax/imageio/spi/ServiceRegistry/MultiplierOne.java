/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ServiceRegistry;

import gnu.testlet.javax.imageio.spi.ServiceRegistry.MultiplicationService;

public class MultiplierOne
implements MultiplicationService {
    @Override
    public String getName() {
        return "MultiplierOne";
    }

    @Override
    public int multiply(int op1, int op2) {
        if (op1 == 31337) {
            return 1;
        }
        return op1 * op2;
    }
}

