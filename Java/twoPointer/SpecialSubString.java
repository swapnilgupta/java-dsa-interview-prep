package twoPointer;

public class SpecialSubString {
	public static int getSpecialSubstring(String s, int k, String charValue) {
		int n = s.length();
		int maxLen = 0;
		int normalCount = 0;
		int i = 0;  // Left pointer

		for (int j = 0; j < n; j++) {
			// If s[j] is a normal character, increase count
			if (charValue.charAt(s.charAt(j) - 'a') == '0') {
				normalCount++;
			}

			// If more than k normal characters, shrink the window
			while (normalCount > k) {
				if (charValue.charAt(s.charAt(i) - 'a') == '0') {
					normalCount--;
				}
				i++; // Move left pointer
			}

			// Update max length of valid substring
			maxLen = Math.max(maxLen, j - i + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String s = "giraffe";
		int k = 2;        //abcdefghijklmnopqrstuvwxyz
		String charValue = "01111001111111111011111111"; // b and d are normal

		System.out.println(getSpecialSubstring(s, k, charValue)); // Output: 5
	}

}
