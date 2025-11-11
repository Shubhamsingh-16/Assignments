import java.util.*;
import java.math.BigInteger;
public class NCR {
    public static void main(String[] args) {
        NCR ncrCalculator = new NCR();
        int n = 10;
        int r = 3;
        try {
            int result = ncrCalculator.nCr(n, r);
            System.out.println("C(" + n + ", " + r + ") = " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }               
    static int nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r); // use symmetry C(n,r) = C(n, n-r)
        if (r == 0) return 1;

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= r; i++) {
            BigInteger numerator = BigInteger.valueOf(n - r + i);
            BigInteger denominator = BigInteger.valueOf(i);
            result = result.multiply(numerator).divide(denominator);
            // division is exact at every step for binomial coefficients
        }

        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        if (result.compareTo(maxInt) > 0) {
            throw new ArithmeticException("nCr result too large to fit in int: " + result);
        }
        return result.intValue();
    }
}
