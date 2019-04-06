package com.ashim;

public class MinimumWeight {

	static int N;
	static int W;
	static int A;
	static int B;

	static int C[];

	static {
		setupTestData2();
	}

	public static void main(String[] args) {

		Node<Integer> root = new Node<>(0, 0);
		long milli = System.currentTimeMillis();
		minimumWeight(0, 0, root);
		System.out.println("Time : " + (System.currentTimeMillis() - milli));
		//		com.ashim.BTreePrinter.printNode(root);

		printDietPlan(root);
	}

	/**
	 * Print diet plan
	 *
	 * @param node
	 */
	static void printDietPlan(Node<Integer> node) {
		if (node.left.data > node.right.data) {
			System.out.println((node.right.index + 1) + "st day=not eat");

			if (node.right.right != null) {
				printDietPlan(node.right);
			}
		} else {
			System.out.println((node.left.index + 1) + "st day=eat");

			if (node.left.left != null) {
				printDietPlan(node.left);
			}
		}
	}

	/**
	 * Construct tree for minimum weight plan
	 *
	 * @param level
	 * @param stressPoint
	 * @param node
	 * @return
	 */
	static int minimumWeight(int level, int stressPoint, Node<Integer> node) {

		// Skips the Nth day because it will not have any children
		if (level < N) {

			int left, right;
			int returnValue;
			Integer levelValue;


			// Used to make binary tree
			Node nLeft = new Node<>(0, level);
			Node nRight = new Node<>(0, level);


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

	/**
	 * Initialize onlineTest data
	 */
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

	/**
	 * Initialize onlineTest data
	 */
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
		C[11] = 4;
		C[12] = 3;
		C[13] = 2;
		C[14] = 1;
		C[15] = 2;
		C[16] = 1;
		C[17] = 4;
		C[18] = 2;
		C[19] = 1;
		C[20] = 3;
	}

}
