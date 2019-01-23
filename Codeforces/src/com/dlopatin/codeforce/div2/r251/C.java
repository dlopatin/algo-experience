package com.dlopatin.codeforce.div2.r251;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class C {

    public static void main(String[] args) throws IOException, ParseException {
        new C().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberCount = scanner.nextInt();
            int parts = scanner.nextInt();
            int evenParts = scanner.nextInt();
            int evenCount = 0;
            int oddCount = 0;
            List<Long> even = new LinkedList<>();
            List<Long> odd = new LinkedList<>();
            for (int partIdx = 0; partIdx < numberCount; partIdx++) {
                long part = scanner.nextLong();
                if (part % 2 == 0) {
                    evenCount++;
                    even.add(part);
                } else {
                    oddCount++;
                    odd.add(part);
                }
            }
            int oddParts = parts - evenParts;
            int oddLeft = oddCount - oddParts;
            if (oddLeft >= 0 && oddLeft % 2 == 0 && oddLeft / 2 + evenCount >= evenParts) {
                System.out.println("YES");

                List<ArrayList<Long>> res = new ArrayList<ArrayList<Long>>();
                for (int oddPart = 0; oddPart < oddParts; oddPart++) {
                    ArrayList<Long> block = new ArrayList<>();
                    block.add(odd.remove(0));
                    res.add(block);
                }
                for (int evenPart = 0; evenPart < evenParts; evenPart++) {
                    ArrayList<Long> block = new ArrayList<>();
                    if (odd.size() != 0) {
                        block.add(odd.remove(0));
                        block.add(odd.remove(0));
                    } else {
                        block.add(even.remove(0));
                    }
                    res.add(block);
                }
                res.get(0).addAll(odd);
                res.get(0).addAll(even);

                StringBuilder s = new StringBuilder();
                for (ArrayList<Long> block : res) {
                    s.append(block.size());
                    for (long e : block) {
                        s.append(" ").append(e);
                    }
                    s.append("\n");
                }
                System.out.print(s.toString().trim());
            } else {
                System.out.println("NO");
            }
        }
    }

}
