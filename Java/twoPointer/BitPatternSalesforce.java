package twoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitPatternSalesforce {
	public static List<String> bitPattern(List<Integer> num) {
		int n = num.size();
		Map<Integer, Integer> leftCount = new HashMap<>();
		Map<Integer, Integer> rightCount = new HashMap<>();
		StringBuilder leftBitPattern = new StringBuilder();
		StringBuilder rightBitPattern = new StringBuilder();

		// Populate rightCount map with the frequency of each number
		for (int val : num) {
			rightCount.put(val, rightCount.getOrDefault(val, 0) + 1);
		}

		// Iterate through num to compute bit patterns
		for (int i = 0; i < n; i++) {
			int val = num.get(i);

			// Check if val exists in leftCount
			if (leftCount.containsKey(val)) {
				leftBitPattern.append('1');
			} else {
				leftBitPattern.append('0');
			}

			// Remove current value from rightCount
			rightCount.put(val, rightCount.get(val) - 1);
			if (rightCount.get(val) == 0) {
				rightCount.remove(val);
			}

			// Check if val exists in rightCount
			if (rightCount.containsKey(val)) {
				rightBitPattern.append('1');
			} else {
				rightBitPattern.append('0');
			}

			// Add current value to leftCount
			leftCount.put(val, leftCount.getOrDefault(val, 0) + 1);
		}

		return Arrays.asList(leftBitPattern.toString(), rightBitPattern.toString());
	}

	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1, 2, 3, 2, 1);
		System.out.println(bitPattern(num));


	}

}
