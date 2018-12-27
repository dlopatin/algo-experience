package com.dlopatin.uva.paradigms.comletesearch.backtracking.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=8&page=show_problem&problem=565
 */
public class P624 {

    public static void main(String[] args) throws NumberFormatException, IOException {
//        iterativeCompleteSearch();
        recursiveBacktracking();
    }

    private static void iterativeCompleteSearch() throws NumberFormatException, IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                StringTokenizer data = new StringTokenizer(line);
                int typeMinutes = Integer.parseInt(data.nextToken());
                int tracksNumber = Integer.parseInt(data.nextToken());
                int[] tracks = new int[tracksNumber];
                for (int i = 0; i < tracksNumber; i++) {
                    tracks[i] = Integer.parseInt(data.nextToken());
                }
                int tracksToSelect = 0;
                int optimalMunites = 0;
                int optimalTracksCnt = 0;
                for (int mask = 0; mask < (1 << tracksNumber); mask++) {
                    int tracksMinutes = 0;
                    int tracksCnt = 0;
                    for (int i = 0; i < tracks.length; i++) {
                        if ((mask & (1 << i)) != 0) {
                            tracksMinutes += tracks[i];
                            tracksCnt++;
                        }
                        if (tracksMinutes > typeMinutes) {
                            break;
                        }
                    }
                    if (tracksMinutes <= typeMinutes && optimalMunites <= tracksMinutes) {
                        if (optimalMunites < tracksMinutes) {
                            optimalMunites = tracksMinutes;
                            tracksToSelect = mask;
                            optimalTracksCnt = tracksCnt;
                        } else if (optimalTracksCnt < tracksCnt) {
                            optimalTracksCnt = tracksCnt;
                            tracksToSelect = mask;
                        }
                    }
                }
                for (int i = 0; i < tracks.length; i++) {
                    if ((tracksToSelect & (1 << i)) != 0) {
                        result.append(tracks[i]).append(" ");
                    }
                }
                result.append("sum:").append(optimalMunites).append(System.lineSeparator());
            }
            System.out.println(result.toString().trim());
        }

    }

    private static int[] tracks;
    private static boolean[] used;
    private static boolean[] bestUsed;
    private static int bestCapacity = Integer.MAX_VALUE;
    private static int[][] dp;

    private static void recursiveBacktracking() throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer data = new StringTokenizer(line);
                int typeMinutes = Integer.parseInt(data.nextToken());
                int tracksNumber = Integer.parseInt(data.nextToken());
                tracks = new int[tracksNumber];
                int trackLengthSum = 0;
                for (int i = 0; i < tracksNumber; i++) {
                    int trackLength = Integer.parseInt(data.nextToken());
                    tracks[i] = trackLength;
                    trackLengthSum += trackLength;
                }

                used = new boolean[tracksNumber];
                bestCapacity = Integer.MAX_VALUE;
                int capacity = Math.min(typeMinutes, trackLengthSum);
                backtrack(tracksNumber - 1, capacity);

                for (int i = 0; i < bestUsed.length; i++) {
                    if (bestUsed[i]) {
                        result.append(tracks[i]).append(" ");
                    }
                }
                result.append("sum:").append(capacity - bestCapacity).append(System.lineSeparator());
            }
            System.out.print(result);
        }

    }

    private static void backtrack(int idx, int leftCapacity) {
        if (leftCapacity < bestCapacity) {
            bestUsed = Arrays.copyOf(used, used.length);
            bestCapacity = leftCapacity;
        }
        if (idx < 0 || leftCapacity == 0) {
            return;
        }
        if (tracks[idx] > leftCapacity) {
            // current case not suitable by length: don't take current element and check another
            backtrack(idx - 1, leftCapacity);
        } else {
            backtrack(idx - 1, leftCapacity); // try don't take current element
            used[idx] = true;
            backtrack(idx - 1, leftCapacity - tracks[idx]); // try to take current element
            used[idx] = false;
        }
    }

// alternative way from Ruslan
/*    private static void backtrack(int cur, int[] data, int limit, Res rs) {
        for (int i = cur; i < data.length; ++i) {
            if (data[i] + rs.curSum <= limit) {
                rs.curTracks |= (1 << i);
                rs.curSum += data[i];
                if (rs.curSum > rs.sum) {
                    rs.sum = rs.curSum;
                    rs.tracks = rs.curTracks;
                }
                backtrack(i + 1, data, limit, rs);
                rs.curTracks ^= (1 << i);
                rs.curSum -= data[i];
            }
        }
    }*/

}
