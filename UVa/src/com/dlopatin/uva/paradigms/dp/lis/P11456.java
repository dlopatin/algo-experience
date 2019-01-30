package com.dlopatin.uva.paradigms.dp.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2451
 * Trainsorting
 */
public class P11456 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int n = parseInt(reader.readLine());
                int[] data = new int[n];
                for (int i = 0; i < n; i++) {
                    data[n - 1 - i] = parseInt(reader.readLine());
                }

                int[] lis = lis(data);
                int[] lds = lds(data);
//                System.out.println(Arrays.toString(data));
//                System.out.println(Arrays.toString(lis));
//                System.out.println(Arrays.toString(lds));
                int solution = 0;
                for (int i = 0; i < n; i++) {
                    solution = Math.max(solution, lis[i] + lds[i] - 1);
                }
                result.append(solution).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int[] lis(int[] data) {
        int n = data.length;
        int[] lis = new int[n];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            int number = data[i];
            int idxToUpdate = Collections.binarySearch(l, number);
            idxToUpdate = idxToUpdate >= 0 ? idxToUpdate : -(idxToUpdate + 1);
            if (idxToUpdate >= l.size()) {
                l.add(number);
            } else {
                l.set(idxToUpdate, number);
            }
            lis[i] = idxToUpdate + 1;
        }
        return lis;
    }

    private static int[] lds(int[] data) {
        int n = data.length;
        int[] lds = new int[n];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            int number = data[i];
            int idxToUpdate = 0;
            int lo = 0;
            int hi = l.size() - 1;
            while (lo <= hi) {
                idxToUpdate = lo + (hi - lo) / 2;
                if (l.get(idxToUpdate) >= number) {
                    idxToUpdate++;
                    lo = idxToUpdate;
                } else {
                    hi = idxToUpdate - 1;
                }
            }
            if (idxToUpdate >= l.size()) {
                l.add(number);
            } else {
                l.set(idxToUpdate, number);
            }
            lds[i] = idxToUpdate + 1;
        }
        return lds;
    }
}

