package com.dlopatin.uva.paradigms.dp.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=422
 * What Goes Up
 */
public class P481 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            List<Integer> seq = new ArrayList<>();
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                seq.add(parseInt(line));
            }

            List<Integer> l = new ArrayList<>();
            List<Integer> lIdx = new ArrayList<>();
            List<Integer> parentIdx = new ArrayList<>();
            int maxLisSize = 0;
            int maxLisEnd = 0;
            for (int i = 0; i < seq.size(); i++) {
                int number = seq.get(i);
                int idxToUpdate = Collections.binarySearch(l, number);
                idxToUpdate = idxToUpdate >= 0 ? idxToUpdate : -(idxToUpdate + 1);
                if (idxToUpdate >= l.size()) {
                    l.add(number);
                    lIdx.add(i);
                } else {
                    l.set(idxToUpdate, number);
                    lIdx.set(idxToUpdate, i);
                }
                parentIdx.add(idxToUpdate == 0 ? -1 : lIdx.get(idxToUpdate - 1));
                if (idxToUpdate + 1 >= maxLisSize) {
                    maxLisSize = idxToUpdate + 1;
                    maxLisEnd = i;
                }
            }

            // print result
            Deque<Integer> stack = new ArrayDeque<>();
            int x = maxLisEnd;
            stack.push(seq.get(x));
            while (parentIdx.get(x) >= 0) {
                stack.push(seq.get(parentIdx.get(x)));
                x = parentIdx.get(x);
            }
            result.append(maxLisSize).append("\n")
                    .append("-\n");
            stack.forEach(val -> result.append(val).append("\n"));
            System.out.print(result);
        }
    }

}

