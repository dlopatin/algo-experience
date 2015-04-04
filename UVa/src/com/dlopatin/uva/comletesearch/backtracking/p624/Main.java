package com.dlopatin.uva.comletesearch.backtracking.p624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=8&page=show_problem&problem=565
*/
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().doJob();
	}

	private void doJob() throws NumberFormatException, IOException {
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

}
