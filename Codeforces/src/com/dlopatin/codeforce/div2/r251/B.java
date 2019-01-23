package com.dlopatin.codeforce.div2.r251;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int subjectsCount = scanner.nextInt();
            int learningTime = scanner.nextInt();
            Integer time[] = new Integer[subjectsCount];
            long totalTime = 0;
            for (int subject = 0; subject < subjectsCount; subject++) {
                time[subject] = scanner.nextInt();
            }
            Arrays.sort(time);
            for (int subject = 0; subject < subjectsCount; subject++) {
                totalTime += (long) learningTime * time[subject];
                if (learningTime > 1) {
                    learningTime--;
                }
            }
            System.out.println(totalTime);
        }
    }
}
