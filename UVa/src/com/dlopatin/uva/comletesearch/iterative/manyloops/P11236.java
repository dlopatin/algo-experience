package com.dlopatin.uva.comletesearch.iterative.manyloops;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2177
 * Grocery store
 */
public class P11236 {

    /**
     * We have to find fourth number by formula. As we use cents and euros, it's not enough just to make next formula:
     * a+b+c+d = a*b*c*d
     * and then in answet devide each number by 100. Cause we can get 0.01 and 0.01 and in multiplication it would be
     * 100000!!!
     * Thus we have to divede each number by 100 in formula to get next equation:
     * <pre>
     *  a     b     c     d     a     b     c     d
     * ‒‒‒ + ‒‒‒ + ‒‒‒ + ‒‒‒ = ‒‒‒ * ‒‒‒ * ‒‒‒ * ‒‒‒
     * 100   100   100   100   100   100   100   100
     * </pre>
     * from this equation will get d:
     * d = ((a+b+c) * 10^6)/(abc - 10^6)
     */
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int n = 2000;
        int maxMult = 2_000_000_000; // as 2000 * 10^6, 10^6 is taken from the equation of d.
        for (int a = 1; 4 * a <= n && a * a * a * a <= maxMult; a++) {
            for (int b = a; a + 3 * b <= n && a * b * b * b <= maxMult; b++) {
                for (int c = b; a + b + 2 * c <= n && a * b * c * c <= maxMult; c++) {
                    long divider = ((long) a) * b * c - 1_000_000;
                    long sum = (a + b + c) * 1_000_000;
                    if (divider > 0 && sum % divider == 0) {
                        long d = sum / divider;
                        if (d >= c && a + b + c + d <= n) {
                            result.append(String.format("%.2f %.2f %.2f %.2f\n",
                                    a / 100.0,
                                    b / 100.0,
                                    c / 100.0,
                                    d / 100.0));
                        }
                    }
                }
            }
        }
        System.out.print(result);
    }


}
