package com.dlopatin.codeforce.div2.r270;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/472/problem/C
 */
public class C {

    public static void main(String[] args) throws IOException, ParseException {
        new C().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            String[] firstNames = new String[n];
            String[] lastNames = new String[n];
            for (int i = 0; i < n; i++) {
                firstNames[i] = scanner.next();
                lastNames[i] = scanner.next();
            }

            String lastHandle = "";
            String result = "YES";
            for (int i = 0; i < n; i++) {
                int order = scanner.nextInt() - 1;
                String fistName = firstNames[order];
                String lastName = lastNames[order];
                if (isNameAfter(lastHandle, fistName) && isNameAfter(lastHandle, lastName)) {
                    lastHandle = isNameAfter(fistName, lastName) ? fistName : lastName;
                } else if (isNameAfter(lastHandle, fistName)) {
                    lastHandle = fistName;
                } else if (isNameAfter(lastHandle, lastName)) {
                    lastHandle = lastName;
                } else {
                    result = "NO";
                    break;
                }
            }
            System.out.println(result);

        }
    }

    private boolean isNameAfter(String lastHandle, String name) {
        return lastHandle.compareTo(name) < 0;
    }

}
