package org.test.permutation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ArrayPermutation {

	public static void main(String[] args) throws IOException {
		ArrayPermutation obj = new ArrayPermutation();
		obj.doJob();
//		StringBuilder res = new StringBuilder();
//		obj.perm(new String[] { "1", "2", "3" }, res, 3);
//		System.out.println(res);

	}

	private void doJob() throws IOException {
		String[] arr1 = new String[] { "Arr1" };
		String[] arr2 = new String[] { "free", "download", "full", "version", "game", "torrent", "load" };
		String[] arr3 = new String[] { "android", "mobile", "pe", "pc", "computer", "pocket edition", "ios", "apple" };
		String[] arr4 =
				new String[] { "1.0.1", "1.0.0", "1.1", "1.2.5", "1.2.4", "1.2.3", "1.2.2", "1.2.1", "1.3.2", "1.3.1",
						"1.4.7", "1.4.6", "1.4.5", "1.4.4", "1.4.2", "1.5.2", "1.5.1", "1.5", "1.6.4", "1.6.2",
						"1.6.1", "1.7.10", "1.7.9", "1.7.8", "1.7.7", "1.7.6", "1.7.5", "1.7.4", "1.7.2", "1.8.9",
						"1.8.8", "1.8.7", "1.8.6", "1.8.5", "1.8.4", "1.8.3", "1.8.2", "1.8.1", "1.8", "1.9.4",
						"1.9.3", "1.9.2", "1.9.1", "1.9", "1.10.2", "1.10.1", "1.10" };
		String[] arr5 =
				new String[] { "June 23, 2016", "June 22, 2016", "June 8, 2016", "May 10, 2016", "March 30, 2016",
						"February 29, 2016", "December 9, 2015", "July 27, 2015", "June 2, 2015", "May 22, 2015",
						"April 30, 2015", "April 17, 2015", "February 19, 2015", "November 24, 2014",
						"September 2, 2014", "June 26, 2014", "April 14, 2014", "April 11, 2014", "April 9, 2014",
						"February 26, 2014", "December 10, 2013", "October 25, 2013", "September 29, 2013",
						"July 8, 2013", "July 1, 2013", "May 2, 2013", "March 21, 2013", "March 13, 2013",
						"January 9, 2013", "December 20, 2012", "November 20, 2012", "November 14, 2012",
						"October 25, 2012", "August 16, 2012", "August 1, 2012", "April 4, 2012", "March 22, 2012",
						"March 2, 2012", "March 1, 2012", "January 12, 2012", "November 24, 2011", "November 18, 2011" };

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("permut.out"))) {
			StringBuilder res = new StringBuilder();

			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					for (int k = 0; k < arr3.length; k++) {
						for (int l = 0; l < arr4.length; l++) {
							for (int m = 0; m < arr5.length; m++) {
								perm(new String[] { arr1[i], arr2[j], arr3[k], arr4[l], arr5[m] }, writer, 5);
							}
						}
					}
				}
			}
		}
//		System.out.println(res);
//		System.out.println(counter);

	}

	private void perm(String[] array, BufferedWriter writer, int idx) throws IOException {
		if (idx <= 0) {
			writer.write(Arrays.toString(array));
			writer.newLine();
//			System.out.println(Arrays.toString(array));
//			res.append(Arrays.toString(array)).append("\n");
		} else {
			perm(array, writer, idx - 1);
			int currPos = array.length - idx;
			for (int i = currPos + 1; i < array.length; i++) {// start swapping all other chars with current first char
				swap(array, currPos, i);
				perm(array, writer, idx - 1);
				swap(array, i, currPos);// restore back my string buffer
			}
		}
	}

	private <T> void swap(T[] n, int i, int m) {
		T temp = n[m];
		n[m] = n[i];
		n[i] = temp;
	}

}
