package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1597
 * Maximum Sum (II)
 */
public class P10656 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                int n = parseInt(line);

                StringBuilder subRes = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    int number = parseInt(reader.readLine());
                    if (number != 0) {
                        subRes.append(number).append(" ");
                    }
                }
                if (subRes.length() > 0) {
                    subRes.deleteCharAt(subRes.length() - 1);
                } else {
                    subRes.append('0');
                }
                result.append(subRes);
                result.append("\n");
            }
            System.out.print(result);
        }

    }

}
