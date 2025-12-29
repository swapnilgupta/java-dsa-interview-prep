package stack;

import java.util.*;

	public class AmazonFresh {

			static class Pair {
				int value, length;
				Pair(int value, int length) {
					this.value = value;
					this.length = length;
				}
			}

			public static long getOptimalStacking(List<Integer> products) {
				Stack<Pair> stack = new Stack<>();
				long curRes = 0, res = 0;

				for (int num : products) {
					int curLen = 1;
					while (!stack.isEmpty() && stack.peek().value >= num - curLen) {
						Pair prev = stack.pop();
						curLen = Math.min(curLen + prev.length, num);
						curRes -= (long) (prev.value + prev.value - prev.length + 1) * prev.length / 2;
					}
					stack.push(new Pair(num, curLen));
					curRes += (long) (num + num - curLen + 1) * curLen / 2;
					res = Math.max(res, curRes);
				}

				return res;
			}

			public static void main(String[] args) {
				List<Integer> products1 = Arrays.asList(7, 4, 5, 2, 6, 5);
				System.out.println(getOptimalStacking(products1));  // Expected Output: 12

				List<Integer> products2 = Arrays.asList(2, 5, 6,7);
				System.out.println(getOptimalStacking(products2));  // Another test case
			}
		}




