package com.dlopatin.codeforce.div2.r294;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/519/problem/A the queen's weight is 9, the rook's weight is 5, the bishop's weight is
 * 3, the knight's weight is 3, the pawn's weight is 1,
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('Q', 9);
            map.put('R', 5);
            map.put('B', 3);
            map.put('N', 3);
            map.put('P', 1);
            map.put('K', 0);
            map.put('q', 9);
            map.put('r', 5);
            map.put('b', 3);
            map.put('n', 3);
            map.put('p', 1);
            map.put('k', 0);

            int white = 0;
            int black = 0;
            for (int i = 0; i < 8; i++) {
                char[] chars = scanner.next().toCharArray();
                for (int j = 0; j < 8; j++) {
                    char ch = chars[j];
                    if ('.' != ch) {
                        if (Character.isLowerCase(ch)) {
                            black += map.get(ch);
                        } else {
                            white += map.get(ch);
                        }
                    }
                }
            }
            String res = "";
            if (white == black) {
                res = "Draw";
            } else if (white > black) {
                res = "White";
            } else {
                res = "Black";
            }
            System.out.println(res);
        }
    }

}
