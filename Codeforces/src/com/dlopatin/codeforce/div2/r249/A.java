package com.dlopatin.codeforce.div2.r249;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws IOException, ParseException {
        new A().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfGroups = scanner.nextInt();
            int capacity = scanner.nextInt();
            int[] a = new int[numberOfGroups];
            for (int groupIdx = 0; groupIdx < numberOfGroups; groupIdx++) {
                a[groupIdx] = scanner.nextInt();
            }
            int currentBus = 0;
            int count = 0;
            for (int groupIdx = 0; groupIdx < numberOfGroups; groupIdx++) {
                if (currentBus + a[groupIdx] <= capacity) {
                    currentBus += a[groupIdx];
                } else {
                    currentBus = a[groupIdx];
                    count++;
                }
            }
            count++;
            System.out.println(count);

        }
    }
}
