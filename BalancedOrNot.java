package com.ravi.assignment;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class BalancedOrNot {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int[] isBalanced = balancedOrNot(new String[] { "<>>>", "<>>>>" },
//		 new int[] { 2, 2 });

		int[] isBalanced = balancedOrNot(new String[] { "<>", "<>><" },
				new int[] { 2, 2 });
		
		for (int i = 0; i < isBalanced.length; i++) {
			System.out.println(isBalanced[i]);
		}
	}

	static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
		int[] isBalanced = new int[expressions.length];
		char[] charArr = null;
		Map<String, Integer> expressionResult = null;

		for (int i = 0; i < expressions.length; i++) {
			charArr = expressions[i].toCharArray();
			expressionResult = balanceStack(charArr);
			isBalanced[i] = isPossibleToBalance(expressionResult,
					maxReplacements[i]);
		}

		return isBalanced;
	}

	private static Map<String, Integer> balanceStack(char[] chrArr) {
		int noOfLesser = 0, noOfGreater = 0;
		Stack<Character> expression = new Stack<>();
		Character peek = null;
		Character current = null;
		Map<String, Integer> result = new Hashtable<>();

		for (int i = 0; i < chrArr.length; i++) {
			current = chrArr[i];

			if (expression.size() > 0) {
				peek = expression.peek();
				if (peek == '<' && current == '>') {
					expression.pop();
					noOfLesser--;
				} else {
					expression.push(current);

					if (current == '>') {
						noOfGreater++;
					} else {
						noOfLesser++;
					}
				}
			} else {
				expression.push(chrArr[i]);
				if (current == '>') {
					noOfGreater++;
				} else {
					noOfLesser++;
				}
			}
		}

		result.put("noOfLesser", noOfLesser);
		result.put("noOfGreater", noOfGreater);
		// result.put("expression", expression);

		return result;
	}

	private static int isPossibleToBalance(Map<String, Integer> expression,
			int maxReplacements) {
		int noOfLesser = expression.get("noOfLesser");
		int noOfGreater = expression.get("noOfGreater");
		int isPossible = 1;

		if (noOfLesser > 0) {
			isPossible = 0;
		} else {
			if (noOfGreater > maxReplacements) {
				isPossible = 0;
			}
		}

		return isPossible;
	}
}