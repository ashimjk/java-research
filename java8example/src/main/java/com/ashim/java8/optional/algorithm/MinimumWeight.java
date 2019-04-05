package com.ashim.java8.optional.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MinimumWeight {

	static int N;
	static int W;
	static int A;
	static int B;

	static int C[];
	static Map<String, Integer> lookup;

	static {
		lookup = new HashMap<>();
		setupTestData1();
	}

	public static void main(String[] args) {

		Node<Integer> root = new Node<>(0, 0);
		minimumWeight(0, 0, root);

//		BTreePrinter.printNode(root);

		printRoute(root);
	}

	static void printRoute(Node<Integer> root) {
		if (root.left.data > root.right.data) {
//			System.out.print("right " + root.right.data + " > ");
			System.out.println((root.right.index + 1) + "st day=eat");

			if (root.right.right != null)
				printRoute(root.right);
		} else {
//			System.out.print("left " + root.left.data + " > ");
			System.out.println((root.left.index + 1) + "st day=not eat");

			if (root.left.left != null)
				printRoute(root.left);
		}
	}

	static int minimumWeight(int level, int stressPoint, Node<Integer> node) {

		// Skips the Nth day because it will not have any children
		if (level < N) {

			int left, right;
			int returnValue;
			Integer levelValue;


			// Used to make binary tree
			Node nLeft = new Node<>(0, level);
			Node nRight = new Node<>(0, level);


			// Get value from lookup table if available
//			levelValue = lookup.get(level + "-" + stressPoint);
//			if (levelValue != null && stressPoint == 0) {
//				return levelValue;
//			}

			// Calculate minimum weight for left and right
			left = minimumWeight(level + 1, 0, nLeft);
			right = minimumWeight(level + 1, stressPoint + 1, nRight);

			// Used to make binary tree
			nLeft.data = left;
			nRight.data = right;
			node.left = nLeft;
			node.right = nRight;


			// Calculate weight based on stress point available
			levelValue = calculateWeight(level, stressPoint);


			// Verify whether eating bread is suitable or not
			if (left > right) {
				returnValue = right + levelValue;
			} else {
				returnValue = left + levelValue;
			}


			// Lookup
//			if (stressPoint == 0) {
//				lookup.put(level + "-" + stressPoint, returnValue);
//			}
			return returnValue;
		}

		// Only applicable for Nth day
		return calculateWeight(level, stressPoint);
	}

	/**
	 * Get weight based on stress point
	 *
	 * @param level
	 * @param stressPoint
	 * @return level weight if stress point is 0 else (B * stressPoint - A)
	 */
	static int calculateWeight(int level, int stressPoint) {
		if (stressPoint > 0) {
			return B * stressPoint - A;
		} else {
			return C[level];
		}
	}

	static void setupTestData1() {
		N = 5;
		W = 70;
		A = 3;
		B = 2;
		C = new int[N + 1];


		C[1] = 4;
		C[2] = 6;
		C[3] = 2;
		C[4] = 5;
		C[5] = 3;
	}

	static void setupTestData2() {
		N = 20;
		W = 70;
		A = 3;
		B = 2;
		C = new int[N + 1];

		C[1] = 4;
		C[2] = 6;
		C[3] = 2;
		C[4] = 5;
		C[5] = 3;
		C[6] = 4;
		C[7] = 5;
		C[8] = 4;
		C[9] = 1;
		C[10] = 3;
	}

}
