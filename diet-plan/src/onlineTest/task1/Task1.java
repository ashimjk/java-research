package onlineTest.task1;

public class Task1 {

	static int N;
	static int A;
	static int B;
	static int C[];

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

}

class Node<Integer> {
	Node<Integer> left, right;
	Integer data;
	int index;

	public Node(Integer data, int index) {
		this.data = data;
		this.index = index;
	}
}