package com.dlopatin.uva.comletesearch.backtracking.harder.p416;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=357
 */
public class Main {

    private static final int[] DIGITS = new int[]{0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011, 0b1011011,
            0b1011111, 0b1110000, 0b1111111, 0b1111011};

    private int[] invalids;

    public static void main(String[] args) {
        new Main().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder result = new StringBuilder();
            int n = 0;
            while ((n = scanner.nextInt()) != 0) {
                int[] lights = new int[n];
                for (int i = 0; i < n; i++) {
                    int lightState = 0;
                    char[] chars = scanner.next().toCharArray();
                    for (int j = chars.length - 1; j >= 0; j--) {
                        if (chars[j] == 'Y') {
                            lightState |= 1 << (chars.length - 1 - j);
                        }
                    }
                    lights[i] = lightState;
                }
                invalids = new int[n];
                for (int i = invalids.length - 2; i >= 0; i--) {
                    int mask = lights[i] ^ (lights[i] | lights[i + 1] | invalids[i + 1]);
                    invalids[i] = mask;
                }
                String yesno = "MISMATCH";
                for (int i = 9; i >= lights.length - 1; i--) {
                    if (backtrack(0, i, lights)) {
                        yesno = "MATCH";
                        break;
                    }
                }
                result.append(yesno).append(System.lineSeparator());
            }
            System.out.println(result.toString().trim());
        }

    }

    private boolean backtrack(int pos, int number, int[] lights) {
        if (number >= 0 && pos <= lights.length - 1) {
            if (place(number, lights[pos], invalids[pos])) {
                if (pos == lights.length - 1) {
                    return true;
                } else {
                    return backtrack(pos + 1, --number, lights);
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean place(int number, int light, int invalids) {
        return (light | DIGITS[number]) == DIGITS[number] && (DIGITS[number] & invalids) == 0;
    }

}
