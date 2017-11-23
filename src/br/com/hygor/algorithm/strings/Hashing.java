package br.com.hygor.algorithm.strings;

import java.math.BigInteger;
import java.util.Random;

public class Hashing {

    static final Random random = new Random();

    static final int MULTIPLIER         = 43;
    static final int MOD_1              = BigInteger.valueOf((int) (1e9 + random.nextInt((int) 1e9))).nextProbablePrime().intValue();
    static final int MOD_2              = BigInteger.valueOf((int) (1e9 + random.nextInt((int) 1e9))).nextProbablePrime().intValue();
    static final int INV_MULTIPLIER_1   = BigInteger.valueOf(MULTIPLIER).modInverse(BigInteger.valueOf(MOD_1)).intValue();
    static final int INV_MULTIPLIER_2   = BigInteger.valueOf(MULTIPLIER).modInverse(BigInteger.valueOf(MOD_2)).intValue();

    private long[] hash1, hash2;
    private long[] inv1, inv2;
    private int n;

    public Hashing(String s){
        n       = s.length();
        hash1   = new long[n + 1];
        hash2   = new long[n + 1];
        inv1    = new long[n + 1];
        inv2    = new long[n + 1];
        inv1[0] = 1;
        inv2[0] = 1;

        long p1 = 1;
        long p2 = 1;

        for(int i = 0; i < n; i++){
            hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % MOD_1;
            p1 = p1 * MULTIPLIER % MOD_1;
            inv1[i + 1] = inv1[i] * INV_MULTIPLIER_1 % MOD_1;
            hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % MOD_2;
            p2 = p2 * MULTIPLIER % MOD_2;
            inv2[i + 1] = inv2[i] * INV_MULTIPLIER_2 % MOD_2;
        }
    }

    public long getHash(int i, int len){
        return (((hash1[i + len] - hash1[i] + MOD_1) * inv1[i] % MOD_1) << 32)
                + (hash2[i + len] - hash2[i] + MOD_2) * inv2[i] % MOD_2;
    }

    // random test
    public static void main(String[] args) {
        Random rnd = new Random(1);
        for (int step = 0; step < 1000; step++) {
            int n1 = rnd.nextInt(50);
            String s1 = getRandomString(n1, rnd);
            int n2 = rnd.nextInt(50);
            String s2 = getRandomString(n2, rnd);
            Hashing h1 = new Hashing(s1);
            Hashing h2 = new Hashing(s2);
            for (int k = 0; k < 1000; k++) {
                int i1 = rnd.nextInt(n1 + 1);
                int j1 = rnd.nextInt(n1 - i1 + 1) + i1;
                int i2 = rnd.nextInt(n2 + 1);
                int j2 = rnd.nextInt(n2 - i2 + 1) + i2;
                if (s1.substring(i1, j1).equals(s2.substring(i2, j2)) != (h1.getHash(i1, j1 - i1) == h2.getHash(i2, j2 - i2)))
                    throw new RuntimeException();
            }
        }
    }

    static String getRandomString(int n, Random rnd) {
        char[] s = new char[n];
        for (int i = 0; i < n; i++) {
            s[i] = (char) ('a' + rnd.nextInt(3));
        }
        return new String(s);
    }

}
