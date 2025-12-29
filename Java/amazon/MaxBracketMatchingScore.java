package amazon;

import java.util.*;

public class MaxBracketMatchingScore {
	public static long maximizePairPoints(String s) {
		int n = s.length();
		int i = 0, j = n - 1; // Two pointers
		long maxScore = 0; // Use long to match the return type

		while (i < j) {
			// Move i to the next '('
			while (i < j && s.charAt(i) != '(') {
				i++;
			}
			// Move j to the next ')'
			while (i < j && s.charAt(j) != ')') {
				j--;
			}

			// Valid pair found
			if (i < j) {
				maxScore += (j - i); // Add the distance to the score
				i++; // Move i forward
				j--; // Move j backward
			}
		}

		return maxScore;
	}

	public static void main(String[] args) {
		String s = "()()";  // Example input
		System.out.println(maximizePairPoints(s));  // Expected output: 5
	}
}
