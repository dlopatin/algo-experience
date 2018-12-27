package com.dlopatin.uva.paradigms.comletesearch.backtracking.harder.p416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=357
 */
public class P416 {

    private static final int[] DIGITS = new int[]{0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011, 0b1011011,
            0b1011111, 0b1110000, 0b1111111, 0b1111011};
    private static int[] invalids;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty() && !"0".equals(line)) {
                int n = parseInt(line.trim());
                int[] lights = new int[n];
                for (int i = 0; i < n; i++) {
                    int lightState = 0;
                    char[] chars = reader.readLine().toCharArray();
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
            System.out.print(result);
        }

    }

    private static boolean backtrack(int idx, int number, int[] lights) {
        if (number >= 0 && place(number, lights[idx], invalids[idx])) {
            if (idx == lights.length - 1) {
                return true;
            } else {
                return backtrack(idx + 1, --number, lights);
            }
        } else {
            return false;
        }
    }

    private static boolean place(int number, int light, int brokenSegments) {
        return (light | DIGITS[number]) == DIGITS[number] && (brokenSegments & DIGITS[number]) == 0;
    }

}
