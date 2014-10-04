package com.dlopatin.topcoder.srm635;

public class IdentifyingWood {

	public String check(String s, String t) {
		String res = "Yep, it's wood.";
		char[] first = s.toCharArray();
		char[] second = t.toCharArray();
		int nextAt = 0;
		for (int i = 0; i < second.length; i++) {
			char ch = second[i];
			boolean found = false;
			for (int j = nextAt; j < first.length; j++) {
				if (ch == first[j]) {
					nextAt = j + 1;
					found = true;
					break;
				}
			}
			if (!found) {
				return "Nope.";
			}

		}
		return res;
	}

}
