package com.dlopatin.codeforce.div3.r535;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1108/problem/D
 */
public class D {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            char[] data = reader.readLine().toCharArray();
            char[] options = new char[]{'R', 'G', 'B'};
            int cnt = 0;
            for (int i = 1; i < data.length - 1; i++) {
                if (data[i] == data[i - 1] && data[i] == data[i + 1]) {
                    cnt++;
                    for (char option : options) {
                        if (option != data[i]) {
                            data[i] = option;
                            break;
                        }
                    }
                    i++;
                }
            }
            for (int i = 1; i < data.length - 1; i += 2) {
                if (data[i] == data[i - 1] || data[i] == data[i + 1]) {
                    cnt++;
                    for (char option : options) {
                        if (option != data[i - 1] && option != data[i + 1]) {
                            data[i] = option;
                            break;
                        }
                    }
                }
            }
            if (n > 1 && data[n - 1] == data[n - 2]) {
                cnt++;
                for (char option : options) {
                    if (option != data[n - 2]) {
                        data[n - 1] = option;
                        break;
                    }
                }
            }
            System.out.printf("%d\n%s", cnt, new String(data));
        }
    }
}