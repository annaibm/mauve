/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.UUID;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.UUID;

public class TestAll
implements Testlet {
    private static final UUID[] ids = new UUID[]{new UUID(819576242563977691L, -6026651929721136538L), new UUID(2832154967796617691L, -6026651929721136538L), new UUID(3408883180598464987L, -6026651929721136538L), new UUID(3802173340188152283L, -6026651929721136538L)};
    private static final UUID[] randomIds = new UUID[]{new UUID(-3712700652812154966L, -6598749860495561479L), new UUID(664552433621420518L, -6414775468900364460L), new UUID(-5464341501079829899L, -5598482408525562595L), new UUID(-6237697930964942150L, -6792975957340980865L), new UUID(1115444745961556609L, -8924788308993396799L), new UUID(8935737015972545600L, -7709166330108105025L), new UUID(-1731090450474971506L, -8180066663887629633L), new UUID(-4352314495419070300L, -6102009369002353257L), new UUID(-2372952748710147740L, -7309989210815328856L), new UUID(-7640168945999331050L, -9131205566142177277L)};
    private static String[] strs = new String[]{"0b5fb840-1460-11db-ac5d-0800200c9a66", "274dd5f0-1460-11db-ac5d-0800200c9a66", "2f4ec931-1460-11db-ac5d-0800200c9a66", "34c40882-1460-11db-ac5d-0800200c9a66"};
    private static String[] randomStrs = new String[]{"cc79d66d-4fc5-47aa-a46c-87f6ab80ecf9", "0938f6ea-dca0-49e6-a6fa-23b2ae4dcf54", "b42ac25b-28b6-4275-b24e-31e9568f7d1d", "a96f3ec7-d0a5-42ba-a1ba-805b86ebf97f", "0f7adb16-299d-4a81-8424-c8518ae3afc1", "7c021d78-f35a-4440-9503-8a1153812ebf", "e7f9ee68-315e-4e8e-8e7a-90b583f692bf", "c3997906-a5c3-48a4-ab51-4ecf08825d97", "df11940c-2858-4964-9a8d-b38af16a0da8", "95f8aad2-adbd-4116-8147-70eab306a003"};

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("equals()");
        this.testEquals(harness);
        harness.checkPoint("randomUUID()");
        this.testRandom(harness);
        harness.checkPoint("time fields");
        this.testTime(harness);
        harness.checkPoint("toString()");
        this.testToString(harness);
        harness.checkPoint("hashCode()");
        this.testHash(harness);
        harness.checkPoint("compareTo()");
        this.testCompare(harness);
        harness.checkPoint("nameUUIDFromBytes()");
        this.testNameFromBytes(harness);
        harness.checkPoint("fromString()");
        this.testFromString(harness);
    }

    private void testNameFromBytes(TestHarness harness) {
        UUID id1 = new UUID(8833946387751055799L, -7161481369492758254L);
        UUID id2 = UUID.nameUUIDFromBytes(new byte[]{80, 43});
        harness.check(id1.equals(id2));
        id1 = new UUID(5637592221686249917L, -5921171958455577142L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{114, 45});
        harness.check(id1.equals(id2));
        id1 = new UUID(-4355869889751467654L, -7258896509850702779L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{36, 32, -84, -86, -2, -32});
        harness.check(id1.equals(id2));
        id1 = new UUID(-5236193865575288109L, -8631150049002629651L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{79, -61, -63, 12});
        harness.check(id1.equals(id2));
        id1 = new UUID(6892210306406430384L, -8874384750029244307L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{-97, -62, -111, 7, 79, 81, 95});
        harness.check(id1.equals(id2));
        id1 = new UUID(-1760792916171804329L, -7690807811470976644L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{44, 67, 23, -70, -117, 59, -65, 77, 20});
        harness.check(id1.equals(id2));
        id1 = new UUID(-8248928743552566013L, -8885233673248765009L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{-124, -106, -53, 54, 68, 31, 48, -48});
        harness.check(id1.equals(id2));
        id1 = new UUID(-3367149413545070022L, -6453356609274991779L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{63});
        harness.check(id1.equals(id2));
        id1 = new UUID(-1846445036491163506L, -6140770342100802383L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{-40, 9, 56, -18, -32, -19, -3});
        harness.check(id1.equals(id2));
        id1 = new UUID(-7426333540612096407L, -9029142625441791623L);
        id2 = UUID.nameUUIDFromBytes(new byte[]{86, -125, -55});
        harness.check(id1.equals(id2));
        id1 = new UUID(-3162216497309273596L, -6232971331865394562L);
        id2 = UUID.nameUUIDFromBytes(new byte[0]);
        harness.check(id1.equals(id2));
    }

    private void testFromString(TestHarness harness) {
        int i;
        for (i = 0; i < ids.length; ++i) {
            harness.check(ids[i].equals(UUID.fromString(strs[i])));
        }
        for (i = 0; i < randomIds.length; ++i) {
            harness.check(randomIds[i].equals(UUID.fromString(randomStrs[i])));
        }
    }

    private void testToString(TestHarness harness) {
        int i;
        for (i = 0; i < ids.length; ++i) {
            harness.check(ids[i].toString().equals(strs[i]));
        }
        for (i = 0; i < randomIds.length; ++i) {
            harness.check(randomIds[i].toString().equals(randomStrs[i]));
        }
    }

    private void testHash(TestHarness harness) {
        int[] hashes = new int[]{-1821492227, -1082370483, -1216394612, -1393194177};
        for (int i = 0; i < ids.length; ++i) {
            harness.check(ids[i].hashCode(), hashes[i]);
        }
    }

    private void testCompare(TestHarness harness) {
        for (int i = 0; i < ids.length; ++i) {
            UUID id = new UUID(ids[i].getMostSignificantBits(), ids[i].getLeastSignificantBits());
            for (int j = 0; j < ids.length; ++j) {
                int c1 = id.compareTo(ids[j]);
                int c2 = i < j ? -1 : (i > j ? 1 : 0);
                harness.check(c1, c2);
            }
        }
    }

    private void testRandom(TestHarness harness) {
        UUID id = UUID.randomUUID();
        harness.check(id.variant(), 2);
        harness.check(id.version(), 4);
    }

    private void testTime(TestHarness harness) {
        long[] vals = new long[]{2L, 1L, 133723016677800000L, 11357L, 8796630719078L, 2L, 1L, 133723017146390000L, 11357L, 8796630719078L, 2L, 1L, 133723017280670001L, 11357L, 8796630719078L, 2L, 1L, 133723017372240002L, 11357L, 8796630719078L};
        for (int i = 0; i < ids.length; ++i) {
            harness.check((long)ids[i].variant(), vals[i * 5]);
            harness.check((long)ids[i].version(), vals[i * 5 + 1]);
            harness.check(ids[i].timestamp(), vals[i * 5 + 2]);
            harness.check((long)ids[i].clockSequence(), vals[i * 5 + 3]);
            harness.check(ids[i].node(), vals[i * 5 + 4]);
        }
    }

    private void testEquals(TestHarness harness) {
        for (int i = 0; i < ids.length; ++i) {
            UUID id = new UUID(ids[i].getMostSignificantBits(), ids[i].getLeastSignificantBits());
            for (int j = 0; j < ids.length; ++j) {
                harness.check(id.equals(ids[j]) == (i == j));
            }
        }
    }
}

